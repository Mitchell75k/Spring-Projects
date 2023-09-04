<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!-- New line below to use the JSP Standard Tag Library (JSTL Import) -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" href="/css/style.css"> 
    <script type="text/javascript" src="/js/script.js"></script> <!-- New line to use the JavaScript file from: hopper_receipt/src/main/webapp/js/script.js -->
    
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- For any Bootstrap that uses JS -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    
        <meta charset="UTF-8">
        <title>Fruit Store</title>
    </head>

<body>
    <h1 class = "text-center text-success">Fruit Store</h1>
    <div class="container bg-success p-2 pt-3">
    <!-- create table with the headers: Name and price -->
        <table class="table table-hover table-light table-striped">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="fruit" items="${fruits}">
                    <tr>
                        <td><c:out value="${fruit.name}"></c:out></td>
                        <td><c:out value ="${fruit.price}"></c:out></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>