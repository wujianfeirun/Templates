package poi;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.ss.usermodel.CellCopyPolicy;
import org.apache.poi.util.POILogger;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

public class CopyOfCustomSheetUtils {
	
	static int dataRow=35;
	static int dataColumn=6;
	
	static Set<String> mainTableRowString;
	
	//TODO 记录dataSet浮动发生的位置，用来修正计算表达式

	String[] mainSheetRow = new String[2];     //记录main表前一行和当前行  空行忽略
	String[] dataSheetRow = new String[2];     //记录data表前一行和当前行  空行忽略
	String[] customSheetRow = new String[2];

	static int mainSheetCursor=0;
	static int dataSheetBeginCursor=0;
	static int dataSheetEndCursor=0;
	static int customSheetBeginCusror=0;
	static int customSheetEndCusror=0;


	public static void main(String[] args) throws Exception {
		XSSFWorkbook sofaExcel = new XSSFWorkbook(new FileInputStream("C:\\Users\\wu275\\Desktop\\POIbug\\周聪测试\\8-6.历次考试上线情况.xlsx"));
		XSSFWorkbook customExcel = new XSSFWorkbook(new FileInputStream("C:\\Users\\wu275\\Desktop\\POIbug\\周聪测试\\8-6.历次考试上线情况 -客户.xlsx"));

		FileOutputStream out = new FileOutputStream("C:\\Users\\wu275\\Desktop\\POIbug\\周聪测试\\合并结果.xlsx");


		//这种方式将sofa模板的内容拷贝到客户模板会造成sofa模板中动态应用的格式丢失
		//1 先克隆sofa模板的main页到客户模板coloneSheet
		SheetUtils.cloneSheet(sofaExcel,"main",customExcel, "拷贝");

		customExcel.write(out);
		out.flush();
		out.close();
		//2.客户模板的customSheet页的格式应用到colone页


		//3.客户模板的customSheet页的图片拷贝到colonesheet

		//4.删除customSheet并把coloneSheet命名为customSheet
	}








	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main2(String[] args) throws Exception {
		//产生10行
		int createNum=10;
		
		
    	XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\lenovo\\Desktop\\报表导出\\poitest\\图片拷贝输入.xlsx"));
    	XSSFSheet srcsheet = workbook.getSheet("main");
    	XSSFSheet destsheet = workbook.getSheet("none");
		List<XSSFPictureData> allPictures = workbook.getAllPictures();
		FileOutputStream out1=null;
		for(int i=0;i<allPictures.size();i++) {
		
			System.out.println(	"图片"+i+"格式="+allPictures.get(i).getPictureType());
			out1=new FileOutputStream("C:\\Users\\lenovo\\Desktop\\报表导出\\poitest\\图片"+i);
			out1.write(allPictures.get(i).getData());
			out1.flush();
			out1.close();
		}

//		FileOutputStream out=new FileOutputStream("C:\\Users\\lenovo\\Desktop\\报表导出\\poitest\\图片拷贝输出.xlsx");
//        workbook.write(out);
//		out.flush();
//		workbook.close();

	}

	public static void mainxxx(String[] args) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\lenovo\\Desktop\\报表导出\\poitest\\图片拷贝输入.xlsx"));
		XSSFSheet destsheet = workbook.getSheet("none");
		XSSFSheet srcsheet = workbook.getSheet("main");
		XSSFDrawing patriarch=destsheet.createDrawingPatriarch();
		srcsheet.createDrawingPatriarch();
		BufferedImage bufferImg = null;   
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();   
        bufferImg = ImageIO.read(new File("C:\\Users\\lenovo\\Desktop\\报表导出\\poitest\\图片1.png"));   
        ImageIO.write(bufferImg, "png", byteArrayOut);
        XSSFClientAnchor anchor = new XSSFClientAnchor(431800,82550, 2748280, 128904,0, 4,0,5);   

        //插入图片  
        patriarch.createPicture(anchor, workbook.addPicture(byteArrayOut.toByteArray(), XSSFWorkbook.PICTURE_TYPE_PNG)); 
        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\lenovo\\Desktop\\报表导出\\poitest\\图片拷贝输出.xlsx");   
        // 写入excel文件   
        workbook.write(fileOut);   
        fileOut.flush();

	}
	
	
	
	
	
	
	
	public static void mainxxxxx(String[] args) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\lenovo\\Desktop\\报表导出\\poitest\\图片拷贝输入.xlsx"));
		XSSFSheet srcsheet = workbook.getSheet("main");
		XSSFSheet destsheet = workbook.getSheet("none");
		Map<XSSFClientAnchor, XSSFPictureData> pictures = getSheetPictrues(srcsheet);
		insertSheetPictrues(pictures,destsheet);
	}
	
	public static Map<XSSFClientAnchor, XSSFPictureData> getSheetPictrues( XSSFSheet srcsheet) {
		Map<XSSFClientAnchor, XSSFPictureData> sheetIndexPicMap = new HashMap<XSSFClientAnchor, XSSFPictureData>();
		XSSFDrawing drawing = srcsheet.getDrawingPatriarch();
		List<XSSFShape> shapes = drawing.getShapes();
		for (XSSFShape shape : shapes) {
			if(shape instanceof XSSFPicture) {
				XSSFPicture pic = (XSSFPicture) shape;
				XSSFClientAnchor anchor = (XSSFClientAnchor)pic.getAnchor();  
				sheetIndexPicMap.put(copyAnchor(anchor,4), pic.getPictureData());
				//sheetIndexPicMap.put(anchor, pic.getPictureData());
				
				//第一个单元格以及与第一个单元格的相对位置
				System.out.println("getRow1="+anchor.getRow1());
				System.out.println("getCol1="+anchor.getCol1());
				System.out.println("getDx1="+anchor.getDx1());
				System.out.println("getDy1="+anchor.getDy1());
				//第二个单元格以及与第二个单元格的相对位置
				System.out.println("getRow2="+anchor.getRow2());
				System.out.println("getCol2="+anchor.getCol2());
				System.out.println("getDx2="+anchor.getDx2());
				System.out.println("getDy2="+anchor.getDy2());
				System.out.println();
			}
		}
		return sheetIndexPicMap;
	}
	
	public static void insertSheetPictrues(Map<XSSFClientAnchor, XSSFPictureData> pictures ,XSSFSheet destsheet) throws Exception{
		XSSFDrawing patriarch = destsheet.createDrawingPatriarch();
		XSSFWorkbook wb = destsheet.getWorkbook();
		XSSFClientAnchor origin =null;
		XSSFClientAnchor newanchor =null;
		for (Map.Entry<XSSFClientAnchor, XSSFPictureData> entry : pictures.entrySet()) {
			origin = entry.getKey();
			//int dx1, int dy1, int dx2, int dy2, int col1, int row1, int col2, int row2
			newanchor = entry.getKey();
			XSSFPictureData picData = entry.getValue();
			patriarch.createPicture(newanchor,wb.addPicture(new ByteArrayInputStream(picData.getData()),picData.getPictureType()));
			//第一个单元格以及与第一个单元格的相对位置
			System.out.println("getRow1="+newanchor.getRow1());
			System.out.println("getCol1="+newanchor.getCol1());
			System.out.println("getDx1="+newanchor.getDx1());
			System.out.println("getDy1="+newanchor.getDy1());
			//第二个单元格以及与第二个单元格的相对位置
			System.out.println("getRow2="+newanchor.getRow2());
			System.out.println("getCol2="+newanchor.getCol2());
			System.out.println("getDx2="+newanchor.getDx2());
			System.out.println("getDy2="+newanchor.getDy2());
			System.out.println();
		}
		FileOutputStream out=new FileOutputStream("C:\\Users\\lenovo\\Desktop\\报表导出\\poitest\\图片拷贝输出.xlsx");
		wb.write(out);
		out.flush();
		wb.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static XSSFClientAnchor copyAnchor(XSSFClientAnchor anchor,int rowOffset){
		if(anchor.getRow1()+rowOffset<0){
			rowOffset=0-anchor.getRow1();
		}
		XSSFClientAnchor newanchor = new XSSFClientAnchor(anchor.getDx1(),anchor.getDy1(),anchor.getDx2(),anchor.getDy2(),anchor.getCol1(),anchor.getRow1()+rowOffset,anchor.getCol2(),anchor.getRow2()+rowOffset);
		return newanchor;
	}
	
	public static Map<String, XSSFPictureData> getSheetPictruesTest( XSSFSheet srcsheet) {
		Map<String, XSSFPictureData> sheetIndexPicMap = new HashMap<String, XSSFPictureData>();
		XSSFDrawing drawing = srcsheet.getDrawingPatriarch();
		List<XSSFShape> shapes = drawing.getShapes();
		for (XSSFShape shape : shapes) {
			if(shape instanceof XSSFPicture) {
				XSSFPicture pic = (XSSFPicture) shape;
				XSSFClientAnchor anchor = pic.getPreferredSize();
				//第一个单元格以及与第一个单元格的相对位置
				System.out.println("getRow1="+anchor.getRow1());
				System.out.println("getCol1="+anchor.getCol1());
				System.out.println("getDx1="+anchor.getDx1());
				System.out.println("getDy1="+anchor.getDy1());
				//第二个单元格以及与第二个单元格的相对位置
				System.out.println("getRow2="+anchor.getRow2());
				System.out.println("getCol2="+anchor.getCol2());
				System.out.println("getDx2="+anchor.getDx2());
				System.out.println("getDy2="+anchor.getDy2());
				System.out.println();
				String picIndex = srcsheet.getSheetName() + "_"
						+ anchor.getFrom().getRow() + "_" + anchor.getFrom().getCol();
				sheetIndexPicMap.put(picIndex, pic.getPictureData());
			}
		}
		return sheetIndexPicMap;
	}
	
	
	//操作 2007版 及以上版本 excel
	public static void insertImage(XSSFWorkbook wb,byte[] picBytes,int pictureType) {
			// 创建excel   Sheet ,这个是必须的，不然图片插到哪呢
			XSSFSheet sheet=wb.createSheet("sheet0");

			// 设置图片位置  这个对象 对应 2003版 中HSSFPatriarch 用法 类似
			XSSFDrawing patriarch = sheet.createDrawingPatriarch();
			//偏移量  这个有点恶心， 这个单位直接以万 计， 10000以下 基本设了等于没设。原因不明 ，操作2003 的 HSSF 是正常的比例
			XSSFClientAnchor anchor = new XSSFClientAnchor(50*10000, 0, 100, 100,
					2, 10,  12, 25);

			//这个参数还不太清楚 有 0、2、3 三个值，貌似和图片与单元格的相对位置有关 ，设不设都不影响图片位置
			//anchor.setAnchorType(2);

			//如果是 png、gif 就设对应值
			patriarch.createPicture(anchor, wb.addPicture(picBytes, XSSFWorkbook.PICTURE_TYPE_JPEG));

	}


	public static void main1(String[] args) throws Exception {
		//产生10行
		int createNum=10;


		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\lenovo\\Desktop\\报表导出\\poitest\\客户测试模板-转换.xlsx"));
		XSSFSheet sheet = workbook.getSheetAt(0);

		sheet.shiftRows(12, sheet.getLastRowNum(), createNum); //12-最后一行，向下移动10行
		for(int i=0;i<createNum;i++){
			sheet.createRow(12+i);                              //在第13行之上产生10行
		}
//        XSSFCell newCell = newRow.createCell(0);
//        newCell.setCellValue("新插入的内容");
		CellCopyPolicy policy= new CellCopyPolicy();
		policy.setCopyCellFormula(true);
		policy.setCopyCellStyle(true);
		policy.setCopyCellValue(true);
		policy.setCopyMergedRegions(true);
		policy.setCopyRowHeight(true);
		policy.setCondenseRows(true);
		policy.setMergeHyperlink(true);

		for(int i=0;i<createNum;i++){
			sheet.copyRows(11, 11, 12+i, policy);          //index=0表示第一行， 将12行拷贝到第13行
		}


		FileOutputStream out=new FileOutputStream("C:\\Users\\lenovo\\Desktop\\报表导出\\poitest\\sofa-custom1.xlsx");
		workbook.write(out);

		out.flush();
		workbook.close();

	}

	public static void main4(String[] args) throws Exception {
		//产生10行
		int createNum=10;


		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\lenovo\\Desktop\\报表导出\\poitest\\客户测试模板-转换.xlsx"));
		XSSFSheet sheet = workbook.getSheetAt(0);

		sheet.shiftRows(12, sheet.getLastRowNum(), createNum); //12-最后一行，向下移动10行
		for(int i=0;i<createNum;i++){
			sheet.createRow(12+i);                              //在第13行之上产生10行
		}
//        XSSFCell newCell = newRow.createCell(0);
//        newCell.setCellValue("新插入的内容");
		CellCopyPolicy policy= new CellCopyPolicy();
		policy.setCopyCellFormula(true);
		policy.setCopyCellStyle(true);
		policy.setCopyCellValue(true);
		policy.setCopyMergedRegions(true);
		policy.setCopyRowHeight(true);
		policy.setCondenseRows(true);
		policy.setMergeHyperlink(true);

		for(int i=0;i<createNum;i++){
			sheet.copyRows(11, 11, 12+i, policy);          //index=0表示第一行， 将12行拷贝到第13行
		}


		FileOutputStream out=new FileOutputStream("C:\\Users\\lenovo\\Desktop\\报表导出\\poitest\\sofa-custom1.xlsx");
		workbook.write(out);

		out.flush();
		workbook.close();

	}
	
	
	public static void mainx(String[] args) throws Exception {
		//产生10行
		int createNum=10;


		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\lenovo\\Desktop\\报表导出\\poitest\\客户测试模板-转换.xlsx"));
		XSSFSheet sheet = workbook.getSheet("main");

		int rowNum = sheet.getLastRowNum();
		XSSFRow row = null;
		for(int i=0;i<rowNum;i++){
			 row = sheet.getRow(i);
			 
		}

		FileOutputStream out=new FileOutputStream("C:\\Users\\lenovo\\Desktop\\报表导出\\poitest\\sofa-custom1.xlsx");
		workbook.write(out);

		out.flush();
		workbook.close();

	}
}
