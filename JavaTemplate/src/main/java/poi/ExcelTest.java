package poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelTest {

    private static final String excel1 = "C:\\Users\\wu275\\Desktop\\POIbug\\周聪测试\\历次考试上线情况.xlsx";
    private static final String excle2 = "C:\\Users\\wu275\\Desktop\\POIbug\\周聪测试\\历次考试上线情况客户.xlsx";
    private static final String excle3 = "C:\\Users\\wu275\\Desktop\\POIbug\\周聪测试\\拷贝结果.xlsx";
    public static void main(String[] args) throws IOException {
        try {
            test(excel1,excle2,excle3);
        } catch (Exception e) {  
            System.out.println("请检查EXCEL文件及格式!!");  
        }  
    }  
  
    private static void test(String file1,String file2,String file3) throws IOException {
        XSSFWorkbook srcWb = new XSSFWorkbook(new FileInputStream(new File(file1)));
        XSSFWorkbook distWb = new XSSFWorkbook(new FileInputStream(new File(file2)));
          
        //单元格合并  
        CellRangeAddress region = null;
        XSSFSheet sheet1 = srcWb.getSheet("main");
        XSSFSheet sheet2 = distWb.createSheet("拷贝");
        for (int i = 0; i < sheet1.getNumMergedRegions(); i++) {
            region = sheet1.getMergedRegion(i);
            if ((region.getFirstColumn() >= sheet1.getFirstRowNum())
                    && (region.getLastRow() <= sheet1.getLastRowNum())) {
                sheet2.addMergedRegion(region);
            }
        }
  
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
            rowTo = sheet2.createRow(i);  
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
                  
                cellTo = rowTo.createCell(j);  
                //cellTo.setCellStyle(cellFrom.getCellStyle());
                cellTo.getCellStyle().cloneStyleFrom(cellFrom.getCellStyle());
                cellTo.setCellType(cellFrom.getCellType());
                if(Cell.CELL_TYPE_STRING == cellFrom.getCellType()){  
                    cellTo.setCellValue(cellFrom.getStringCellValue());  
                }else if(Cell.CELL_TYPE_NUMERIC == cellFrom.getCellType()){  
                    cellTo.setCellValue(cellFrom.getNumericCellValue());  
                }  
            }  
        }  
  
        sheet2.setDisplayGridlines(true);//  
        FileOutputStream fileOut = new FileOutputStream(file3);
        distWb.write(fileOut);
        fileOut.close();   
          
        System.out.println(file3 + " 复制sheet成功!");
    }  
  
}  