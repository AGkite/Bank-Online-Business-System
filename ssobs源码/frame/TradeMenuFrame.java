package lab1.frame;

import lab1.beans.User;
import lab1.utils.DateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;

public class TradeMenuFrame extends JFrame {
    /*User user1;
    JButton check;
    JButton withdraw;
    JButton deposit;
    JButton tranfer;
    JButton log;
    JButton exit;
    JButton help;
    static JTextArea screen;

    public TradeMenuFrame(User user){
        user1 = user;
        setLayout(new BorderLayout());

        JPanel panel1 = new JPanel();
        JScrollPane panel2 = new JScrollPane();

        Font font = new Font("宋体", Font.PLAIN, 25);
        JLabel name = new JLabel("交易菜单",JLabel.CENTER);
        name.setFont(font);
        screen = new JTextArea();
        
        check = new JButton("余额");
        withdraw = new JButton("取款");
        deposit = new JButton("存款");
        tranfer = new JButton("转账");
        log = new JButton("日志");
        exit = new JButton("退出");
        help = new JButton("帮助");



        //布局
        panel1.add(name);
        panel1.add(check);
        panel1.add(withdraw);
        panel1.add(deposit);
        panel1.add(tranfer);
        panel1.add(log);
        panel1.add(exit);
        panel1.add(help);
        panel2.add(screen);
        panel2.setViewportView(screen);
        add(panel1,BorderLayout.NORTH);
        add(panel2,BorderLayout.CENTER);
        setTitle("交易菜单");
        setBounds(200, 200, 500, 300);

        //pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);*/
    JButton inquire, withdrawal, deposit, transfer, log, exit, help,logOut;
    static JTextArea jTextArea;
    JLabel menu;
    User user;

    public TradeMenuFrame(User user) {
        this.user = user;
        setTitle("当前账号为：");
        this.setLayout(new BorderLayout());

        JPanel p2 = new JPanel();
        menu = new JLabel("交易菜单如下，请选择您要的操作！");
        Font font = new Font("宋体", Font.PLAIN, 20);
        menu.setFont(font);
        p2.add(menu);

        inquire = new JButton("查询余额");
        withdrawal = new JButton("取款");
        deposit = new JButton("存款");
        transfer = new JButton("转账");
        log = new JButton("查询日志");
        logOut = new JButton("导出日志");
        exit = new JButton("退出");
        help = new JButton("帮助");

        p2.add(inquire);
        p2.add(withdrawal);
        p2.add(deposit);
        p2.add(transfer);
        p2.add(log);
        p2.add(logOut);
        p2.add(exit);
        p2.add(help);

        add(p2, BorderLayout.NORTH);

        JScrollPane p3=new JScrollPane();
        jTextArea = new JTextArea();
        p3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        p3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p3.setViewportView(jTextArea);
        this.add(p3);

        setVisible(true);
        pack();
        setBounds(300, 200,900, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //注册监听器
        inquire.addActionListener(new TradeMenuAction(this));
        withdrawal.addActionListener(new TradeMenuAction(this));
        deposit.addActionListener(new TradeMenuAction(this));
        transfer.addActionListener(new TradeMenuAction(this));
        log.addActionListener(new TradeMenuAction(this));
        logOut.addActionListener(new TradeMenuAction(this));
        exit.addActionListener(new TradeMenuAction(this));
        help.addActionListener(new TradeMenuAction(this));
    }
}

class TradeMenuAction implements ActionListener{
    private TradeMenuFrame frame;
    public TradeMenuAction(TradeMenuFrame frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //查余额
        if(e.getSource()==frame.inquire){
            frame.jTextArea.append("\n您的余额为："+frame.user.getBalance()+"元。");
        }
        //取款
        else if(e.getSource()==frame.withdrawal){
            new WithdrawFrame(frame.user);
        }
        //存款
        else if(e.getSource()==frame.deposit){
            new DepositFrame(frame.user);
        }
        //转账
        else if(e.getSource()==frame.transfer){
            new TranferFrame(frame.user);
        }
        //查看帮助手册
        else if(e.getSource()==frame.help){
            frame.jTextArea.append("\n******欢迎来到自助在线业务系统******\n");
            frame.jTextArea.append("        \t1.关于注册\n");
            frame.jTextArea.append("        \t2.关于登录\n");
            frame.jTextArea.append("        \t3.关于转账\n");
            frame.jTextArea.append("        \t 如有问题请致电139xxxxxxxxx\n");
            frame.jTextArea.append("**********************************");
        }
        //退出
        else if(e.getSource()==frame.exit){
            frame.dispose();
        }
        //日志
        else if(e.getSource()==frame.log){
            new LogFrame(frame.user);
        }
        //导出日志
        else if(e.getSource()==frame.logOut){
            try {
                //调用OutputExcel类的构造方法将日志导为Excel格式
                new OutputExcel(frame.user);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

