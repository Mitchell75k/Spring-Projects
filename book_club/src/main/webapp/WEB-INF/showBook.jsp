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
        <title> Specific Book Details Page</title>
    </head>
    <body>
        <div class="container" style="display: flex; flex-direction: column; justify-content: center; justify-self: center; padding: 2%;">
            <div style="display: flex;flex-direction: row; margin-top: 30px; margin-bottom: 15px;">
                <h1 class="text-success">"<c:out value="${book.title}"></c:out>"</h1>
                <a style="margin-top: 10px; margin-left: 700px;" href="/home/bookclub">Back to shelf</a>
            </div>
            <h4 style="margin-bottom: 20px;"> <c:out value="${bookReviewer.userName}"></c:out> read "<c:out value="${book.title}"></c:out>" by <c:out value="${book.author}"></c:out>.</h4>
            <h6 style="margin-bottom: 40px;">Here are some thoughts from <c:out value="${bookReviewer.userName}"></c:out>:</h6>
            <div style="display: flex;flex-direction: column;">
                <div style="padding: 40px; background-color: rgb(91, 152, 238) ;">
                    <div style="display: flex; flex-direction: column; padding: 25px; width: auto; height: 500px; background-color: rgb(255, 255, 255) ; justify-content: flex-start; align-items: center;">
                        <div style="margin-top: 20px;">
                            <p style="align-self: center;"><c:out value="${book.thoughts}"></c:out></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>