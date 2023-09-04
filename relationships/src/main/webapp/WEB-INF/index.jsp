<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <!--for local CSS -->
        <link rel = "stylesheet" href = "/css/style.css" />
        
        <!-- for Bootstrap CSS -->
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
        
        <!-- For any Bootstrap that uses JS -->
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/js/app.js"></script> <!-- change to match your file/naming structure -->
        
        <meta charset = "UTF-8">
        <title> Safe Travels Home Page</title>
    </head>
    <body>
        <!--- inside the form:form --->
        <!--- Drop down select menu --->
        <form:form method="post" action="/licenses" class="form"> 
        <form:select path="person"> <!--"person" path references the "person" attribute in the License class-->
            <c:forEach var="onePerson" items="${persons}">
                <!--- Each option VALUE is the id of the person --->
                <form:option value="${onePerson.id}" path="person">
                <!--- This is what shows to the user as the option --->
                    <c:out value="${onePerson.firstName}"/>
                    <c:out value="${onePerson.lastName}"/>
                </form:option>
            </c:forEach>
        </form:select>
    <!--- ... --->
    <!--- ... --->
    </body>