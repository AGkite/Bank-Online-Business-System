package lab1.dao.impl;

import lab1.beans.User;
import lab1.dao.UserDao;
import lab1.dbutils.DBHelper;
import java.sql.*;

public class UserDaoImpl implements UserDao {
/**
 * 根据id查找数据库中的账号
 * @param id
 * @return 返回对应id账号的User对象，如果不存在返回null
 *
 * */
    @Override
    public User findUserbyId(String id) {
        if(id == null){
            return null;
        }
        Connection conn = DBHelper.getConn();
        String sql = "select * from User WHERE id='" + id + "';";
        PreparedStatement stat = null;
        ResultSet rs = null;
        User u = new User();
        try {
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()) {
                u.setId(rs.getString("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                u.setBalance(rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(conn,stat,rs);
        }
        if (u.getId().equals(" "))
            return null;
        else
            return u;
    }
//插入空账号，用于注册
    @Override
    public void createNewUser() {
        Connection conn = DBHelper.getConn();
        String sql = "INSERT User (id,name,password,balance) VALUES(null,null,null,null); ";
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(sql);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(conn,stat,rs);
        }
    }
    /*
    * 设置空账号，用于注册，正式添加用户
    * @param id         根据序列号生成的ID账号
    * @param serialNm
    * */
    @Override
    public void addUser(String id, int serialNum) {
        Connection conn = DBHelper.getConn();
        String sql = "UPDATE User SET id='" + id + "' WHERE serialnum ='" + serialNum + "';";
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(sql);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(conn,stat,rs);
        }
    }
    /*
    * 更新指定user的所有数据
    * @param user 已设定号数据的user对象
    * */
    @Override
    public void updataUser(User user) {
        Connection conn = DBHelper.getConn();
        String sql = "UPDATE User SET name='" + user.getName() +
                "',password='" + user.getPassword() + "',balance=" +
                user.getBalance() + "WHERE id ='" + user.getId() + "';";
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(sql);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(conn,stat,rs);
        }
    }
    /*
    * 获取空账号的ID序列，用于注册，定位空账号
    * @return 空账号的ID序列号
    * */
    @Override
    public int getSerial() {
        int serialNum = 0;
        Connection conn = DBHelper.getConn();
        String sql = "select * from User where id is null ;";
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()) {
                serialNum = rs.getInt("serialnum");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(conn,stat,rs);
        }
        return serialNum;
    }
}
