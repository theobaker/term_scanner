import java.awt.Color;
import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.documents.TextSelection;


public class ProblemScanner {
	public static String scanEULA(String fileName) {

		//Load Word document with text of contract from provided name
		Document document = new Document(fileName);



		//Find all occasions of the word advertisement
		TextSelection[] fullWord = document.findAllString("advertisement", false, true);
		TextSelection[] shortening = document.findAllString("ad", false, true);

		//Set Highlight color for ads as Yellow
		if (fullWord != null) {
			for (TextSelection selection : fullWord) {
				selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.YELLOW);
			}
		}

		if (shortening != null) {
			for (TextSelection selection: shortening) {
				selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.YELLOW);

			}
		}

		// find all information clauses and highlight in red
		TextSelection[] information = document.findAllString("information", false, true);

		if (information != null) {
			for (TextSelection selection: information) {
				selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.RED);

			}
		}
		
		//scan for IP and also put in red
		TextSelection[] ip = document.findAllString("intellectual property", false, true);

		if (ip != null) {
			for (TextSelection selection: ip) {
				selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.RED);

			}
		}

		// find all third party agreements and highlight in blue
		TextSelection[] thirdParty = document.findAllString("third party", false, true);
		TextSelection[] thirdParties = document.findAllString("third parties", false, true);
		TextSelection[] affiliation = document.findAllString("affiliation", false, true);

		if (thirdParty != null) {
			for (TextSelection selection: thirdParty) {
				selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.BLUE);

			}
		}

		if (thirdParties != null) {
			for (TextSelection selection: thirdParties) {
				selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.BLUE);

			}
		}

		if (affiliation != null) {
			for (TextSelection selection: affiliation) {
				selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.BLUE);

			}
		}


		//scan for: "Opt out"- orange for all contract leaving things
		TextSelection[] optOut = document.findAllString("opt out", false, true);
		TextSelection[] termination = document.findAllString("termination", false, true);

		if (optOut != null) {
			for (TextSelection selection: optOut) {
				selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.ORANGE);

			}
		}
		
		if (termination != null) {
			for (TextSelection selection: termination) {
				selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.ORANGE);
			}
		}

		//scan for: arbitration and liability
		TextSelection[] arbitration = document.findAllString("arbitration", false, true);
		TextSelection[] liability = document.findAllString("liability", false, true);

		if (arbitration != null) {
			for (TextSelection selection: arbitration) {
				selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.ORANGE);

			}
		}
		
		if (liability != null) {
			for (TextSelection selection: liability) {
				selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.ORANGE);

			}
		}
		//scan for "indemnify"- used for sketchy waivers
		TextSelection[] indemnify = document.findAllString("indemnify", false, true);

		if (indemnify != null) {
			for (TextSelection selection: indemnify) {
				selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.ORANGE);

			}
		}
		
		//scan for fines
		//also goes in orange
		TextSelection[] fines = document.findAllString("fine", false, true);

		if (fines != null) {
			for (TextSelection selection: fines) {
				selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.ORANGE);

			}
		}
		
		//scan for: "Disclaimer of other content" (often used to slip in things which aren't part of what the user expects)
		//highlight in cyan
		TextSelection[] disclaimer = document.findAllString("Disclaimer of other content", false, true);

		if (disclaimer != null) {
			for (TextSelection selection: disclaimer) {
				selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.CYAN);

			}
		}
		
		
		
		//scan for: sections written in all caps (these tend to be important, regardless of their contents)

		// use Spire.doc to get all the text of the document into a string
		String text=document.getText();

		String[] substrings = text.split("[^A-Z]+");//get all capitalized substrings
		String longestCapsSection = "";
		int longestLength = 0;

		for (String s : substrings){
			if (s.length() > longestLength){
				longestCapsSection = s;
			}
		}


		
		//I think there have to be some specific things to scan for only in all-caps sections; American Law says that important things have to be conspicuously labelled, and comapnies respond by having HUGE LONG LINES OF ALL CAPS TEXT
		//definitely need to have a potentially questionable category for things like sections beginning with "limitations" and "responsibilities"

		document.saveToFile("AnnotatedEULA.docx", FileFormat.Docx_2013);

		return (longestCapsSection);
	}
}
