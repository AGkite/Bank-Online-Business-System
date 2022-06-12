package lab1.frame;

import lab1.beans.Logs;
import lab1.beans.User;
import lab1.dao.impl.LogDaoImpl;
import lab1.utils.DateUtil;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

public class OutputExcel {
    /*
     * 查询日志
     * */
    public static List<Logs> queryLogs(User user) {
        LogDaoImpl logdaoimpl = new LogDaoImpl();
        List<Logs> logList = logdaoimpl.queryLog(user.getId());
        return logList;
    }

    /*
     * 导出日志，导成Excel
     * */
    public OutputExcel(User user) throws Exception {

        //写入日志到Excel
        String[] title = {"账号", "时间", "操作系统"};
        HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel工作表
        HSSFSheet sheet = workbook.createSheet();//创建一个工作表sheet
        HSSFRow row = sheet.createRow(0);//创建第一行
        HSSFCell cell;//创建单元格
        //插入第一行数据、id、name、sex
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        //追加数据
        List<Logs> logList = queryLogs(user);
        Iterator<Logs> list = logList.iterator();
        int i = 1;
        while (list.hasNext()) {
            Logs log = list.next();
            HSSFRow nextRow = sheet.createRow(i);//创建第二行单元格
            HSSFCell cell2 = nextRow.createCell(0);
            cell2.setCellValue(log.getUserId());
            cell2 = nextRow.createCell(1);
            cell2.setCellValue(log.getTimes());
            cell2 = nextRow.createCell(2);
            cell2.setCellValue(log.getLogContext());
            i++;
        }
        //可选择日志文件存放的路径
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//仅仅选择文件夹
        chooser.showOpenDialog(null);
        String path = chooser.getSelectedFile().getPath();
        String time = DateUtil.getDateTimeNow();
        //创建一个文件：文件路径可更新
        File file = new File(path+"/Log_"+user.getId()+"_"+time+".xls");
        FileOutputStream stream = FileUtils.openOutputStream(file);//文件流
        workbook.write(stream);//写入流
        stream.close();//关闭流
        JOptionPane.showMessageDialog(null,"日志导出成功！","日志导出",JOptionPane.INFORMATION_MESSAGE);
    }
}