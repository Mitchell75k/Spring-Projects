<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- New line below to use the JSP Standard Tag Library (JSTL Import) -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!-- we need to import the Date class to be able to use it in our jsp, make sure to use <% %> -->

<%@ page import="java.util.Date" %> 

<!-- the purpose of jsp is to let you write java code in html --> 
<!-- remember: We had to add dependencies to our pom.xml file to be able to use jsp-->
<!--this html page is accessible by going to: http://localhost:8080/demo.jsp-->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Demo JSP</title>
    </head>
<body>
    <h1>Hello World!</h1>
    <!-- This is the JSTL tag , we are using to print out the dojoName variable from our controller -->
    <h3>Here's where our Dojo is located:  <c:out value="${dojoName}"></c:out></h3> 
    <!-- 
        -Inserting a Java for loop into your jsp, that will print out the numbers 0-4
        -The <% %> tags are used to insert java code into your jsp
        -This is sort of like jinja2 in python 
    -->

    <% for(int i = 0; i < 5; i++) { %>
        <h1><%= i %></h1>
    <% } %>
    <p>The time is: <%= new Date() %></p>
</body>
</html>