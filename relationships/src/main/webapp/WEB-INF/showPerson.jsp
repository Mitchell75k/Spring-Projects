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
        <!--- ... --->
        <h1>Person Details:></h1>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th>Name</th>
                    <th>License Number</th>
                    <th>State</th>
                    <th>Exp Date</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${person.firstName}"/>
                        <c:out value="${person.lastName}"/>
                    </td>
                    <!-- Grabbing license info via dot notation since the person object has a license attribute, so its linked to the person.-->
                    <td><c:out value="${person.license.number}"/></td>
                    <td><c:out value="${person.license.state}"/></td>
                    <td>
                        <c:out value="${person.license.expirationDate}"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
