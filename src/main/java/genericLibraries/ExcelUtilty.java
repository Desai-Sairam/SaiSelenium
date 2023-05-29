package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilty{

	private Workbook wb;
	public void excelInitialization(String excelPath) {
		
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			wb=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}
	public String readData(String sheetName, int rowNum, int cellNum) {
		DataFormatter df=new DataFormatter();
		String data=df.formatCellValue(wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		return data;
		
	}
	public Map<String, String> readData(String sheetName){
		DataFormatter df= new DataFormatter();
		Map<String, String> map=new HashMap<>();
		Sheet sh=wb.getSheet(sheetName);
		for(int i=0; i <= sh.getLastRowNum();i++) {
			String key=df.formatCellValue(sh.getRow(i).getCell(0));
			String value=df.formatCellValue(sh.getRow(i).getCell(1));
			map.put(key, value);
		}
		return map;
		
	}
	public void writeToExcel(String sheetName, int rowNum, int cellNum, String excelPath, String data) {
		Cell cell=wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void closeWorkbook() {
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
