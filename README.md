Hello!

Checklists and Bug report are stored as a simple .txt files on the top of the project's structure

Main automation tests are stored in "src/test/java/com/englishdom"

Tests can be launched by TestNG. In case of Maven - there is the tag "suiteXmlFiles" in pom.xml file that defines the main tesng file with classes for launching.
This tesng file is not created yet because there were no need for that and not required.

To run the tests locally on your laptop you need to : 

1. Clone the project from github
2. Go to the test class and run using TestNG
3. For the API scripts, if you're using inteliji idea - there can be the need to download and to add manually jar file for json-schema-validator
4. To run tests using maven - mvn test -Dgroups=ApiTests or mvn test -Dgroups=UiTests