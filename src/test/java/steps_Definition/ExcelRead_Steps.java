package steps_Definition;

import java.io.IOException;

import code.ExcelRead;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import utilities.CommonCode;

public class ExcelRead_Steps extends CommonCode {
	ExcelRead objExcelRead = new ExcelRead();

	@Given("^Member reads data from excel sheet$")
	public void Member_reads_data_from_excel_sheet() throws IOException {
		objExcelRead.ReadData();
	}

}
