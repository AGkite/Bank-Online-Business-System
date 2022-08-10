package sysmenu;

import service.UserService;
import utils.ValidationUtil;

public class SystemMenu {
    public void start() {
        boolean isEnd = true;
        int choose = 0;
        while (isEnd) {
            System.out.println("********欢迎来到自助在线业务系统********");
            System.out.println("          \t1.注册");
            System.out.println("          \t2.登录");
            System.out.println("          \t3.退出");
            System.out.println("***************************************");
            System.out.println("请输入操作功能：");

            choose = ValidationUtil.getNum(1, 3);
            switch (choose) {
                case 1:
                    //实现注册功能
                    UserService us = new UserService();
                    us.singIn();
                    break;
                case 2:
                    //实现登录功能
                    UserService us2 = new UserService();
                    TradeMenu tm = new TradeMenu();
                    tm.UserSatrt(us2.login());
                    break;
                case 3:
                    isEnd = false;
                    System.out.println("感谢使用本系统，系统关闭！");
            }
        }
    }
}
