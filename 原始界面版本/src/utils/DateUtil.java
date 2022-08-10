package lab1.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 用于生成时间字符串，或根据时间字符串解释返回Date对象
* */
public class DateUtil {
    /*
    * 返回当前日期和时间以“yyy-MM-dd kk:mm:ss”格式显示的字符串
    *
    * @return 当前日期时间字符串
    * */
    public static String getDateTimeNow(){
        Date time = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd_kk.mm.ss");
        return sdf.format(time);
    }

}
