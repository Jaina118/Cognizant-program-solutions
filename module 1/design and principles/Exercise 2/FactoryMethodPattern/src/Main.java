public class Main {
    public static void main(String[] args) {
        DocumentFactory factory;
        Document document;

        // Word Document
        factory = new WordDocumentFactory();
        document = factory.createDocument();
        document.open();
        document.save();
        document.close();

        System.out.println();

        // PDF Document
        factory = new PdfDocumentFactory();
        document = factory.createDocument();
        document.open();
        document.save();
        document.close();

        System.out.println();

        // Excel Document
        factory = new ExcelDocumentFactory();
        document = factory.createDocument();
        document.open();
        document.save();
        document.close();
    }
}
