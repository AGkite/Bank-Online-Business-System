package frame;

import beans.User;
import dao.impl.UserDaoImpl;
import style.WindowsStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.*;

public class LoginFrame extends JFrame {
    JButton loginb;
    JButton register;
    JButton exit;
    public JTextField namef;
    JPasswordField pwdf;

    public LoginFrame() {
        new WindowsStyle();
        //加载图片
        ImageIcon icon=new ImageIcon("images/13.jpg");
        //Image im=new Image(icon);
        //将图片放入label中
        JLabel label=new JLabel(icon);

        //设置label的大小
        label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());

        //JFrame frame=new JFrame();

        //获取窗口的第二层，将label放入
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));

        //获取frame的顶层容器,并设置为透明
        JPanel j=(JPanel)this.getContentPane();
        j.setOpaque(false);

        //必须设置为透明的。否则看不到图片

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel1.setOpaque(false);
        panel2.setOpaque(false);
        panel3.setOpaque(false);

        JLabel id = new JLabel("账户：");
        JLabel pwd = new JLabel("密码：");

        id.setForeground(Color.white);
        pwd.setForeground(Color.white);
        namef = new JTextField(15);
        pwdf = new JPasswordField(15);
        loginb = new JButton("登录");
        register = new JButton("注册");
        exit = new JButton("退出");

        //设置按钮背景颜色
        loginb.setBackground(Color.cyan);
        register.setBackground(Color.cyan);
        exit.setBackground(Color.cyan);

        //事件注册
        loginb.addActionListener(new LoginAction(this));
        register.addActionListener(new LoginAction(this));
        exit.addActionListener(new LoginAction(this));
        //布局
        panel1.add(id);
        panel1.add(namef);
        panel2.add(pwd);
        panel2.add(pwdf);
        panel3.add(loginb);
        panel3.add(register);
        panel3.add(exit);

        add(panel1);
        add(panel2);
        add(panel3);

        setTitle("自助在线业务系统");
        setBounds(400, 300, 450, 250);
        setLayout(new GridLayout(3,1));
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
        User user = userDao.findUserByName(frame.namef.getText());
        //String strId = user.getId();
        String strName = user.getName();
        String strpwd = user.getPassword();
        if(e.getSource()==frame.loginb){
            if(frame.namef.getText().equals(strName)&& pwd.equals(strpwd)){
                //待实现
                new TradeMenuFrame(user);
            }else if(frame.namef.getText().equals("")||pwd.equals("")){
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
