EnCo Java example
=================

Welcome to the Java spring based authentication example.
This example will perform the following steps:

1. Security initialisation
1. Simple userinfo retrieval
1. Structured userinfo retrieval (mapped to POJO)
1. SeAAS devices retrieval (this will only succeed if you have subscribed to the SeAAS asset)

To use this example, make sure to have Maven properly installed.

Before building, do make sure to insert your API Key and API Secret in the **AuthenticationsampleApplicationSpring.java**
file that you can find under src\main\java\io\enco

As part of the maven build (**mvn clean install**) the example should also run.

After a successful build, it is also possible to run the example with

> java -jar target\authenticationsample-1.0.0-SNAPSHOT-single-jar.jar


You're welcome to have a go with these and we welcome your comments, feedback, improvements, questions, ....

And if needed, you will find related information on our [**documentation site**](http://docs.enco.io/) as well.

Cheers,
The EnCo team.
