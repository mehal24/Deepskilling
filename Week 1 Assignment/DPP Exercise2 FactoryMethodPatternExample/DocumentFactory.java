public abstract class DocumentFactory {
    // The factory method
    public abstract Document createDocument();
    
    // Additional common factory logic could go here
    public void processDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
    }
}
