import java.io.*;
import java.util.*;
public class AdFinder {
	public ArrayList<String> findAdAgreements(String nameOfFile){

		String filename = nameOfFile;
		BufferedReader reader;
		//read through the given file to extract sections beginning with "ad"
		try {
			reader = new BufferedReader(new FileReader(filename));

		}
		catch(Exception e) {
			e.printStackTrace();
		}



		return null;

	}
}
