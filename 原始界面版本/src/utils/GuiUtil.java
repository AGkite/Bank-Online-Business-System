package lab1.utils;

import lab1.beans.User;
import lab1.frame.TradeMenuFrame;

import javax.swing.*;

public class GuiUtil {
    public static boolean k=false;
    public static void digit(String str){
        try{
            Double.parseDouble(str);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"输入的不是数字，请重新输入！");
            k=true;
        }

    }

}
