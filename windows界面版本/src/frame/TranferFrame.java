package frame;

import beans.User;
import dao.impl.UserDaoImpl;
import style.WindowsStyle;
import utils.GuiUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TranferFrame extends JFrame {
    User user1;//当前用户
    User user2;//被转账用户
    UserDaoImpl udi;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JLabel title;
    JLabel id;
    JLabel name;
    JTextField idt;
    JTextField namet;
    JTextField tranfermoney;
    JButton button;
    public TranferFrame(User user) {
        new WindowsStyle();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        button = new JButton("确定");
        button.setBackground(Color.cyan);
        id = new JLabel("  用户id:");
        name = new JLabel(" 用户名：");
        idt = new JTextField(15);
        namet = new JTextField(15);
        title = new JLabel("转账金额:");
        tranfermoney = new JTextField(15);
        panel1.add(title);
        panel1.add(tranfermoney);
        panel2.add(id);
        panel2.add(idt);
        panel3.add(name);
        panel3.add(namet);
        panel4.add(button);
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        setTitle("转账");
        setBounds(550, 350, 350, 230);
        setLayout(new GridLayout(4, 1));
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //注册事件
        button.addActionListener(new TranferAction(this));
        user1 = user;
        udi = new UserDaoImpl();
    }
}
class TranferAction implements ActionListener {
    private TranferFrame frame;
    public TranferAction(TranferFrame frame){
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frame.button){
            String str_id = frame.idt.getText();
            String str_name = frame.namet.getText();
            String str_money = frame.tranfermoney.getText();
            double numb=0;
            //验证输入的转账金额格式是否正确
            if(str_id.equals("")||str_name.equals("")){
                JOptionPane.showMessageDialog(null,"输入错误！");
            }else{
                GuiUtil.digit(str_money);
                if(!GuiUtil.k){
                    numb = Double.parseDouble(str_money);
                    frame.user2 = frame.udi.findUserbyId(str_id);//得到被转账的用户
                    if(frame.user2.getName().equals(str_name)&&frame.user2.getId().equals(str_id)){
                        frame.user1.setBalance(frame.user1.getBalance()-numb);
                        frame.user2.setBalance(frame.user2.getBalance()+numb);
                        frame.udi.updataUser(frame.user1);
                        frame.udi.updataUser(frame.user2);
                        JOptionPane.showMessageDialog(null,"成功转账"+numb+"元给用户"+str_name);
                        frame.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,"账号id与用户名不匹配");
                    }
                }
                GuiUtil.k = false;
            }
        }
    }
}
















