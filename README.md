# Term Scanner

## Function:
This repository will take the url of a terms and conditions agreement and return the most important/suspect clauses for the user to examine themselves without wasting time to parse through the whole mess of legal jargon.

## Design:
The first main file, InputCollection, will accept a url of an html agreement and then extract all of the relevant text. The second file, ScanForProblems, will take the output from the first file and search through it with a proprietary algorithm to identify sections of particular importance or suspicion. The third file, ReturnWhatMatters, will format the suspect clauses and return them to the user.
