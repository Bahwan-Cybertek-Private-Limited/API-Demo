package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;




/*
 * All the utilities needed for the framework is placed in this class including excel utilities, screenshot capture.
 * We have used method overloading concept in getCellContent Method.
 */
public class TestUtils {

	public static FileInputStream fs;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static List<String> testCases= new ArrayList<String>();
	public static List<String> runStatus= new ArrayList<String>();
	public static List<String> testDescription= new ArrayList<String>();
	public static List<String> invocationCount= new ArrayList<String>();
	public static List<String> priority= new ArrayList<String>();
	public static HashMap<Integer,String> rowAndTestCaseMap=new HashMap<Integer,String>();


	
	
	public String retrieveData(String sce_name, String parameter)
	{
		String retrv_data = null;
		
		try {
			File file1 = new File("/data/TestData.xlsx");
			
			FileInputStream fileInputStream1 = new FileInputStream(file1);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream1);
			XSSFSheet worksheet = workbook.getSheet("TestData");
			
			int Rcnt = worksheet.getLastRowNum();
			for(int i=0;i<=Rcnt;i=i+3)
			{
				XSSFRow row1 = worksheet.getRow(i);
				XSSFCell data1 = row1.getCell(0);
				
				if(data1.toString().equalsIgnoreCase(sce_name))//scenario name 
				{
					int Ccnt = row1.getLastCellNum();
					for(int j=0;j<Ccnt;j++)
					{
						XSSFCell data2 = row1.getCell(j);
						if(data2.toString().equalsIgnoreCase(parameter))///parameter
						{
							XSSFRow row2 = worksheet.getRow(i+1);
							XSSFCell retrv = row2.getCell(j);
							retrv_data = retrv.toString();
						}
					}					
				}	
			}			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return(retrv_data);
	}	
	
	
	
}
