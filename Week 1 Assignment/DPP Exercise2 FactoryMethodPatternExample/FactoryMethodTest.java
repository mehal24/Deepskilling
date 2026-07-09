public class FactoryMethodTest {
    public static void main(String[] args) {
        
        // Creating a Word Document using its specific factory
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        
        System.out.println("--------------------");

        // Creating a PDF Document using its specific factory
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        System.out.println("--------------------");
        
        // Creating an Excel Document using its specific factory
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}
