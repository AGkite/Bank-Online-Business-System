package lab1.frame;

import lab1.beans.User;
import lab1.dao.impl.UserDaoImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.*;

public class LoginFrame extends JFrame {
    JButton loginb;
    JButton register;
    JButton exit;
    public JTextField idf;
    JPasswordField pwdf;

    public LoginFrame() {
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JLabel id = new JLabel("账户：");
        JLabel pwd = new JLabel("密码：");

        idf = new JTextField(15);
        pwdf = new JPasswordField(15);
        loginb = new JButton("登录");
        register = new JButton("注册");
        exit = new JButton("退出");

        //事件注册
        loginb.addActionListener(new LoginAction(this));
        register.addActionListener(new LoginAction(this));
        exit.addActionListener(new LoginAction(this));
        //布局
        panel1.add(id);
        panel1.add(idf);
        panel2.add(pwd);
        panel2.add(pwdf);
        panel3.add(loginb);
        panel4.add(register);
        panel4.add(exit);
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        setTitle("自助在线业务系统");
        setBounds(100, 100, 300, 200);
        setLayout(new GridLayout(4, 1));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class LoginAction implements ActionListener {
    private LoginFrame frame;
    public LoginAction(LoginFrame frame){
       this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pwd = new String(frame.pwdf.getPassword());
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.findUserbyId(frame.idf.getText());
        String strId = user.getId();
        String strpwd = user.getPassword();
        if(e.getSource()==frame.loginb){
            if(frame.idf.getText().equals(strId)&& pwd.equals(strpwd)){
                //待实现
                new TradeMenuFrame(user);
            }else if(frame.idf.getText().equals("")||pwd.equals("")){
                JOptionPane.showMessageDialog(null,"账户密码不能为空，登录失败!");
            }else{
                JOptionPane.showMessageDialog(null,"账户或密码错误，登录失败!");
            }
        }
        else if(e.getSource()==frame.register){
            new RegisterFrame();
        }
        else if(e.getSource()==frame.exit){
            int num = JOptionPane.showConfirmDialog(null,"您确定要退出在线业务系统吗？","提示",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            switch (num){
                case YES_OPTION :
                    System.exit(0);
                    break;
                case NO_OPTION:
                    break;
                case CANCEL_OPTION:
                    break;
            }
        }
    }
}
