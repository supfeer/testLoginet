package ru.loginet.test.ojects.parser;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import ru.loginet.test.ojects.tools.Dater;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by supfe_000 on 26.09.2015.
 */
public class ParserDefault extends Parser {
    final String path = "src/test/testFiles/requestTemplate/default.xlsx";

    final int START_LINE = 3;

    final int sh = 0;
    final int NAME = 1;
    final int TRIP = 2;
    final int DATE_LOAD = 3;
    final int TIME_LOAD = 4;
    final int STORE_LOAD = 5;
    final int STORE_LOAD_NAME = 6;
    final int DATE_UNLOAD = 7;
    final int TIME_UNLOAD = 8;
    final int STORE_UNLOAD = 9;
    final int STORE_UNLOAD_NAME = 10;
    final int SERVICE_TYPE = 11;
    final int VEHICLE_TYPE = 12;
    //final int ??                      = 13;
    final int VEHICLE_TONNAGE = 14;
    //final int ??                      = 15;
    final int VEHICLE_COUNT = 16;
    final int CARGO_NAME = 17;
    final int CARGO_TYPE = 18;
    final int PACKAGE_COUNT = 19;
    final int PACKAGE_TYPE = 20;
    final int WEIGHT = 21;
    final int PRICE = 22;
    final int COMMENT = 23;

    public void prepareToUpload(String dateLoad, String dateUnload) throws Exception {
        POIFSFileSystem fs =
                new POIFSFileSystem(new FileInputStream(path));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        Sheet sheet1 = wb.getSheetAt(0);
        Row row1 = sheet1.getRow(START_LINE);
        row1.getCell(DATE_LOAD).setCellValue(dateLoad);
        row1.getCell(DATE_UNLOAD).setCellValue(dateUnload);
        row1.getCell(COMMENT).setCellValue(Dater.getUnique());
        wb.write(new FileOutputStream(path));
    }
}
