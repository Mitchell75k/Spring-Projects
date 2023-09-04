<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
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
        <title> Logged In User Page</title>
    </head>
    <body>
        <div class="container" style="display: flex; flex-direction: column; justify-content: center; justify-self: center; padding: 2%; align-items: center;">
            <h3 style="margin-top: 70px;" class="text-success">Welcome <c:out value="${user.userName}"></c:out>!</h3>
            <h5 style="margin-bottom: 20px;">Check out whats new:</h5>
            <div style="display: flex;flex-direction: row; align-items: center;">
                <div style="display: flex; flex-direction: column; padding: 25px; width: 500px; height: 500px; background-color: rgb(91, 152, 238) ;">
                    <h1 style="margin-bottom: 20px; align-self: center;"><c:out value="${user.userName}"></c:out>'s Dashboard</h1>
                    <p style="align-self: center;">Nothing to see yet!</p>
                </div>
            </div>
            <a href="/logout">Log Out?</a>
    </body>
</html>
