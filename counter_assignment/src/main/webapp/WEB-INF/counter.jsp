<%@ page language = "java" contentType = "text/html; charset=UTF-8"
    pageEncoding = "UTF-8" %>

<!-- New line below to use the JSP Standard Tag Library (JSTL Import) -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
    <!-- for Bootstrap CSS -->
    <link rel = "stylesheet" href = "/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- For any Bootstrap that uses JS -->
    <script src = "/webjars/bootstrap/js/bootstrap.min.js"></script>
    
        <meta charset = "UTF-8">
        <title> Counter Page</title>
    </head>

<body>
    <p>
        You have visited <a href = "/"> The Welcome Page</a> <c:out value = "${count}"></c:out> times.
    </p>
    <p>
        <a href = "/"> Test Another Visit? </a>
    </p>
</body>
</html>