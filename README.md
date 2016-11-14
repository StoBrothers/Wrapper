# wrapper

Wrapper.
   
========================

Requirements
------------
Install Java 8.65 version
http://www.oracle.com/ 

Install Apache Maven 
https://maven.apache.org

How run a project?
--------------------------

```
mvn clean install exec:java -Dexec.mainClass="module.ThirdModule"
```
Example of execution:

[INFO] --- exec-maven-plugin:1.5.0:java (default-cli) @ modulethird ---

WrapperLoader[INFO] - Was founded 3 wrappers

ParserParameterString[INFO] - Parse parameter string:  positions 14 through 22 Ú∆“ Entity

ParserParameterString[INFO] - Parse parameter string:  positions 0 through 5 Ú∆“ Entity

ParserParameterString[INFO] - Parse parameter string:  positions 56 through 67 Ú∆“ Twitter username

ParserParameterString[INFO] - Parse parameter string:  positions 37 through 54 Ú∆“ Link

Executor[INFO] - Result : &lt strong &gt Obama</strong> visited <strong>Facebook</strong> headquarters: <a href=
"http://bit.ly/xyz">http://bit.ly/xyz</a> @<a href="http://twitter.com/elversatile">elversatile</a>

[INFO] ------------------------------------------------------------------------

[INFO] BUILD SUCCESS

[INFO] ------------------------------------------------------------------------

author: Sergey Stotskiy

