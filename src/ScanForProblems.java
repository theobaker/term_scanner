import java.awt.Color;
import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.documents.TextSelection;


public class ScanForProblems {
	public static String scanEULA(String fileName) {

		//Load Word document with text of contract from provided name
		Document document = new Document();
		
		document.loadFromFile(fileName);
		
		
		//Find all occasions of the word advertisement
		TextSelection[] fullWord = document.findAllString("advertisement", false, true);
		TextSelection[] shortening = document.findAllString("ad", false, true);

		//Set Highlight color for ads as Yellow
		for (TextSelection selection : fullWord) {
			selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.YELLOW);
		}
		for (TextSelection selection: shortening) {
			selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.YELLOW);

		}
		
		// find all information clauses and highlight in red
		TextSelection[] information = document.findAllString("information", false, true);
		
		for (TextSelection selection: information) {
			selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.RED);

		}
		
		// find all third party agreements and highlight in blue
		TextSelection[] thirdParty = document.findAllString("third party", false, true);
		TextSelection[] thirdParties = document.findAllString("third parties", false, true);
		TextSelection[] affiliation = document.findAllString("affiliation", false, true);
		
		for (TextSelection selection: thirdParty) {
			selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.BLUE);

		}
		for (TextSelection selection: thirdParties) {
			selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.BLUE);

		}
		for (TextSelection selection: affiliation) {
			selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.BLUE);

		}
		
		
		//scan for: "Opt out"- orange for all contract leaving things
		TextSelection[] optOut = document.findAllString("opt out", false, true);
		
		for (TextSelection selection: optOut) {
			selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.ORANGE);

		}
		//scan for: section title: "arbitration"
		TextSelection[] arbitration = document.findAllString("arbitration", false, true);
		
		for (TextSelection selection: arbitration) {
			selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.ORANGE);

		}
		//scan for "indemnify"- used for sketchy waivers
		TextSelection[] indemnify = document.findAllString("indemnify", false, true);
		
		for (TextSelection selection: indemnify) {
			selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.ORANGE);

		}
		//scan for: sections written in all caps (these tend to be important, regardless of their contents)

		// use Spire.doc to get all the text of the document into a string
        String text=document.getText();
        
		String[] substrings = text.split("[^A-Z]+");//get all capitalized substrings
		String longestCapsSection = "";
		int longestLength = 0;

		for (String s : substrings){
			if (s.length() > longestLength){
				longestLength = s.length();
				longestCapsSection = s;
			}
		}
		 
		
		//scan for: "Disclaimer of other content" (often used to slip in things which aren't part of what the user expects)
		//I think there have to be some specific things to scan for only in all-caps sections; American Law says that important things have to be conspicuously labelled, and comapnies respond by having HUGE LONG LINES OF ALL CAPS TEXT
		//definitely need to have a potentially questionable category for things like sections beginning with "limitations" and "responsibilities"

		document.saveToFile("AnnotatedEULA.docx", FileFormat.Docx_2013);
		
		return (longestCapsSection);
	}
}
