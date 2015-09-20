package ru.loginet.test.cola;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import ru.loginet.test.ojects.Dater;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class ParserShippingRequestCola {
    public static int start = 2;                     //   line to start
    public static int clmnod = 2;                   //   c
    public static int clmndateLoad = 3;              //   D
    public static int clmntimeLoad = 4;              //   E
    public static int clmnstoreToLoad = 5;           //   F
    public static int clmndateUnload = 6;            //   G
    public static int clmntimeUnload = 7;            //   F
    public static int clmnstoreUnload = 8;           //   I
    public static int clmnserviceType = 9;           //   J
    public static int clmnvehicleType = 10;           //   K
    public static int clmnbodySpace = 11;             //   L
    public static int clmnload = 12;                  //   M
    public static int clmnweight = 13;                //   N
    public static int clmntripTypes = 14;             //   O
    public static int clmnregion = 15;                //   P
    public static int clmncost = 16;                  //   R
    public static int clmncomment = 17;               //   S
    public static int clmnprice = 18;                 //   T

    public static ShippingRequestValueContainerCola parseToContainer() throws Exception {
        ShippingRequestValueContainerCola containerCola = new ShippingRequestValueContainerCola();
        POIFSFileSystem fs =
                new POIFSFileSystem(new FileInputStream(containerCola.getFile_path()));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        Sheet sheet1 = wb.getSheetAt(0);
        Row row1 = sheet1.getRow(start);


        containerCola.setOd(row1.getCell(clmnod).getRichStringCellValue().getString());
        System.out.println(containerCola.getOD());

        containerCola.setRequestDate(row1.getCell(clmndateLoad).getRichStringCellValue().getString());
        System.out.println(containerCola.getRequestDate());

        containerCola.setRequestTime(row1.getCell(clmntimeLoad).getRichStringCellValue().getString());
        System.out.println(containerCola.getRequestTime());

        containerCola.setLoadStoreCode(row1.getCell(clmnstoreToLoad).getRichStringCellValue().getString());
        String codeLoad = containerCola.getLoadStoreCode();
        System.out.println(containerCola.getLoadStoreCode());

        containerCola.setDateUnload(row1.getCell(clmndateUnload).getRichStringCellValue().getString());
        System.out.println(containerCola.getDateUnload());

        containerCola.setTimeUnload(row1.getCell(clmntimeUnload).getRichStringCellValue().getString());
        System.out.println(containerCola.getTimeUnload());

        containerCola.setUnloadStoreCode(row1.getCell(clmnstoreUnload).getRichStringCellValue().getString());
        String codeUnload = containerCola.getUnloadStoreCode();
        System.out.println(containerCola.getUnloadStoreCode());

        containerCola.setRequestService(row1.getCell(clmnserviceType).getRichStringCellValue().getString());
        System.out.println(containerCola.getRequestService());
        containerCola.setVehicleType(row1.getCell(clmnvehicleType).getRichStringCellValue().getString());
        System.out.println(containerCola.getVehicleType());
        containerCola.setBodySpace(row1.getCell(clmnbodySpace).getRichStringCellValue().getString());
        System.out.println(containerCola.getBodySpace());
        containerCola.setLoad(row1.getCell(clmnload).getRichStringCellValue().getString());
        System.out.println(containerCola.getLoad());
        containerCola.setWeight(row1.getCell(clmnweight).getRichStringCellValue().getString());
        System.out.println(containerCola.getWeight());
        containerCola.setTripTypes(row1.getCell(clmntripTypes).getRichStringCellValue().getString());
        System.out.println(containerCola.getTripTypes());
        containerCola.setRegion(row1.getCell(clmnregion).getRichStringCellValue().getString());
        System.out.println(containerCola.getRegion());
        containerCola.setRequestTotalCargoCost(row1.getCell(clmncost).getRichStringCellValue().getString());
        System.out.println(containerCola.getRequestTotalCargoCost());
        containerCola.setComment(row1.getCell(clmncomment).getRichStringCellValue().getString());
        System.out.println(containerCola.getComment());
        containerCola.setPrice(row1.getCell(clmnprice).getRichStringCellValue().getString());


        Sheet sheet = wb.getSheetAt(1);
        Iterator<Row> it = sheet.iterator();

        while (it.hasNext()) {
            Row row = it.next();
            Cell code = row.getCell(0);
            Cell value1 = row.getCell(1);
            if (code.getRichStringCellValue().getString().equals(codeLoad)) {
                containerCola.setAdressLoad(value1.getRichStringCellValue().getString());
            }
            if (code.getRichStringCellValue().getString().equals(codeUnload)) {
                containerCola.setAdressUnload(value1.getRichStringCellValue().getString());
            }

        }
        System.out.println("Adress load " + containerCola.getAdressLoad());
        System.out.println("Adress Unload " + containerCola.getAdressUnload());
        System.out.println("fin");

        return containerCola;


    }

    public static void setDateLoadUnload(String dateLoad, String dateUnload) throws Exception {
        try {
            POIFSFileSystem fs =
                    new POIFSFileSystem(new FileInputStream(ShippingRequestValueContainerCola.file_path));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            Sheet sheet1 = wb.getSheetAt(0);
            Row row1 = sheet1.getRow(start);
            row1.getCell(clmndateLoad).setCellValue(dateLoad);
            row1.getCell(clmndateUnload).setCellValue(dateUnload);
            wb.write(new FileOutputStream(ShippingRequestValueContainerCola.file_path));
        } catch (IOException e) {
            System.out.println("setDateLoadUnload");
        }
    }

    public static void setDateLoad(String dateLoad) throws Exception {
        try {
            POIFSFileSystem fs =
                    new POIFSFileSystem(new FileInputStream(ShippingRequestValueContainerCola.file_path));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            Sheet sheet1 = wb.getSheetAt(0);
            Row row1 = sheet1.getRow(start);
            row1.getCell(clmndateLoad).setCellValue(dateLoad);
            wb.write(new FileOutputStream(ShippingRequestValueContainerCola.file_path));
        } catch (IOException e) {
            System.out.println("setRequestDate");
        }
    }

    public static void setDateUnload(String dateUnload) throws Exception {
        try {
            POIFSFileSystem fs =
                    new POIFSFileSystem(new FileInputStream(ShippingRequestValueContainerCola.file_path));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            Sheet sheet1 = wb.getSheetAt(0);
            Row row1 = sheet1.getRow(start);
            row1.getCell(clmndateUnload).setCellValue(dateUnload);
            wb.write(new FileOutputStream(ShippingRequestValueContainerCola.file_path));
        } catch (IOException e) {
            System.out.println("ParserShippingRequestCola - setDateUnload error");
        }
    }

    public static String setOd() throws Exception {
        String od = Dater.getUnique();
        POIFSFileSystem fs =
                new POIFSFileSystem(new FileInputStream(ShippingRequestValueContainerCola.file_path));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        Sheet sheet1 = wb.getSheetAt(0);
        Row row1 = sheet1.getRow(start);
        row1.getCell(clmnod).setCellValue(od);
        row1.getCell(clmncomment).setCellValue(od);
        wb.write(new FileOutputStream(ShippingRequestValueContainerCola.file_path));
        return od;
    }

}
