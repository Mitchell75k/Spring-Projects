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
        <title> Bookclub Books Table Page</title>
    </head>
    <body>
        <div class="container" style="display: flex; flex-direction: column; justify-content: center; justify-self: center; padding: 2%;">
            <div style="display: flex; flex-direction: row; margin-bottom: 20px;">
                <div>
                    <h1 class="text-success">Welcome <c:out value="${user.userName}"></c:out>!</h1>
                    <h5 class="text-success" >Books from everyone's shelves: </h5>
                    
                </div>
                <div style="display: flex; flex-direction: column; margin-top: 15px; margin-left: 600px;">
                    <a style="margin-bottom: 10px;" href="/addBook">Add to my shelf! +</a>
                    <a href="/logout">Log Out?</a>
                </div>
            </div>
            <div class="table"  style="display: flex; flex-direction: column; padding: 25px; width: auto; height: 550px; background-color: rgb(91, 152, 238) ;">
                <table class="table table-hover ">
                    <thead class="bg-success text-white">
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Title</th>
                            <th scope="col">Author Name</th>
                            <th scope="col">Posted By</th>
                        </tr>
                    </thead>
                    <tbody style="background-color: antiquewhite;">
                        <div style="background-color: antiquewhite;">
                            <c:forEach items="${allBooks}" var="book">
                                <tr>
                                    <td>${book.id}</td>
                                    <!--title of book should be a link that goes to the book details page-->
                                    <td><a href="/book/${book.id}">${book.title}</a></td>
                                    <td>${book.author}</td>
                                    <td>${book.user.userName}</td>
                                </tr>
                            </c:forEach>
                        </div>
                    </tbody>
                </table>
            </div>