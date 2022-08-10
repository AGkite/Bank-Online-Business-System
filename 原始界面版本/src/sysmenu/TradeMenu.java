package lab1.sysmenu;

import lab1.beans.User;
import lab1.service.LogService;
import lab1.service.UserService;
import lab1.utils.ValidationUtil;

public class TradeMenu {
    /*
     * 进入用户菜单
     * */
    public void UserSatrt(User user) {
        boolean isEnd = true;
        //若登录不成功返回上一级菜单
        if (user == null) {
            isEnd = false;
        }
        int choose = 0;
        UserService userService = new UserService();
        while (isEnd) {
            System.out.println("*************交易菜单*************");
            System.out.println("当前账户为：" + user.getId() + " :");
            System.out.print("  1.查询余额");
            System.out.print("  2.取款");
            System.out.print("  3.存款");
            System.out.print("  4.转账");
            System.out.print("  5.查询日志");
            System.out.print("  6.退出");
            System.out.print("  7.帮助\n");
            System.out.println("**********************************");
            System.out.println("请输入操作功能：");
            //键入操作功能
            choose = ValidationUtil.getNum(1, 7);
            switch (choose) {
                case 1://1.查询余额
                    userService.search(user);
                    break;
                case 2://2.取款
                    userService.draw(user);
                    break;
                case 3://3.存款
                    userService.deposit(user);
                    break;
                case 4://4.转账
                    userService.transfer(user);
                    break;
                case 5://5.查询日志
                    LogService.queryLogs(user);
                    break;
                case 6://6.退出
                    userService.Logout(user);
                    isEnd = false;
                    break;
                case 7://7.帮助
                    userService.help(user);
                    isEnd = false;
                    break;
            }
            //isEnd = false;
        }
    }
}
