# spring-rest
sample spring based REST


steps to test this project:

1) download and install java jdk (not jre) at least 1.8
2) download and install apache maven (version 3.0.3 is tested to run, other higher versions has problem in my machine)
3) download and install spring tool suite 3.8.2
4) import the project (in spring tool suite, open the project at pom.xml level so it can identify the maven project)
5) at pom.xml, open a dos shell (if in windows) or a command line shell if using other OS
   and type "mvn jetty:run"
   this will cause maven to build the project into web application and deploy automatically to built in jetty web app server
   you can now open a browser and type "http://localhost:8080/testrest/rest/emps" and of course this will show you an empty
   page. no persistence (database) is use in this test project
   
   i use postman of chrome for testing this. postman for entering and deleting (post request) and for displaying, get request
   http://localhost:8080/testrest/rest/emps is used.
   
6) any question (as in any question, we will be noob once and will become experienced when questions are answered) 
   will be entertain in our group page
   
7) inside the project src > main > resources > how-to-use, there are screen shots coz postman is tricky at first. this will 
   help you in using postman for testing.
   
   for installing postman, open a chrome browser and add it as add-ins / plugins
   
   
   - enjoy
