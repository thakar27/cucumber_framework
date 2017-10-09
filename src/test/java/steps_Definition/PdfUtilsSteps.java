package steps_Definition;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utilities.PdfUtils;

public class PdfUtilsSteps {

    PdfUtils pdfUtils = new PdfUtils();

    @Given("^I have a uncrypted pdf file$")
    public void i_have_a_uncrypted_pdf_file() throws Throwable {
        pdfUtils.iHaveAUncryptedPdfFile();
    }

    @Then("^I should extract the file$")
    public void i_should_extract_the_file() throws Throwable {
        Assert.assertTrue("I should extract the file", pdfUtils.iShouldExtractTheFile());
    }

    @Then("^pdf file should be unencrypted$")
    public void pdf_file_should_be_unencrypted() throws Throwable {
        Assert.assertTrue("pdf file should be unencrypted", !pdfUtils.pdfFileShouldBeUnencrypted());
    }

    @Then("^I should be able to search some text from the pdf file$")
    public void i_should_be_able_to_search_some_text_from_the_pdf_file() throws Throwable {
        Assert.assertTrue("I should be able to search some text from the pdf file", pdfUtils.searchTextIntoPdfFile("OnePlus"));
    }

    @Then("^PDF document should contain number of pages$")
    public void pdf_document_should_contain_number_of_pages() throws Throwable {
        Assert.assertTrue("PDF document should contain number of pages", pdfUtils.getNumberOfPages()>0);
    }

}
