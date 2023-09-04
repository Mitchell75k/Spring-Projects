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
        <title> Create A Book</title>
    </head>
    <body>
        <!-- New line below to use the Spring Form Tag Library (Spring Import) -->
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!-- New line below to use the JSP Standard Tag Library (JSTL Import) -->
        <%@ page isErrorPage="true" %>   

        <div class="container  mx-auto" style="display: flex; flex-direction: column; justify-content: center; align-items: center;">
            <h1 class="text-center text-success" style="margin: 15px;">Add a New Book</h1>
            <div style="background-color:rgb(73, 160, 61); display: flex; width: 400px; padding: 20px;
            border: 3px; border-color:rgb(52, 82, 48); border-radius: 3%; border-style: solid; margin: 20px;" >

                <!-- modelAttribute="book" allows us to use the Spring Form Tag Library (Spring Import), form:form tag is also being used used-->               <!--!!-->
                <form:form action="/books/create" method="post" style="display: flex; flex-direction: column; align-items: start; columns: 6; padding: 20px;" modelAttribute="book">
                    <div class="form-group">
                        <form:label path="title">Title:</form:label>
                        <form:errors path="title"/>
                        <form:input path="title" style="margin-top:5px;" type="text" /> <!-- an equal symbol is expected at the end of the path attribute -->
                    </div>

                    <div class="form-group">
                        <form:label path="description">Description: </form:label>
                        <form:errors path="description"/>
                        <form:input path="description" style="margin-top: 5px;" type="textarea" rows="10" cols="30" />
                    </div>

                    <div class="form-group">
                        <form:label path="language">Language: </form:label>
                        <form:errors path="language"/>
                        <form:input path="language" style="margin-top: 5px;" type="text" />
                    </div>

                    <div class="form-group">
                        <form:label path="numberOfPages"># of Pages: </form:label>
                        <form:errors path="numberOfPages"/>
                        <form:input style="margin-top: 5px;" type="number" path="numberOfPages" />
                    </div>

                    <input style="align-self: flex-end; margin-top: 15px;" class="btn btn-success" style="width: 100px;" type="submit" value="Create">
                </form:form>
            </div>
        </div>
    </body>
</html>                                           <!--DO NOT USE "required" WITH FORM TAGS: WILL NOT WORK-->
