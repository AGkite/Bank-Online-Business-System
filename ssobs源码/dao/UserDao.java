package lab1.dao;

import lab1.beans.User;

public interface UserDao {
    public User findUserbyId(String id);
    public void createNewUser();//插入空账号，用于注册
    public void addUser(String id, int serialNum);
    public void updataUser(User user);
    public int getSerial();//获取空账号的ID序列，用于注册，定位空账号
}
