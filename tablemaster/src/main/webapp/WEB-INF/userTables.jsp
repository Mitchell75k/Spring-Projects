<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!--formatting dates-->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
        <title> All User's Tables Page</title>
    </head>
    <body>
        <div class="container bg-dark" style="display: flex; flex-direction: column; justify-content: center; justify-self: center; padding: 2%; margin-top: 20px; height: fit-content;">
            <div style="display: flex;flex-direction: row; margin-top: 30px; margin-bottom: 15px;">
                <h1 class="text-warning">Welcome back, <c:out value="${user.userName}"></c:out></h1>
                <a class="btn btn-danger" style="margin-top: 10px; margin-left: 450px;" href="/logout">Log Out</a>
            </div>
            <h5 class="text-warning">Your Tables: </h5>
            <div class="table"  style="display: flex; flex-direction: column; width: auto; height: auto; background-color: rgb(255, 255, 255) ;">
                <table class="table table-hover ">
                    <thead class="bg-success text-white">
                        <tr>
                            <th scope="col">Guest Name</th>
                            <th scope="col"># of Guests</th>
                            <th scope="col">Arrived At</th>
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                    <tbody style="background-color: antiquewhite;">
                        <c:forEach items="${userTables}" var="table">
                            <tr>
                                <td><c:out value="${table.guestName}"></c:out></td>
                                <td><c:out value="${table.numOfGuests}"></c:out></td>
                                <td>
                                    <fmt:parseDate var="createdAtDate" value="${table.createdAt}" pattern="yyyy-MM-dd HH:mm:ss.SSS" />
                                    <fmt:formatDate value="${createdAtDate}" pattern="MMMM, dd hh:mm a" />
                                </td>
                                <td>
                                    <a style="margin-right: 15px;" class="btn btn-danger btn-sm" href="/table/${table.id}/delete">Finished</a>
                                    <a class="btn btn-primary btn-sm" href="/table/${table.id}/edit">Edit</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <a style="margin-top: 10px; justify-self: flex-start; align-self: flex-start;" class="btn btn-success btn-sm" href="/addTable">Add New Table</a>
            <a style="margin-top: 20px;" href="/allTables">See all tables</a>
        </div>
    </body>
</html>


