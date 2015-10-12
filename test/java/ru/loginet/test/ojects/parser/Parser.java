package ru.loginet.test.ojects.parser;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by supfe_000 on 09.10.2015.
 */
public abstract class Parser {
    public static void updateCell(String value, int cell, int row, String filePath) throws Exception {

        POIFSFileSystem fs =
                new POIFSFileSystem(new FileInputStream(filePath));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        Sheet sheet1 = wb.getSheetAt(0);
        Row row1 = sheet1.getRow(row);
        row1.getCell(cell).setCellValue(value);
        wb.write(new FileOutputStream(filePath));

    }


}
