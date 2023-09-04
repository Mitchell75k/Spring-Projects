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
        <title> Burger Tracker and Form</title>
    </head>
    
    <body>
        <div class="container" style="display: flex; flex-direction: column; justify-content: center; justify-self: center; padding: 2%;">
            <h1 style="margin-bottom: 20px;" class="text-success">Burger Tracker</h1>
            <div style="background-color: rgb(91, 152, 238); width:auto; padding: 20px 15px 5px 15px;">
                <table class="table table-striped table-primary table-hover" style="border: 3px; border-color:rgb(15, 68, 160); border-style: solid;">
                    <thead colspan="5">
                        <tr>
                            <th>Burger Name</th>
                            <th>Restaurant Name</th>
                            <th>Rating (out of 10)</th>
                            <th>Actions</th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="burger" items="${burgers}">
                            <tr>
                                <td><c:out value="${burger.name}"></c:out></td>
                                <td><c:out value="${burger.restaurant}"></c:out></td>
                                <td><c:out value="${burger.rating}"></c:out></td>
                                <!--
                                    Using a form with the "POST" method for delete actions provides better security, 
                                    adheres to RESTful design principles, 
                                    and ensures compatibility with different client environments.
                                -->
                                <td>
                                    <form action="/burgers/${burger.id}/delete" method="POST">
                                        <input type="hidden" name="_method" value="DELETE">
                                        <button type="submit" class="btn btn-danger">Delete Burger</button>
                                    </form>
                                </td>
                                <td><a class="btn btn-primary" href="/burgers/${burger.id}/edit">Edit Burger</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>


            <h3 style="margin-top: 70px;" class="text-success">Add a Burger!</h3>
            <div style="display: flex; padding: 20px; background-color: rgb(91, 152, 238); width: 400px;">
                <form:form action="/burgers/create" method="post" modelAttribute="burger">
                    <div class="form-group" >
                        <form:label path="name" class="form-label" >Burger Name:</form:label>
                        <form:errors path="name" class="form-error" />
                        <form:input path="name"  class="form-input" type="text"/> 
                    </div>
                    <div class="form-group">
                        <form:label path="restaurant"  class="form-label">Restaurant Name:</form:label>
                        <form:errors path="restaurant" class="form-error"/>
                        <form:input path="restaurant"   class="form-input" type="text"/>
                    </div>
                    <div class="form-group">
                        <form:label path="rating" class="form-label">Rating:</form:label>
                        <form:errors path="rating" class="form-error"/>
                        <form:input path="rating"  class="form-input" type="number" />
                    </div>
                    <div class="form-group">
                        <form:label path="notes" class="form-label">Description:</form:label>
                        <form:errors path="notes" class="form-error"/>
                        <form:input path="notes"  class="form-input" type="textarea" /> 
                    </div>
                    <input type="submit" value="Add Burger" class="btn btn-primary" style="margin-top: 20px;" />
                </form:form>
            </div>
        </div>
    </body>