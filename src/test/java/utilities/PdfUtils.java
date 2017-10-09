package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.junit.Assert;

public class PdfUtils {

    PDDocument pdfDocument;
    String     unCryptedPdfFile = "src\\test\\resources\\Uncrypted.pdf";
    String     extractedTextFromPdfFile;
    
    public PdfUtils() {

    }

    public void iHaveAUncryptedPdfFile() {
        try {
            pdfDocument = PDDocument.load(new File(unCryptedPdfFile));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public boolean pdfFileShouldBeUnencrypted() {
        return pdfDocument.isEncrypted();
    }

    public boolean iShouldExtractTheFile() throws IOException {
        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
        PDFTextStripper tStripper = new PDFTextStripper();
        if (!pdfDocument.isEncrypted()) {
            stripper.setSortByPosition(true);
            extractedTextFromPdfFile = tStripper.getText(pdfDocument);
            return extractedTextFromPdfFile.length() > 0;
        }
        return false;
    }

    public boolean searchTextIntoPdfFile(String string) {
        return extractedTextFromPdfFile.contains(string);
    }
    
    public int getNumberOfPages(){
        return pdfDocument.getNumberOfPages();
    }

    public void extractPDFText() throws IOException {
        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
        PDFTextStripper tStripper = new PDFTextStripper();

        try (PDDocument document = PDDocument.load(new File("src\\test\\resources\\Invoice.pdf"))) {
            System.out.println(document.getNumberOfPages());
            System.out.println(document.isEncrypted());
            document.getClass();
            if (!document.isEncrypted()) {
                stripper.setSortByPosition(true);
                String pdfFileInText = tStripper.getText(document);
                System.out.println(pdfFileInText);
                //System.out.println("Text:" + st);

                // split by whitespace
                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
                    System.out.println(line);
                }
                Assert.assertTrue("PDF text should get extracted", pdfFileInText.length() > 0);
            }
        }
    }
}
