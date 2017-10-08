package code;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public void readExcel(String filePath, String fileName, String sheetName)
			throws IOException {

		File file = new File(filePath + "\\" + fileName);

		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {

			workbook = new XSSFWorkbook(inputStream);

		}

		else if (fileExtensionName.equals(".xls")) {

			workbook = new HSSFWorkbook(inputStream);

		}

		Sheet sheet = workbook.getSheet(sheetName);

		int actualRowCount = sheet.getPhysicalNumberOfRows();
		int rowCount = actualRowCount;

		for (int i = 0; i < rowCount; i++) {

			Row row = sheet.getRow(i);

			for (int j = 0; j < row.getLastCellNum(); j++) {

				System.out.print(row.getCell(j).getStringCellValue() + "|| ");

			}

			System.out.println();
		}

	}

	public void ReadData() throws IOException {

		ExcelRead objExcelFile = new ExcelRead();

		String filePath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel";

		objExcelFile.readExcel(filePath, "ExportExcel.xlsx", "ExcelDemo");
	}

}
