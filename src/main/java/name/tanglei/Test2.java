package name.tanglei;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import jxl.*;
import jxl.write.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * Created by tanglei on 9/15/15.
 */
public class Test2 {

    public  static int maxRow = 65536 * 1;
    //from [](http://stackoverflow.com/questions/2498536/poi-performance)
    //jexcel isnot faster than poi(3.12)
    public static void createJExcelWorkbook() throws Exception {
        WritableWorkbook workbook = jxl.Workbook.createWorkbook(new File("jexcel_workbook.xls"));
        WritableSheet sheet = workbook.createSheet("sheet", 0);
        for ( int i=0; i < maxRow; i++) {
            for ( int j=0; j < 10; j++) {
                Label label = new Label(j, i, "some text " + i + " " + j);
                sheet.addCell(label);
            }
        }
        workbook.write();
        workbook.close();
    }

    public static void createPoiWorkbook() throws Exception {
        Workbook wb = new SXSSFWorkbook();//new HSSFWorkbook();
        Sheet sheet = wb.createSheet("sheet");
        for ( int i=0; i < maxRow; i++) {
            Row row = sheet.createRow(i);
            for ( int j=0; j < 10; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue("some text " + i + " " + j);
            }
        }
        FileOutputStream fileOut = new FileOutputStream("poi_workbook.xls");
        wb.write(fileOut);
        fileOut.close();
    }

    public static void main(String[] args){
        try {
            long cur = System.currentTimeMillis();
            createJExcelWorkbook();
            System.out.println("JExcel:" + (System.currentTimeMillis() - cur));
            cur = System.currentTimeMillis();
            createPoiWorkbook();
            System.out.println("Poi:" + (System.currentTimeMillis() - cur));
        }catch (Exception e){
            System.err.println(e.toString());
        }
    }

}
