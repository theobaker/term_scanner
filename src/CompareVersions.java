import com.spire.doc.Document;

public class CompareVersions {
	
	
	public static void compareVersions(String version1Name, String version2Name) {
		
		Document doc1 = new Document();
		
		// load the first Word document from the name provided
		
		doc1.loadFromFile(version1Name);
		
		Document doc2 = new Document();
		
		//load the second Word document from the name provided
		
		doc2.loadFromFile(version2Name);
		
		//Compare the two documents for changes
		
		doc1.compare(doc2, "E-iceblue");
		
		//Save the result to a file
		doc1.saveToFile("ChangesInEULA.docx");
	}
}