<%@ page language = "java" contentType = "text/html; charset=UTF-8"
    pageEncoding = "UTF-8" %>
    
<!-- New line below to use the JSP Standard Tag Library (JSTL Import) -->
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- New line below to use the Spring Form Tag Library (Spring Import) -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- New line below to use the JSP Standard Tag Library (JSTL Import), ALLOWS US TO RENDER ON A PUT REQUEST (UPDATE) -->
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
        <title> Burger Edit Form</title>
    </head>
    <body>
        <div class="container" style="display: flex; flex-direction: column; justify-content: center; align-items: center; justify-self: center; padding: 2%;">
            <h1 style="margin-bottom: 50px;" class="text-success">Edit The "<c:out value="${burger.name}"></c:out>"</h1>
            <div style="background-color: rgb(91, 152, 238); width:auto; padding: 30px 20px 30px 20px;">
                <form:form action="/burgers/${burger.id}/update" method="POST" modelAttribute="burger">
                    <div class="form-group">
                        <!--The Bind Attribute will prepopulate the form with the data from the database for you, so no need to do  this manually-->
                        <div class="form-group" >
                            <form:label path="name" class="form-label" > <strong>Burger Name:</strong> </form:label>
                            <form:errors path="name" class="form-error" />
                            <form:input path="name"  class="form-input" type="text" /> 
                        </div>
                        <div class="form-group" style="margin-top: 10px;">
                            <form:label path="restaurant"  class="form-label"> <strong>Restaurant Name:</strong> </form:label>
                            <form:errors path="restaurant" class="form-error"/>
                            <form:input path="restaurant"   class="form-input" type="text"/>
                        </div>
                        <div class="form-group" style="margin-top: 10px;">
                            <form:label path="rating" class="form-label"> <strong>Rating:</strong> </form:label>
                            <form:errors path="rating" class="form-error"/>
                            <form:input path="rating"  class="form-input" type="number" />
                        </div>
                        <div class="form-group" style="margin-top: 10px;">
                            <form:label path="notes" class="form-label"> <strong>Description:</strong> </form:label>
                            <form:errors path="notes" class="form-error"/>
                            <form:input path="notes"  class="form-input" type="textarea" /> 
                        </div>
                        <input type="submit" value="Update Burger" class="btn btn-success" style="margin-top: 20px;" />
                        
                        <!--DELETE button, the proper way to do this-->
                        <!--Refer to burger_tracker/src/main/java/com/mitchell/esparza/burger_tracker/BurgerTrackerApplication.java to see how we implement the delete method into html-->
                        <!-- <form  action="/burgers/${burger.id}/delete" method="POST">
                            <input type="hidden" name="_method" value="DELETE">
                            <button style="margin-top: 20px;" type="submit" class="btn btn-danger">Delete Burger</button>
                        </form> Doesn't require form:form annotation since its not actually binding any data, but you could still use it -->
                    </div>
                </form:form>
            </div>
            <a href="/" style="margin-top: 50px;">Back to Burgers</a>
    </body>
</html>