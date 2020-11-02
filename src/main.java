// this is where you can combine all of the functions you mentioned into a main class
// I added in where you could read in inputs from config into the map
// when you need to 


public class myfolder {
  
   
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("config.txt"));


		String workingDir = System.getProperty("user.dir");
		String configPath = workingDir + File.separator + "config.txt"; // using relative path
		BufferedReader config = new BufferedReader(new FileReader(configPath));

		Map<String, String> map = new HashMap<String, String>();
		while(true) {
            String entry = config.readLine();
            if(entry == null || entry.trim().equals("")) {
            	break;
            }
			StringTokenizer st = new StringTokenizer(entry, "=");
			map.put(st.nextToken(), st.nextToken());

		}
        config.close();

// this is an example of how you could extract information from the config.txt
        String document = map.get("Document");
    }
}