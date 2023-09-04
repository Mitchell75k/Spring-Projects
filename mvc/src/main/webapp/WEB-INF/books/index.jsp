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
        <title> Book Details</title>
    </head>
    <body>
        <div class="container" style="display: flex; flex-direction: column; justify-content: center; justify-self: center; padding: 2%;">
            <h1 style="margin-bottom: 20px;" class="text-success">All Books</h1>
            <div style="background-color: rgb(73, 160, 61); width:auto; padding: 20px 15px 5px 15px;"> 
                <table class="table table-striped table-success table-hover" style="border: 3px; border-color:rgb(52, 82, 48); border-style: solid;">
                    <thead colspan="4" >
                        <tr>
                                <th>ID</th>
                                <th>Title</th>
                                <th>Language</th>
                                <th># Pages</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="book" items="${books}">
                            <tr>
                                <td><c:out value="${book.id}"></c:out></td>
                                <td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a> </td>
                                <td><c:out value="${book.language}"></c:out></td>
                                <td><c:out value="${book.numberOfPages}"></c:out></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <a style="margin-top: 10px;" href="/books/new">Add a Book</a>
        </div>
    </body>