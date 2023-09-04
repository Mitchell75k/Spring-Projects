<%@ page language = "java" contentType = "text/html; charset=UTF-8"
    pageEncoding = "UTF-8" %>
    
<!-- New line below to use the JSP Standard Tag Library (JSTL Import) -->
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <!--for local CSS -->
        <link rel = "stylesheet" href = "/css/style.css" />
        <!-- for Bootstrap CSS -->
        <link rel = "stylesheet" href = "/webjars/bootstrap/css/bootstrap.min.css" />
        <!-- For any Bootstrap that uses JS -->
        <script src = "/webjars/bootstrap/js/bootstrap.min.js"></script>
        
        <meta charset = "UTF-8">
        <title> Book Details</title>
    </head>
    <body>
        <div class="container  mx-auto" style="display: flex; flex-direction: column; justify-content: center; align-items: center;">
            <h1 class="text-center text-primary" style="margin: 15px;"> "<c:out value="${book.title}"></c:out>" </h1>
            <div style="background-color: rgb(123, 191, 255); display: flex; width: 400px; padding: 20px;
            border: 3px; border-color: rgb(1, 15, 139); border-radius: 3%; border-style: solid; margin: 20px;" >
                <p>
                    <strong>Language:</strong> <c:out value = "${book.language}"></c:out><br>
                    <strong>Pages:</strong> <c:out value = "${book.numberOfPages}"></c:out><br>
                    <strong>Description:</strong> "<c:out value = "${book.description}"></c:out>"<br>
                </p>
            </div>
            <a style="margin-top: 10px;" href="/books">Back to Books</a> 
    </body>
</html>