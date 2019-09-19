package cn.itcast.utils;

import cn.itcast.model.User;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author lijingyu
 * @date 2019/9/19 14:00
 */
public class ExportUserUtils {

    public static ByteArrayOutputStream exportUser(List<User> userList, String sheetName) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(sheetName);
        sheet.setDefaultColumnWidth(30);
        sheet.setDefaultRowHeight((short)25);
        int index=0;
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            final HSSFRow row = sheet.createRow(index);

            final HSSFCell cell = row.createCell(0);
            cell.setCellValue(user.getId());

            final HSSFCell cell2 = row.createCell(1);
            cell2.setCellValue(user.getUsername());

            final HSSFCell cell3 = row.createCell(2);
            cell3.setCellValue(user.getPassword());

            final HSSFCell cell4 = row.createCell(3);
            cell4.setCellValue(user.getAge());
            index++;
        }

        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            workbook.write(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }
}
