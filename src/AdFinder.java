import java.io.*;
import java.util.*;
import com.spire.doc.*;
import com.spire.doc.documents.TextSelection;

import java.awt.*;
public class AdFinder {
	public static void findAdAgreements(){

		//Load Word document
		Document document = new Document("Input.docx");
        //Find all occasions of the word advertisement
		TextSelection[] textSelections = document.findAllString("advertisement", false, true);

		//Set Highlight color for ads as Yellow
		for (TextSelection selection : textSelections) {
            selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.YELLOW);
        }
        document.saveToFile("AdvertisementHighlighted.docx", FileFormat.Docx_2013);

//		String filename = nameOfFile;
//		BufferedReader reader;
//		//read through the given file to extract sections beginning with "ad"
//		try {
//			reader = new BufferedReader(new FileReader(filename));
//			
//
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}




	}
}
