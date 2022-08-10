package service;

import beans.User;
import dao.impl.UserDaoImpl;
import utils.ValidationUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import static utils.ValidationUtil.getPassword;
import static utils.ValidationUtil.getString;

public class UserService {
    public void singIn(){
        //创建账号对象
        User user = new User();
        //在数据库中插入新空用户，自动生成ID序列号
        UserDaoImpl udi = new UserDaoImpl();
        udi.createNewUser();//创建新用户
        int serialnum = udi.getSerial();//获取序列号
        // 使用ID序列号生成ID账号
        String id = String.format("%06d",serialnum);//将结果用零来填充6位
        //创建新用户ID
        user.setId(id);
        //在数据库中添加账号的ID
        udi.addUser(id,serialnum);
        System.out.println("开始用户注册，请输入你的名字：");
        //创建名字
        String userName = getString();

        //创建密码
        String userPasswd = getPassword();

        user.setName(userName);
        user.setPassword(userPasswd);
        user.setBalance(0);
        udi.updataUser(user);//更新用户到数据库
        System.out.println("用户："+userName+"注册完成！感谢使用本次银行账户。");
    }
    public User login(){
        System.out.println("请输入账号：");
        String id_login = ValidationUtil.getString();

        UserDaoImpl userdi = new UserDaoImpl();
        User user_login = userdi.findUserbyId(id_login);//id是否为账号？？？

        System.out.println("请输入密码：");
        String pws_login = ValidationUtil.getString();
        //判断账户是否存在、密码是否匹配
        if (user_login != null && user_login.getPassword().equals(pws_login)){
            System.out.println("登录成功！当前账号为："+id_login);
            //记录登录日志
            LogService.addLogs(user_login,"用户登录系统");
        } else {
            System.out.println("账号或密码错误，登录失败。");
            user_login=null;
        }
        return user_login;
    }

    public void search(User user_Login){
        System.out.println("您的余额为："+user_Login.getBalance()+"元。");
        LogService.addLogs(user_Login,"用户查询余额");
    }
    public void draw(User user_Login){
        System.out.println("请输入取款金额：");
        //输入取款金额，并做非数字的判断
        double money_draw = 0;
        money_draw = ValidationUtil.get();
        if (user_Login.getBalance() >= money_draw) {
            //取款操作
            user_Login.setBalance(user_Login.getBalance()-money_draw);
            //更新数据库
            UserDaoImpl udi = new UserDaoImpl();
            udi.updataUser(user_Login);
            System.out.println("取款成功！");
            LogService.addLogs(user_Login,"用户取款，金额："+money_draw);
        } else{
            System.out.println("取款失败！余额不足。");
            LogService.addLogs(user_Login,"用户取款失败余额不足");
        }
    }
    public void deposit(User user_Login) {
        System.out.println("请输入存款金额：");
        //输入存款的金额，并做非数字的判断
        double money_deposit = 0;
        money_deposit = ValidationUtil.get();
        //操作存款
        user_Login.setBalance(user_Login.getBalance()+money_deposit);
        //更新数据库
        UserDaoImpl udi = new UserDaoImpl();
        udi.updataUser(user_Login);
        System.out.println("存款成功");
        LogService.addLogs(user_Login,"用户存款，金额："+money_deposit);
    }

    public void Logout(User user_Login){
        Date time = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        String dateTimeNow = sdf.format(time);
        //记录登出系统时间
        System.out.println(user_Login.getId()+" 于"+dateTimeNow+" 登出系统。");
        LogService.addLogs(user_Login,"退出登录");
        //将当前登录清除
        user_Login = null;
    }

    public void help(User user_Login){
        System.out.println("******欢迎来到自助在线业务系统******");
        System.out.println("        \t1.关于注册");
        System.out.println("        \t2.关于登录");
        System.out.println("        \t3.关于转账");
        System.out.println("        \t 如有问题请致电139xxxxxxxxx");
        System.out.println("**********************************");
        System.out.println("请输入操作功能：");
        LogService.addLogs(user_Login,"用户查看帮助手册");
    }

    public void transfer(User user_Login){
        System.out.println("请输入转账的账户ID：");
        String tranId = ValidationUtil.getString();
        System.out.println("请输入转账的账户的姓名：");
        String tranName = ValidationUtil.getString();
        UserDaoImpl udi = new UserDaoImpl();
        User tranUser = udi.findUserbyId(tranId);
        if(tranId.equals(tranUser.getId()) && tranName.equals(tranUser.getName())){
            System.out.println("请输入转入的金额：");
            double tranMoney = ValidationUtil.get();
            if(user_Login.getBalance()>=tranMoney){
                double totalMoney2 = tranUser.getBalance() + tranMoney;
                tranUser.setBalance(totalMoney2);
                double totalMoney1 = user_Login.getBalance() - tranMoney;
                user_Login.setBalance(totalMoney1);
                udi.updataUser(tranUser);
                udi.updataUser(user_Login);
                System.out.println("转账成功！转账金额为："+tranMoney+"元。"+"当前您的账户余额为"+user_Login.getBalance()+"元。");
                LogService.addLogs(user_Login,"转账给用户:"+tranName+",转账金额："+tranMoney);
                LogService.addLogs(tranUser,"收到用户："+user_Login.getName()+"的转账，转账金额："+tranMoney);
            } else {
                System.out.println("余额不足");
            }
        } else {
            System.out.println("用户ID与用户名不匹配，转账失败。");
            LogService.addLogs(user_Login,"转账失败");
        }

    }
}




