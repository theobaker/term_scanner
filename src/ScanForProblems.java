public class ScanForProblems {

  //scan for: information clauses (where information goes), often characterized by "Sharing of Information"
  //scan for: "Third Parties and affiliations"
  //scan for: "Opt out"
  //scan for: section title: "arbitration"
  //scan for: sections written in all caps (these tend to be important, regardless of their contents)
  String str = "This is an example string. HERE IS THE IMPORTANT SECTION OF TEXT. There may also be SMALL capitalized sections.";
  String[] substrings = str.split("[^A-Z]+");//get all capitalized substrings
  String longestCapsSection = "";
  int longestLength = 0;
  for (String s : substrings){
    if (s.length() > longestLength){
      longestLength = s.length();
      longestCapsSection = s;
    }//there may be smaller sections that aren't important but are capitalized(like individual words) so this finds the largest section within a string. could split the entire terms and conditions into strings based on section headers, then find the specific capitalized parts of an individual string
  }
  System.out.println(longestCapsSection); //remove this when you want to use it, just for testing purposes
  //scan for: "Disclaimer of other content" (often used to slip in things which aren't part of what the user expects)
  //I think there have to be some specific things to scan for only in all-caps sections; American Law says that important things have to be conspicuously labelled, and comapnies respond by having HUGE LONG LINES OF ALL CAPS TEXT
  //definitely need to have a potentially questionable category for things like sections beginning with "limitations" and "responsibilities"


}
