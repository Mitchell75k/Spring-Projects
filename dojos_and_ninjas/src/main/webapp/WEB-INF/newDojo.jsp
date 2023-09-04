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
        <title> New Dojo Form Page</title>
    </head>
    <body>
        <div class="container" style="display: flex; flex-direction: column; justify-content: center; justify-self: center; padding: 2%; align-items: center;">
            <h3 style="margin-top: 70px;" class="text-success">Add a Dojo!</h3>
            <div style="display: flex; padding: 25px; width: 400px; background-color: rgb(91, 152, 238) ;">
                <form:form method="post" action="/dojos/create"  modelAttribute="dojo">
                    <div class="form-group" style="padding-left: 25px;">
                        <form:label  path="name" style="margin-bottom: 40px;" class="form-label" > Name: </form:label>
                        <form:errors path="name" class="form-error" />
                        <form:input path="name" class="form-input" type="text"/>
                    </div>
                    <button type="submit" class="btn btn-success">Create Dojo</button>
                </form:form>
            </div>
            <a style="margin-top: 20px;" href="/ninjas/new">Add a Ninja</a>
        </div>
    </body>