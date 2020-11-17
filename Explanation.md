## Explanation for term_scanner

### How to use it yourself
1. Download Spire.doc by going to this [link](https://www.e-iceblue.com/Download/doc-for-java-free.html) and creating a free account.
2. Unzip Spire.doc and add the `.jar` file contained in the lib folder to your IDE's classpath. In Eclipse, for example, you right click on your package, then click on Build Path > Configure Build Path where you can then go to classpath > Add External JARs and find your Spire.doc
3. Figure out what you want to do with the repository and make an appropriate call -- if you want to *compare an updated EULA with a prior version* you can make a call to CompareVersions.compareVersions with the two file names of your EULAs in .docx form; whereas, if you want to get an annotated copy of an EULA with all the important bits highlighted in different colors and the longest string of capitalized legal jargon returned to you, make a call to ScanForProblems.scanEULA with the name of the .docx file where you have the text of your EULA.

### What do the annotation colors mean?

- Yellow: advertising clauses
- Red: information clauses
- Blue: third party agreements/affiliations
- Orange: opting out, arbitration,  liability, and indemnification
- Cyan: disclaimer of other content
