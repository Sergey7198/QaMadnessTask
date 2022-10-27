Hello!

Checklists and Bug report are stored as a simple .txt files on the top of the project's structure

Main automation tests are stored in "src/test/java/com/englishdom"

You can run tests using TestNG or Maven. Tests divided into groups, so can be easily run by Maven e.g. using command "mvn test -Dgroups=ApiTests" or "mvn test -Dgroups=LoginTests". Added tesng.xml files, so that you can run whole class for example

This tesng file is not created yet because there were no need for that and not required.

To run the tests locally on your laptop you need to :

Clone the project from github
Go to the test class and run using TestNG
For the API scripts, if you're using inteliji idea - there can be the need to download and to add manually jar file for json-schema-validator