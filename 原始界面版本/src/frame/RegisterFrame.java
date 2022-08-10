package lab1.frame;

import lab1.beans.User;
import lab1.dao.impl.UserDaoImpl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {
    JTextField idf;
    JPasswordField pwdf1;
    JPasswordField pwdf2;
    JButton register;
    JButton reset;
    JButton cancel;
    public RegisterFrame(){
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JLabel id = new JLabel("账户：");
        JLabel pwd1 = new JLabel("密码：");
        JLabel pwd2 = new JLabel("再次输入密码：");

        idf = new JTextField(15);
        pwdf1 = new JPasswordField(15);
        pwdf2 = new JPasswordField(15);
        register = new JButton("注册");
        reset = new JButton("重置");
        cancel = new JButton("取消");

        //注册事件
        register.addActionListener(new RegisterAction(this));
        reset.addActionListener(new RegisterAction(this));
        cancel.addActionListener(new RegisterAction(this));
        //布局
        panel1.add(id);
        panel1.add(idf);
        panel2.add(pwd1);
        panel2.add(pwdf1);
        panel3.add(pwd2);
        panel3.add(pwdf2);
        panel4.add(register);
        panel5.add(reset);
        panel5.add(cancel);
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        setTitle("注册");
        setLayout(new GridLayout(5,2));
        setBounds(200,200,400,250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
class RegisterAction implements ActionListener{
    private RegisterFrame frame;
    public RegisterAction(RegisterFrame frame){
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frame.register){
            String name = frame.idf.getText();
            String pwd1 = new String(frame.pwdf1.getPassword());
            String pwd2 = new String(frame.pwdf2.getPassword());
            if(!name.equals("") &&pwd1.equals(pwd2)){//id不为空且两次密码相同
                //注册
                //创建账号对象
                User user = new User();
                //在数据库中插入新空用户，自动生成ID序列号
                UserDaoImpl udi = new UserDaoImpl();
                udi.createNewUser();//创建新用户
                int serialnum = udi.getSerial();//获取序列号
                // 使用ID序列号生成ID账号
                String id1 = String.format("%06d",serialnum);//将结果用零来填充6位
                //创建新用户ID
                user.setId(id1);
                //在数据库中添加账号的ID
                udi.addUser(id1,serialnum);
                user.setName(name);
                user.setPassword(pwd1);
                user.setBalance(0);
                udi.updataUser(user);//更新用户到数据库
                JOptionPane.showMessageDialog(null,"注册成功");
            }else if(name.equals("")||pwd1.equals("")||pwd2.equals("")){
                JOptionPane.showMessageDialog(null,"账户密码不能为空!");
            }else if(!pwd1.equals(pwd2)){
                JOptionPane.showMessageDialog(null,"两次输入的密码必须相同!");
            }
        }else if(e.getSource()==frame.reset){
            //重置
            frame.idf.setText("");
            frame.pwdf1.setText("");
            frame.pwdf2.setText("");
        }else if(e.getSource()==frame.cancel){
            //销毁此窗口
            frame.dispose();
        }

    }
}