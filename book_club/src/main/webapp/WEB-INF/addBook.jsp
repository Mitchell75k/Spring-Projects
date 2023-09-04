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
        <title> Add Book Form </title>
    </head>
    <body>
        <div class="container" style="display: flex; flex-direction: column; justify-content: center; justify-self: center; padding: 2%;">
            <div style="display: flex;flex-direction: row; margin-top: 30px; margin-bottom: 20px;">
                <h1 class="text-success"> Add a book to your shelf! </h1>
                <a style="margin-top: 10px; margin-left: 500px;" href="/home/bookclub">Back to shelf</a>
            </div>
            <div class="form"  style="display: flex; flex-direction: column; padding: 25px; width: auto; height: 550px; background-color: rgb(91, 152, 238) ;">
                <form:form method="post" action="/addBook/new"  modelAttribute="book">
                    <div class="form-group">
                        <form:label path="title" class="form-label" style="margin-right: 10px;"> <strong> Title: </strong> </form:label>
                        <form:errors path="title" class="form-error" style="display: flex; flex-direction: column; color: crimson; font-size: small;" />
                        <form:input path="title" class="form-input" type="text" style="margin-bottom: 20px;" />
                    </div>
                    <div class="form-group">
                        <form:label path="author" class="form-label" style="margin-right: 10px;"> <strong> Author: </strong> </form:label>
                        <form:errors path="author" class="form-error" style="display: flex; flex-direction: column; color: crimson; font-size: small;" />
                        <form:input path="author" class="form-input" type="text" style="margin-bottom: 20px;" />
                    </div>
                    <div class="form-group">
                        <form:label path="thoughts" class="form-label" style="margin-right: 10px; "> <strong> Thoughts: </strong> </form:label>
                        <form:errors path="thoughts" class="form-error" style="display: flex; flex-direction: column; color: crimson; font-size: small;" />
                        <form:textarea path="thoughts" class="form-input" type="text"  style=" width:500px;" />
                    </div>
                    <button type="submit" style="margin-top: 35px;" class="btn btn-success">Add Book</button>
                </form:form>
            </div>
    </body>