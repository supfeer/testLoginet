package ru.loginet.test.Test.sandBox;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Created by supfe_000 on 19.09.2015.
 */
public class TestRar {
    @Test
    public void test() throws Exception {
        String code = "3802013234";
        String value;
        InputStream in = new FileInputStream("src/test/testFiles/ColaValid1.xls");
        HSSFWorkbook wb = new HSSFWorkbook(in);

        Sheet sheet = wb.getSheetAt(1);
        Iterator<Row> it = sheet.iterator();

        while (it.hasNext()) {
            Row row = it.next();
            Cell code1 = row.getCell(0);
            Cell value1 = row.getCell(1);
            if (code1.getRichStringCellValue().getString().equals(code)) {

                System.out.println(value1.getStringCellValue());
            }
        }
    }
}
