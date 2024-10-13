package com.mystore.utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	//Parameter Constructor for Excel utils
	public ExcelUtils(String pathname, String sheetname){
		try {
			workbook=new XSSFWorkbook(pathname);
			sheet=workbook.getSheet(sheetname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		//get the row count
		public int getrowcount() {
			int rowcount=0;
			try {
				rowcount=sheet.getPhysicalNumberOfRows();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
				e.printStackTrace();
			}
			
			return rowcount;
		}
		//get the cell text value
		public String getCellData(int rownum, int colnum) {
			String celltext=null;
			try {
				celltext=sheet.getRow(rownum).getCell(colnum).getStringCellValue();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
				e.printStackTrace();
			}
			return celltext;
			
		}
		

}
