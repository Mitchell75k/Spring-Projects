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
        <title> New Ninja Form Page</title>
    </head>
    <body>
        <div class="container" style="display: flex; flex-direction: column; justify-content: center; justify-self: center; padding: 2%;">
            <h3 style="margin-top: 70px;" class="text-success">Add a Ninja!</h3>
            <div style="display: flex; padding: 25px; width: 500px; background-color: rgb(91, 152, 238) ;">
                <form:form method="post" action="/ninjas/create"  modelAttribute="ninja">
                    <div class="form-group">
                        <form:label path="dojo" class="form-label" style="margin-right: 48px;"> <strong> Dojo: </strong> </form:label>
                        <form:select path="dojo">
                            <c:forEach var="dojo" items="${dojos}">
                                <form:option value="${dojo.id}" path="dojo">
                                    <c:out value="${dojo.name}"/>
                                </form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <div class="form-group">
                        <form:label  path="firstName" class="form-label" > <strong> First Name: </strong> </form:label>
                        <form:errors path="firstName" class="form-error" />
                        <form:input path="firstName" class="form-input" type="text" style="margin-bottom: 20px;"/>
                    </div>
                    <div class="form-group">
                        <form:label  path="lastName" class="form-label" > <strong> Last Name: </strong> </form:label>
                        <form:errors path="lastName" class="form-error" />
                        <form:input path="lastName" class="form-input" type="text" style="margin-bottom: 20px;"/>
                    </div>
                    <div class="form-group">
                        <form:label  path="age" class="form-label" style="margin-right: 50px;"> <strong> Age: </strong> </form:label>
                        <form:errors path="age" class="form-error" />
                        <form:input path="age" class="form-input" type="text"/>
                    </div>
                    <button type="submit" style="margin-top: 35px;" class="btn btn-success">Create Ninja</button>
                </form:form>
            </div>
            <a style="margin-top: 20px;" href="/dojos/new"> Add a Dojo></a>
        </div>
    </body>
</html>
