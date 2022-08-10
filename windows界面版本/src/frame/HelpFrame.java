package frame;

import style.WindowsStyle;

import javax.swing.*;
import java.awt.*;

public class HelpFrame extends JFrame{
    JLabel ts,xz,dh;
    JButton gyzc,gydl,gyzz;

    public HelpFrame() {
        new WindowsStyle();
        Font font=new Font("华文行楷",Font.PLAIN,12);
        this.setLayout(new GridLayout(6	, 1));
        ts=new JLabel("欢迎来到自助在线系统");
        xz=new JLabel("请选择你要的操作");
        dh=new JLabel("如果有问题请致电178XXXXXXXX");

        ts.setFont(font);
        xz.setFont(font);
        dh.setFont(font);

        gyzz=new JButton("转账");
        gyzc=new JButton("注册");
        gydl=new JButton("登录");

        //设置按钮背景颜色
        gyzz.setBackground(Color.cyan);
        gyzc.setBackground(Color.cyan);
        gydl.setBackground(Color.cyan);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();

        p1.add(ts);
        p2.add(xz);
        p3.add(gyzc);
        p4.add(gydl);
        p5.add(gyzz);
        p6.add(dh);

        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);

        setTitle("帮助");
        setVisible(true);
        setBounds(500, 300, 400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
