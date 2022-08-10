package frame;

import beans.User;
import style.WindowsStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TradeMenuFrame extends JFrame {
    User user1;
    JButton check;
    JButton withdraw;
    JButton deposit;
    JButton transfer;
    JButton log;
    JButton exit;
    JButton help;
    JButton put;
    static JTextArea screen;

    public TradeMenuFrame(User user){
        new WindowsStyle();
        user1 = user;

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        Font buttonFont=new Font("华文行楷",Font.BOLD,18);
        Font tableFont = new Font("华文行楷", Font.PLAIN, 46);
        JLabel name = new JLabel("在线交易菜单",JLabel.CENTER);
        name.setFont(tableFont);
        screen = new JTextArea();
        screen.setLineWrap(true);

        setTitle("在线交易菜单");
        setBounds(250, 180, 900, 550);
        setLayout(new BorderLayout());

        check = new JButton("查询余额");
        withdraw = new JButton("取款");
        deposit = new JButton("存款");
        transfer = new JButton("转账");
        log = new JButton("日志");
        exit = new JButton("退出");
        help = new JButton("帮助");
        put = new JButton("导出日志");
        //设置按钮背景颜色
        check.setBackground(Color.cyan);
        withdraw.setBackground(Color.cyan);
        deposit.setBackground(Color.cyan);
        transfer.setBackground(Color.cyan);
        log.setBackground(Color.cyan);
        exit.setBackground(Color.cyan);
        help.setBackground(Color.cyan);
        put.setBackground(Color.cyan);

        check.setFont(buttonFont);
        withdraw.setFont(buttonFont);
        deposit.setFont(buttonFont);
        transfer.setFont(buttonFont);
        log.setFont(buttonFont);
        exit.setFont(buttonFont);
        help.setFont(buttonFont);
        put.setFont(buttonFont);

        //注册监听器
        check.addActionListener(new TradeMenuAction(this));
        withdraw.addActionListener(new TradeMenuAction(this));
        deposit.addActionListener(new TradeMenuAction(this));
        transfer.addActionListener(new TradeMenuAction(this));
        log.addActionListener(new TradeMenuAction(this));
        exit.addActionListener(new TradeMenuAction(this));
        help.addActionListener(new TradeMenuAction(this));
        put.addActionListener(new TradeMenuAction(this));

        //布局
        panel1.setLayout(new GridLayout(6,1,10,50));
        panel1.add(check);
        panel1.add(withdraw);
        panel1.add(deposit);
        panel1.add(transfer);

        panel2.setLayout(new GridLayout(6,1,10,50));
        panel2.add(exit);
        panel2.add(log);
        panel2.add(put);
        panel2.add(help);

        add(name,BorderLayout.NORTH);
        add(panel1,BorderLayout.WEST);
        add(screen,BorderLayout.CENTER);
        add(panel2,BorderLayout.EAST);
        //add(exit,BorderLayout.SOUTH);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        if(e.getSource()==frame.check){
            frame.screen.append("您的余额为："+frame.user1.getBalance()+"元。\n");
        }
        //取款
        else if(e.getSource()==frame.withdraw){
            new WithdrawFrame(frame.user1);
        }
        //存款
        else if(e.getSource()==frame.deposit){
            new DepositFrame(frame.user1);
        }
        //转账
        else if(e.getSource()==frame.transfer){
            new TranferFrame(frame.user1);
        }
        //查看帮助手册
        else if(e.getSource()==frame.help){
            new HelpFrame();
            /*frame.screen.append("\n******欢迎来到自助在线业务系统******\n");
            frame.screen.append("        \t1.关于注册\n");
            frame.screen.append("        \t2.关于登录\n");
            frame.screen.append("        \t3.关于转账\n");
            frame.screen.append("        \t 如有问题请致电139xxxxxxxxx\n");
            frame.screen.append("**********************************\n");*/
        }
        //退出
        else if(e.getSource()==frame.exit){
            frame.dispose();
        }
        //日志
        else if(e.getSource()==frame.log){
            new LogFrame(frame.user1);
        }
        //导出日志
        else if(e.getSource()==frame.put){
            try {
                new OutputExcel(frame.user1);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

