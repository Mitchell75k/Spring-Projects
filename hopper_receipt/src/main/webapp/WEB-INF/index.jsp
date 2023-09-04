<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- New line below to use the JSP Standard Tag Library (JSTL Import) -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" href="/css/style.css"> <!-- New line to use the CSS file from: hopper_receipt/src/main/webapp/css/style.css -->
    <script type="text/javascript" src="/js/script.js"></script> <!-- New line to use the JavaScript file from: hopper_receipt/src/main/webapp/js/script.js -->

    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- For any Bootstrap that uses JS -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

        <meta charset="UTF-8">
        <title>Receipt</title>
    </head>
<body>
    <h1>Customer Name: <c:out value="${name}"></c:out> </h1>
    <h3>Item Name: <c:out value="${itemName}"></c:out> </h3>
    <h3>Item Price: <c:out value="${price}"></c:out> </h3>
    <h3>Item Description: <c:out value="${description}"></c:out> </h3>
    <h3>Item's Vendor: <c:out value="${vendor}"></c:out> </h3>
</body>