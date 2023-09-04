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
        <title> Safe Travels Home Page</title>
    </head>
    
    <body>
        <div class="container" style="display: flex; flex-direction: column; justify-content: center; justify-self: center; padding: 2%;">
            <h1 style="margin-bottom: 20px;" class="text-success">Saves Travels Info</h1>
            <div style="background-color: rgb(91, 152, 238); width:auto; padding: 20px 15px 5px 15px;">
                <table class="table table-striped table-primary table-hover" style="border: 3px; border-color:rgb(15, 68, 160); border-style: solid;">
                    <thead colspan="5">
                        <tr>
                            <th>Expense</th>
                            <th>Vendor</th>
                            <th>Amount</th>
                            <th>Actions</th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="expense" items="${travels}">
                            <tr>
                                <td><a href="/travels/${expense.id}"><c:out value="${expense.name}"></c:out></a></td>
                                <td><c:out value="${expense.vendor}"></c:out></td>
                                <td><c:out value="${expense.amount}"></c:out></td>
                                <td><a class="btn btn-primary" href="/travels/${expense.id}/edit">Edit</a></td>
                                <!--
                                    Using a form with the "POST" method for delete actions provides better security,
                                    adheres to RESTful design principles, 
                                    and ensures compatibility with different client environments. 
                                -->
                                <td>
                                    <form action="/travels/${expense.id}/delete" method="POST">
                                        <input type="hidden" name="_method" value="DELETE">
                                        <button type="submit" class="btn btn-danger">Delete</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <h3 style="margin-top: 70px;" class="text-success">Add an Expense!</h3>
            <div style="display: flex; padding: 25px; width: 500px; background-color: rgb(91, 152, 238) ;">
                <form:form method="post" action="/travels/create" modelAttribute="travel">
                    <div class="form-group">
                        <form:label path="name" class="form-label" > Expense Name: </form:label>
                        <form:errors path="name" class="form-error" />
                        <form:input path="name"  class="form-input" type="text" />
                    </div>
                    <div style="margin-top: 15px;" class="form-group">
                        <form:label path="vendor" class="form-label" > Vendor: </form:label>
                        <form:errors path="vendor" class="form-error" />
                        <form:input path="vendor"  class="form-input" type="text" />
                    </div>
                    <div style="margin-top: 15px;" class="form-group">
                        <form:label path="amount" class="form-label" > Amount: </form:label>
                        <form:errors path="amount" class="form-error" />
                        <form:input path="amount"  class="form-input" type="text" />
                    </div>
                    <div style="margin-top: 15px;" class="form-group">
                        <form:label path="description" class="form-label" > Description: </form:label>
                        <form:errors path="description" class="form-error" />
                        <form:input path="description"  class="form-input" type="textarea" style="height: 100px; width: 200px" />
                    </div>
                    <button type="submit" style="margin-top: 20px;" class="btn btn-success">Submit Expense</button>
                </form:form>
            </div>
        </div>
    </body>
</html>

