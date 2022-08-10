package lab1.dao.impl;

import lab1.beans.Logs;
import lab1.dao.LogDao;
import lab1.dbutils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogDaoImpl implements LogDao {
    @Override
    public List<Logs> queryLog(String userId) {
        if (userId == null) {
            return null;
        }
        Connection conn = DBHelper.getConn();
        String sql = "select * from Logs WHERE userId='" + userId + "';";
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Logs> logslist = new ArrayList<Logs>();
        //Logs log = new Logs();
        try {
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()) {
                Logs log = new Logs();
                log.setUserId(rs.getString("userId"));
                log.setTimes(rs.getString("times"));
                log.setLogContext(rs.getString("LogContext"));
                logslist.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(conn,stat,rs);
        }
        if (logslist.isEmpty())
            return null;
        else
            return logslist;
    }
    public void addLog(Logs log){
        Connection conn = DBHelper.getConn();
        String sql = "INSERT Logs (userId,times,logContext) VALUES(?,?,?);";
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(sql);
            stat.setString(1,log.getUserId());
            stat.setString(2,log.getTimes());
            stat.setString(3,log.getLogContext());
            stat.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(conn,stat,rs);
        }
    }
}
