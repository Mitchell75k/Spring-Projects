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
        <title> Edit User Table Page</title>
    </head>
    <body>
        <div class="container" style="display: flex; flex-direction: column; justify-content: center; justify-self: center; padding: 2%;">
            <div style="display: flex;flex-direction: row; margin-top: 30px;">
                <div>
                    <h1 class="text-success"> Edit a table for: <c:out value="${table.guestName}"></c:out> </h1>
                </div>
                <div style="display: flex; flex-direction: column; margin-left: 400px;">
                    <a href="/home/yourTables">Back to your tables</a>
                    <a href="/logout">Log Out</a>
                    <p class="text-success"> <strong>Logged In as: </strong> <c:out value="${user.userName}"></c:out></p>
                </div>
            </div>
            <div class="form bg-dark"  style="display: flex; flex-direction: column; padding: 80px; width: auto; height: 550px;">
                <form:form method="POST" action="/table/${table.id}/edit"  modelAttribute="table"> 
                    <div class="form-group text-warning"> 
                        <form:label path="guestName" class="form-label" style="margin-right: 55px;"> <strong> Guest Name: </strong> </form:label> 
                        <form:errors path="guestName" class="form-error text-danger" style ="display: flex; flex-direction: column; font-size: small;" /> 
                        <form:input path="guestName" class="form-input" type="text" style="margin-bottom: 20px;" />
                    </div> 
                    <div class="form-group text-warning"> 
                        <form:label path="numOfGuests" class="form-label" style="margin-right: 10px;"> <strong> Number of Guests: </strong> </form:label> 
                        <form:errors path="numOfGuests" class="form-error text-danger" style ="display: flex; flex-direction: column; font-size: small;" /> 
                        <form:input path="numOfGuests" class="form-input" type="text" style="margin-bottom: 20px;" />
                    </div> 
                    <div class="form-group text-warning"> 
                        <form:label path="notes" class="form-label" style="margin-right: 100px;"> <strong> Notes: </strong> </form:label> 
                        <form:errors path="notes" class="form-error text-danger" style ="display: flex; flex-direction: column; font-size: small;" /> 
                        <form:input path="notes" class="form-text" type="text" style="margin-bottom: 20px; margin-top: 20px; height: 100px; width: 500px;" />
                    </div> 
                    <div style="display: flex; flex-direction: row; margin-top: 35px" >
                        <button style="margin-right: 20px;" type="submit"  class="btn btn-success">Update Table</button>
                        <a style="margin-right: 20px;" href="/home/yourTables" class="btn btn-warning">Cancel</a>
                        <a href="/table/${table.id}/delete" class="btn btn-danger">Delete Table</a>
                    </div>
                </form:form>
            </div>
        </div>
    </body>
</html>