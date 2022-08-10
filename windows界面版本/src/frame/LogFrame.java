package frame;

import beans.User;
import dbutils.DBHelper;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class LogFrame extends JFrame {

    Vector rowData,columnNames;
    JTable jt;
    JScrollPane jsp;

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public LogFrame(User user) {
        //存放列名
        columnNames = new Vector();
        columnNames.add("userId");
        columnNames.add("times");
        columnNames.add("logContext");
        //rowData用来存放行数据
        rowData = new Vector();
        //表格添加内容
        try {
            conn = DBHelper.getConn();
            ps = conn.prepareStatement("SELECT * FROM logs WHERE userId='" + user.getId() + "';");
            rs = ps.executeQuery();

            while (rs.next()) {
                Vector hang = new Vector();
                hang.add(rs.getString("userId"));
                hang.add(rs.getString("times"));
                hang.add(rs.getString("logContext"));
                //加入到rowData
                rowData.add(hang);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in User Grid View..... " + e);
        }finally{
            DBHelper.closeAll(conn,ps,rs);
        }

        jt = new JTable(rowData,columnNames);
        jsp = new JScrollPane(jt);
        add(jsp);

        setTitle("日志");
        pack();
        setVisible(true);
        setBounds(360, 280, 670, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}


    

