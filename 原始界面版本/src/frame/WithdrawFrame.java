package lab1.frame;

import lab1.beans.User;
import lab1.dao.impl.UserDaoImpl;
import lab1.utils.GuiUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawFrame extends JFrame {
    User user1;
    UserDaoImpl udi;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JLabel title;
    JTextField withdrawmoney;
    JButton button;
    public WithdrawFrame(User user){
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        button = new JButton("确定");
        Font font = new Font("宋体",Font.PLAIN,20);
        title = new JLabel("请输入您的取款金额");
        title.setFont(font);
        withdrawmoney = new JTextField(15);
        panel1.add(title);
        panel2.add(withdrawmoney);
        panel3.add(button);
        add(panel1);
        add(panel2);
        add(panel3);
        setTitle("取款");
        setBounds(300,200,300,200);
        setLayout(new GridLayout(3,1));
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //注册事件
        button.addActionListener(new WithdrawAction(this));
        user1 = user;
        udi = new UserDaoImpl();
    }
}
class WithdrawAction implements ActionListener{
    private WithdrawFrame frame;
    public WithdrawAction(WithdrawFrame frame){
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frame.button){
            String str = frame.withdrawmoney.getText();
            if(str.equals("")){
                JOptionPane.showMessageDialog(null,"请输入要取款的余额。");
            }else{
                GuiUtil.digit(str);
                if(!GuiUtil.k){
                    double numb = Double.parseDouble(str);
                    frame.user1.setBalance(frame.user1.getBalance()-numb);
                    frame.udi.updataUser(frame.user1);
                    TradeMenuFrame.jTextArea.append("\n您成功取款："+numb+"元。");
                    frame.dispose();
                    JOptionPane.showMessageDialog(null,"您成功取款"+numb+"元。");
                }
                GuiUtil.k = false;
            }
        }
    }
}
