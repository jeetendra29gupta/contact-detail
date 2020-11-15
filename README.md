## Struts 2 Form Example
This tutorial is latest tutorial on Struts 2, which shows you how to develop Struts 2  Form Example.


- Step 1: Create a new maven project.
- Step 2: Add the struts 2 maven dependency.
- Step 3: Add the Struts 2 filter in the web.xml file.
- Step 4: Create a  struts.xml in src directory of the web application.

#### Now lets take a look at the MVC patters we have used here, 
- Model : Model represents an object or JAVA POJO carrying data. 
- View   : View represents the visualization of the data that model contain, In this project View part is where all JSP pages are kept.
- Controller :  Controller acts on both Model and view. It controls the data flow into model object and updates the view whenever data changes. It keeps View and Model separate. In this Project every other packages than model and view will be controller.

#### Struts 2 Maven Dependency

```
<!-- https://mvnrepository.com/artifact/org.apache.struts/struts2-core -->
<dependency>
    <groupId>org.apache.struts</groupId>
    <artifactId>struts2-core</artifactId>
    <version>2.5.25</version>
</dependency>
```

#### Struts 2 Maven Archetypes
A recommended way to start with Struts2 archetypes is to use archetype:generate goal with filter parameter.

```
mvn archetype:generate -Dfilter=org.apache:struts
```

