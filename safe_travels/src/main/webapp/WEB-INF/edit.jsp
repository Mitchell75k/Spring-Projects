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
            <h3 style="margin-top: 70px;" class="text-success">Edit the "<c:out value="${travel.name}"></c:out>" Expense!</h3>
            <div style="display: flex; padding: 25px; width: 500px; background-color: rgb(91, 152, 238) ;">
                <form:form method="post" action="/travels/${travel.id}/update" modelAttribute="travel">
                    <div class="form-group">
                        <form:label path="name" class="form-label" > Expense Name: </form:label>
                        <form:errors path="name" style="color: rgb(255, 0, 0);" class="form-error" />
                        <form:input path="name"  class="form-input" type="text" />
                    </div>
                    <div style="margin-top: 15px;" class="form-group">
                        <form:label path="vendor" class="form-label" > Vendor: </form:label>
                        <form:errors path="vendor" style="color: rgb(255, 0, 0);" class="form-error" />
                        <form:input path="vendor"  class="form-input" type="text" />
                    </div>
                    <div style="margin-top: 15px;" class="form-group">
                        <form:label path="amount" class="form-label" > Amount: </form:label>
                        <form:errors path="amount" style="color: rgb(255, 0, 0);" class="form-error" />
                        <form:input path="amount"  class="form-input" type="text" />
                    </div>
                    <div style="margin-top: 15px;" class="form-group">
                        <form:label path="description" class="form-label" > Description: </form:label>
                        <form:errors path="description" style="color: rgb(255, 0, 0);" class="form-error" />
                        <form:input path="description"  class="form-input" type="textarea" style="height: 100px; width: 200px" />
                    </div>
                    <button type="submit" style="margin-top: 20px;" class="btn btn-success">Update Expense</button>
                </form:form>
            </div>
        </div>
    </body>
</html>