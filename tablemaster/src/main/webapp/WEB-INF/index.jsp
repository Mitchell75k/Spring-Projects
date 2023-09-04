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
        <title> New User Registration Form</title>
    </head>
    <body>
        <div class="container" style="display: flex; flex-direction: column; justify-content: center; justify-self: center; padding: 2%;">
            <h1 style="margin-top: 20px;margin-bottom: 20px; justify-self: center; align-self: center;" class="text-warning">TableMaster</h1>
            <div style="display: flex;flex-direction: row; align-items: center;">
                <div style="display: flex; flex-direction: column; padding: 25px; width: 500px; height: 550px; background-color: rgb(91, 152, 238) ;">
                    <h1 style="margin-bottom: 20px;">New Waitstaff</h1>
                    <form:form method="post" action="/register"  modelAttribute="newUser">
                        <div class="form-group">
                            <form:label path="userName" class="form-label" style="margin-right: 10px;"> <strong> User Name: </strong> </form:label> 
                            <form:errors path="userName" class="form-error" style="display: flex; flex-direction: column; color: crimson; font-size: small;"  />
                            <form:input path="userName" class="form-input" type="text" style="margin-bottom: 20px;" />
                        </div>
                        <div class="form-group">
                            <form:label path="email" class="form-label" style="margin-right: 52px;"> <strong> Email: </strong> </form:label>
                            <form:errors path="email" class="form-error" style="display: flex; flex-direction: column; color: crimson; font-size: small;" />
                            <form:input path="email" class="form-input" type="text" style="margin-bottom: 20px;" />
                        </div>
                        <div class="form-group">
                            <form:label path="password" class="form-label" style="margin-right: 17px;"> <strong> Password: </strong> </form:label>
                            <form:errors path="password" class="form-error" style="display: flex; flex-direction: column; color: crimson; font-size: small;" />
                            <form:input path="password" class="form-input" type="password" style="margin-bottom: 20px;" />
                        </div>
                        <div class="form-group">
                            <form:label path="confirm" class="form-label" style="margin-right: 10px;"> <strong> Confirm Password: </strong> </form:label>
                            <form:errors path="confirm" class="form-error" style="display: flex; flex-direction: column; color: crimson; font-size: small;" />
                            <form:input path="confirm" class="form-input" type="password" style="margin-bottom: 20px;" />
                        </div>
                        <button type="submit" style="margin-top: 35px;" class="btn btn-success">Register</button>
                    </form:form>
                </div>
                <div style="display: flex; flex-direction: column; padding: 25px; width: 500px; height: 550px ; background-color: rgb(143, 203, 128) ; margin-left: 50px;">
                    <h1 style="margin-bottom: 20px;">Log in</h1>
                    <form:form method="post" action="/login" modelAttribute= "newLogin">
                        <div class="form-group">
                            <form:label path="email" class="form-label" style="margin-right: 42px;"> <strong> Email: </strong> </form:label>
                            <form:errors path="email" class="form-error" style="display: flex; flex-direction: column; color: crimson; font-size: small;" />
                            <form:input path="email" class="form-input" type="text" style="margin-bottom: 20px;" />
                        </div>
                        <div class="form-group">
                            <form:label path="password" class="form-label" style="margin-right: 10px;"> <strong> Password: </strong> </form:label>
                            <form:errors path="password" class="form-error" style="display: flex; flex-direction: column; color: crimson; font-size: small;" />
                            <form:input path="password" class="form-input" type="password" style="margin-bottom: 20px;" />
                        </div>
                        <button type="submit" style="margin-top: 35px;" class="btn btn-success">Log in</button>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
