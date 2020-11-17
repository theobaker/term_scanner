## Explanation for term_scanner

### How to use it yourself
1. if you want to *compare an updated EULA with a prior version* you can make a call to `VersionComparison.compareVersions(String, String)` with the two file names of your EULAs in .docx form
2. if you want to get an *annotated copy of an EULA with all the important bits highlighted in different colors and the longest string of capitalized legal jargon returned to you*, make a call to `ProblemScanner.scanEULA(String)` with the name of the .docx file where you have the text of your EULA.

### What do the annotation colors mean?

- Yellow: advertising clauses
- Red: information clauses
- Blue: third party agreements/affiliations
- Orange: opting out, arbitration,  liability, and indemnification
- Cyan: disclaimer of other content
