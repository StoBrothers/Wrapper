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

[INFO]
[INFO] --- exec-maven-plugin:1.5.0:java (default-cli) @ modulethird ---
16:31:57 [module.ThirdModule.main()] WrapperLoader[INFO] - Was founded 3 wrappers
16:31:57 [module.ThirdModule.main()] ParserParameterString[INFO] - Parse parameter string:  positions 14 through 22 Ú∆“ Entity
16:31:57 [module.ThirdModule.main()] ParserParameterString[INFO] - Parse parameter string:  positions 0 through 5 Ú∆“ Entity
16:31:57 [module.ThirdModule.main()] ParserParameterString[INFO] - Parse parameter string:  positions 56 through 67 Ú∆“ Twitter username
16:31:57 [module.ThirdModule.main()] ParserParameterString[INFO] - Parse parameter string:  positions 37 through 54 Ú∆“ Link
16:31:58 [module.ThirdModule.main()] Executor[INFO] - Result : <strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a href=
"http://bit.ly/xyz">http://bit.ly/xyz</a> @<a href="http://twitter.com/elversatile">elversatile</a>
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 21.116 s
[INFO] Finished at: 2016-11-14T16:31:58+03:00
[INFO] Final Memory: 17M/148M
[INFO] ------------------------------------------------------------------------

author: Sergey Stotskiy

