# ETLJavaAssignment

ETL process – Extract Transform and Load
__________________________________________________________________
Application Information 

First Part
- Read files from a directory
- For each file read contents of the file
- Capitalize the contents of the file 
- Then write the capitalized content into another output file with the same name in a different directory

Second Part:
- Read all the unique words from the file
- For each word calculate the word count 
- For eg: for a file containing the content
  “Hello world, hello”
  - In this case the summary would be 
      hello -> 2
      world -> 1
- Cases should be ignored – Hello and hello mean the same word
- This summary should then be added to an output file with the same name in a different directory 

_________________________________________________________________________

NOTE:- To Run this application, Need to update JUnit Testcase with Path information in class 'ExtractTransformLoadServiceTest'  and then Run JUnit Test.
