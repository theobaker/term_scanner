# Term Scanner

## Rationale:
With sample terms and conditions from Apple and Facebook often taking over 20,000 words of dense ridiculousness to get to a point, it's impossible for a responsible user to actually go through every legal agreement required to live a normal life. Problematic phrases go unnoticed all the time. This repository will help identify some of those so users don't have to do so manually.

## Function:
This repository will take the text of a terms and conditions agreement and return the most important/suspect clauses for the user to examine themselves without wasting time to parse through the whole mess of legal jargon.  The repository will scan for clausal structure and phrasing that human review of pre-existing agreements has labelled worrisome and then organizes them into the categories described in important_clauses.md. Specifically, it will use the Google Docs API to highlight portions of the text deemed important, as well as returning a categorized breakdown of how many clauses were found in the different categories of importance.
