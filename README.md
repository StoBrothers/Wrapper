# wrapper

HTML Wrapper.
   
========================

Requirements
------------
Install Java 8.65 version
http://www.oracle.com/ 

Install Apache Maven 
https://maven.apache.org

How to run a project?
--------------------------

```
mvn clean install exec:java -Dexec.mainClass="module.ThirdModule"
```
Example of execution:

[INFO] --- exec-maven-plugin:1.5.0:java (default-cli) @ modulethird ---

WrapperLoader[INFO] - Was founded 3 wrappers

ParserParameterString[INFO] - Parse parameter string:  positions 14 through 22 -> Entity

ParserParameterString[INFO] - Parse parameter string:  positions 0 through 5 -> Entity

ParserParameterString[INFO] - Parse parameter string:  positions 56 through 67 -> Twitter username

ParserParameterString[INFO] - Parse parameter string:  positions 37 through 54 -> Link

Executor[INFO] - Result : &lt;strong&gt;Obama&lt;/strong&gt; visited &lt;strong&gt;Facebook&lt;/strong&gt; headquarters: &lt;a href=
&quot;http://bit.ly/xyz &quot;&gt;http://bit.ly/xyz &lt;/a &gt; @&lt;a href=&quot;http://twitter.com/elversatile &quot;&gt;elversatile&lt;/a&gt;

[INFO] ------------------------------------------------------------------------

[INFO] BUILD SUCCESS

[INFO] ------------------------------------------------------------------------


Result HTML code : <strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a href=
"http://bit.ly/xyz">http://bit.ly/xyz</a> @<a href="http://twitter.com/elversatile">elversatile</a>


How to add a new wrapper?
--------------------------

```
1. Please create a new Wrapper class in a package module.wrappers which implements HtmlWrapper.

2. Implement new methods in your wrapper: 

    public String getTagName() {
        return tagName;
    }

    public String wrap(String context) {
        return String.format(formatString, context);
    }

Method getTagName should return a unique tag;

Method  wrap(String context) performs wrapping, it returns a new String based on initial context;

3. Compile project and run it using following commands:

```
mvn clean install exec:java -Dexec.mainClass="module.ThirdModule"
```

author: Sergey Stotskiy

