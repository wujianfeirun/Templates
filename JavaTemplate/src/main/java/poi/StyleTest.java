package poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StyleTest {

    private static final String excel1 = "C:\\Users\\wu275\\Desktop\\POIbug\\周聪测试\\合并\\New.xlsx";
    private static final String excle2 = "C:\\Users\\wu275\\Desktop\\POIbug\\周聪测试\\合并\\格式拷贝.xlsx";
    public static void main(String[] args) throws IOException {
        try {
            test(excel1,excle2);
        } catch (Exception e) {  
            System.out.println("请检查EXCEL文件及格式!!");  
        }  
    }  
  
    private static void test(String file1,String file2) throws IOException {
        XSSFWorkbook srcWb = new XSSFWorkbook(new FileInputStream(new File(file1)));
        XSSFSheet sheet1 = srcWb.getSheet("客户表");
        XSSFSheet sheet2 = srcWb.getSheet("main");

        //复制内容  
        XSSFRow rowFrom = null;
        XSSFRow rowTo = null;
        XSSFCell cellFrom = null;
        XSSFCell cellTo = null;
        for (int i = sheet1.getFirstRowNum(); i < sheet1.getLastRowNum(); i++) {  
            rowFrom = sheet1.getRow(i);  
            if (null == rowFrom) {
                continue;
            }
            rowTo = sheet2.getRow(i);
            rowTo.setHeight(rowFrom.getHeight());  
            for (int j = 0; j < rowFrom.getLastCellNum(); j++) {  
                sheet2.setColumnWidth(j, sheet1.getColumnWidth(j));  
                if(null != sheet1.getColumnStyle(j)){  
                    sheet2.setDefaultColumnStyle(j, sheet1.getColumnStyle(j));  
                }  
                  
                cellFrom = rowFrom.getCell(j);  
                if (null == cellFrom){  
                    continue;  
                }  
                  
                cellTo = rowTo.getCell(j);
                cellTo.setCellStyle(cellFrom.getCellStyle());
                //cellTo.getCellStyle().cloneStyleFrom(cellFrom.getCellStyle());
                cellTo.setCellType(cellFrom.getCellType());
//                if(Cell.CELL_TYPE_STRING == cellFrom.getCellType()){
//                    cellTo.setCellValue(cellFrom.getStringCellValue());
//                }else if(Cell.CELL_TYPE_NUMERIC == cellFrom.getCellType()){
//                    cellTo.setCellValue(cellFrom.getNumericCellValue());
//                }
            }  
        }
        //TODO  添加图片拷贝

       // sheet2.setDisplayGridlines(true);//
        FileOutputStream fileOut = new FileOutputStream(file2);
        srcWb.write(fileOut);
        fileOut.close();   
          
        System.out.println(file2 + " 格式拷贝成功!");
    }  
  
}  