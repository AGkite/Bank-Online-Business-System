package lab1.service;

import lab1.beans.Logs;
import lab1.beans.User;
import lab1.dao.impl.LogDaoImpl;
import lab1.utils.DateUtil;

import java.util.Iterator;
import java.util.List;

public class LogService {
    /*
    * 插入日志
    * */
    public static void addLogs(User user, String logContext) {
        LogDaoImpl logdaoimpl = new LogDaoImpl();
        Logs log = new Logs();
        log.setUserId(user.getId());
        log.setTimes(DateUtil.getDateTimeNow());
        log.setLogContext(logContext);
        logdaoimpl.addLog(log);
    }
    /*
    * 查询日志
    * */
    public static void queryLogs(User user){
        LogDaoImpl logdaoimpl = new LogDaoImpl();
        List<Logs> logList = logdaoimpl.queryLog(user.getId());
        Iterator<Logs> list = logList.iterator();
        System.out.println("该账号的日志记录如下：");
        System.out.println("账 号"+"\t"+"时 间"+"\t"+"操 作");
        while (list.hasNext()) {
            Logs log = list.next();
            System.out.println(log.getUserId()+"\t"+log.getTimes()+"\t"+log.getLogContext());

        }
    }
}
