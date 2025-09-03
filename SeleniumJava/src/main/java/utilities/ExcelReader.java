package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	String path;
	FileInputStream fi;
	FileOutputStream fo;
	Workbook workbook;
	Sheet sheet;
	Row row;
	Cell cell;
	
	public ExcelReader(String path) {
		this.path=path;
	}
	
	public Object getCellValue(String sheetName, int rowNumber,int columnNumber) throws IOException {
		fi=new FileInputStream(new File(path));
		if(path.contains(".xlsx")) {
			workbook=new XSSFWorkbook(fi);
		}
		else if(path.contains(".xls")) {
			workbook=new HSSFWorkbook(fi);
		}
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNumber);
		cell=row.getCell(columnNumber);
		Object value=0;
		if(cell.getCellType()==CellType.STRING) {
			value=cell.getStringCellValue();
		}
		else if(cell.getCellType()==CellType.NUMERIC) {
			value=cell.getNumericCellValue();
		}
		workbook.close();
		return value;
	}
	
	public void setCellValue(String sheetName,int rowNumber,int columnNumber,String cellValue) throws IOException {
		if(path.contains(".xlsx")){
			workbook=new XSSFWorkbook();
		}
		else if(path.contains(".xls")) {
			workbook=new HSSFWorkbook();
		}
		if(workbook.getSheet(sheetName)==null) {
			sheet=workbook.createSheet(sheetName);
		}
		else {
			sheet=workbook.getSheet(sheetName);
		}
		row=sheet.createRow(rowNumber);
		row.createCell(columnNumber).setCellValue(cellValue);
		
		fo=new FileOutputStream(new File(path));
		workbook.write(fo);
		workbook.close();
	}
	
	public Map<String,Object> getRow(String sheetName,int rowNumber) throws IOException{
		Map<String,Object> values=new HashMap<>();
		fi=new FileInputStream(new File(path));
		if(path.contains(".xlsx")) {
			workbook=new XSSFWorkbook(fi);
		}
		else if(path.contains(".xls")) {
			workbook=new HSSFWorkbook(fi);
		}
		sheet=workbook.getSheet(sheetName);
		Row header=sheet.getRow(0);
		row=sheet.getRow(rowNumber);
		
		for(int i=0;i<row.getLastCellNum();i++) {
			cell=row.getCell(i);
			if(cell.getCellType()==CellType.STRING) {
				values.put(header.getCell(i).getStringCellValue(), cell.getStringCellValue());
			}
			else if(cell.getCellType()==CellType.NUMERIC) {
				values.put(header.getCell(i).getStringCellValue(),cell.getNumericCellValue());
			}
		}
		workbook.close();
		return values;
	}
	
	public void setRow(String sheetName,List<String> key,List<Object> value) throws IOException {
		boolean values=false;
		Row rowHead=null;
		if(path.contains(".xlsx")){
			workbook=new XSSFWorkbook();
		}
		else if(path.contains(".xls")) {
			workbook=new HSSFWorkbook();
		}
		if(workbook.getSheet(sheetName)==null) {
			sheet=workbook.createSheet(sheetName);
			rowHead=sheet.createRow(sheet.getLastRowNum()+1);
			values=true;
		}
		else {
			sheet=workbook.getSheet(sheetName);
		}
		row=sheet.createRow(sheet.getLastRowNum()+1);
		for(int i=0;i<key.size();i++) {
			if(values) {
				rowHead.createCell(i).setCellValue(key.get(i));
			}
			row.createCell(i).setCellValue(value.get(i).toString());
		}
		
		fo=new FileOutputStream(new File(path));
		workbook.write(fo);
		workbook.close();
	}
}
