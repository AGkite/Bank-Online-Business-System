package lab1.dbutils;
import java.sql.*;

public class DBHelper {//连接数据库
    public static  Connection conn=null;
    public static final String DRIVER="com.mysql.cj.jdbc.Driver";
    public static final String RUL="jdbc:mysql://localhost:3306/ssobs?serverTimezone=Asia/Shanghai&useSSL=true";
    public static final String DBUser="root";
    public static final String DBPassword="123456";

    public static Connection getConn() {
        try{
            Class.forName(DRIVER);
            conn= DriverManager.getConnection(RUL,DBUser,DBPassword);
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //关闭数据库连接
    public static void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(pstmt != null){
            try{
                pstmt.close();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
