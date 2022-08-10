package utils;

import java.util.Scanner;

public class ValidationUtil {
    /*
     * 获取输入字符串
     * @return 字符串sc.next()
     * */
    public static String getString() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    /*
     * 创建密码，带有重复验证功能
     * @return 返回密码串
     * */
    @SuppressWarnings("resource")
    public static String getPassword() {
        String pwd = null;
        String pwd_rept = null;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入密码：");
            pwd = sc.next();
            System.out.println("请再次输入密码：");
            pwd_rept = sc.next();
            if (!pwd.equals(pwd_rept)) {
                System.out.println("两次输入的密码不一致，请重新输入：");
                continue;
            } else {
                return pwd_rept;
            }
        }
    }

    public static int getNum(int start, int end) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        while (true) {
            while (true) {
                String str = sc.next();
                try {
                    num = Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    System.out.println("输入的不是数字！，请重新输入");
                    continue;
                }
                break;
            }
            if (num > end || num < start) {
                System.out.println("无效操作，输入数字必须在" + start + "到" + end + "之间，请重新输入：");
                continue;
            }
            return num;
        }
    }

    public static double get(){
        double num = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.next();
            try{
                num = Double.parseDouble(str);
            } catch (NumberFormatException e) {
                System.out.println("输入的不是数字！请重新输入");
                continue;
            }
            break;
        }
        return num;
    }
}
