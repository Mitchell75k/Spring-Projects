<%@ page language = "java" contentType = "text/html; charset=UTF-8"
    pageEncoding = "UTF-8" %>
    
<!-- New line below to use the JSP Standard Tag Library (JSTL Import) -->
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- New line below to use the Spring Form Tag Library (Spring Import) -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- New line below to use the JSP Standard Tag Library (JSTL Import) -->
<%@ page isErrorPage="true" %>   
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
        <title> Safe Travel Info Page</title>
    </head>
    
    <body>
        
        <div class="container" style="display: flex; flex-direction: column; justify-content: center; align-items: center; justify-self: center; padding: 2%;">
            <div style="flex-direction: row; display: flex;">
                <h1 style="margin-bottom: 20px;" class="text-primary">Expense Details</h1>
                <a style="margin-left: 30px;" href="/">Go Back</a>
            </div>
            <div style="background-color: rgb(91, 152, 238); width:auto; padding: 20px 15px 20px 15px; margin-top: 20px; border-radius: 5px;">
                <div style="background-color: rgb(255, 255, 255); border-radius: 5px; margin: 10px; padding: 30px;">
                    <p> <strong>Expense Name: </strong> <c:out value="${travel.name}"></c:out></p>
                    <p style="margin-top: 15px;" > <strong> Expense Description: </strong><c:out value="${travel.description}"></c:out></p>
                    <p style="margin-top: 15px;" > <strong> Expense Vendor:</strong> <c:out value="${travel.vendor}"></c:out></p>
                    <p style="margin-top: 15px;" ><strong>Amount Spent:</strong> <c:out value="${travel.amount}"></c:out></p>
                </div>
            </div>
        </body>
    </html>