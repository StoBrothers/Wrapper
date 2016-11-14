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

Executor[INFO] - Result : &lt;strong&gt;Obama&lt;/strong&gt; visited &lt;strong&gt;Facebook&lt;/strong&gt; headquarters: &lt;a href=
&quot;http://bit.ly/xyz &quot;&gt;http://bit.ly/xyz &lt;/a &gt; @&lt;a href=&quot;http://twitter.com/elversatile &quot;&gt;elversatile&lt;/a&gt;

HTML code : <strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a href=
"http://bit.ly/xyz">http://bit.ly/xyz</a> @<a href="http://twitter.com/elversatile">elversatile</a>

[INFO] ------------------------------------------------------------------------

[INFO] BUILD SUCCESS

[INFO] ------------------------------------------------------------------------


How to add a new wrapper?
--------------------------

```
1. Please to create a new Wrapper class in a package: module.wrappers and implements HtmlWrapper.

2. Implemented a new methods in your wrapper: 

    public String getTagName() {
        return tagName;
    }

    public String wrap(String context) {
        return String.format(formatString, context);
    }

Method getTagName must be return a unique tag for parse and wrap;

Method  wrap(String context) must be wrap context and return a new String;

3. Compiled all projects and run it.

```

author: Sergey Stotskiy

