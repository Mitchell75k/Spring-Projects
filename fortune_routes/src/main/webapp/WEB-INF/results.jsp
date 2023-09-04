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
        <title> Omikuji Results</title>
    </head>
    <body>
        <div class="container  mx-auto" style="display: flex; flex-direction: column; justify-content: center; align-items: center;">
            <h1 class="text-center text-primary" style="margin: 15px;">Here's Your Omikuji!</h1>
            <div style="background-color: rgb(123, 191, 255); display: flex; width: 400px; padding: 20px;
            border: 3px; border-color: rgb(1, 15, 139); border-radius: 3%; border-style: solid; margin: 20px;" >
                <p>
                    In 10 years, you will move to  <c:out value = "${city}"></c:out>, and live on the floor below  <c:out value = "${name}"></c:out>, however they will always have an 
                    intense jump rope session at 9pm every other day. You will also have a room mate who does <c:out value = "${profession}"></c:out> for a living. 
                    After a year of living there, you will have discover that there's  <c:out value = "${number}"></c:out> secret  <c:out value = "${thing}"></c:out>s living in the trees surrounding 
                    your apartments. One day, one of those <c:out value = "${thing}"></c:out>s will say "<c:out value = "${comment}"></c:out>" to your mom.
                </p>
                
            </div>
            <a href="/daikichi/omikuji/form">Back to Omikuji</a>
        </div>
        </body>