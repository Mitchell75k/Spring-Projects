<%@ page language = "java" contentType = "text/html; charset=UTF-8"
    pageEncoding = "UTF-8" %>
    
<!-- New line below to use the JSP Standard Tag Library (JSTL Import) -->
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <!--for local CSS -->
        <link rel = "stylesheet" href = "/fortune_routes/src/main/resources/static/css/style.css" />
        <!-- for Bootstrap CSS -->
        <link rel = "stylesheet" href = "/webjars/bootstrap/css/bootstrap.min.css" />
        <!-- For any Bootstrap that uses JS -->
        <script src = "/webjars/bootstrap/js/bootstrap.min.js"></script>
        
        <meta charset = "UTF-8">
        <title> Omikuji Form </title>
    </head>

<body>
    <div class="container  mx-auto" style="display: flex; flex-direction: column; justify-content: center; align-items: center;">
        <h1 class = "text-center text-success">Send an Omikuji!</h1>
        <div style="background-color: lightgreen; display: flex; justify-self: center; width: 400px; padding: 20px;
        border: 3px; border-color: darkgreen; border-radius: 3%; border-style: solid; margin: 20px;" >

            <form action="/daikichi/omikuji/process" method="post"   
            style="display: flex; flex-direction: column; align-items: start; columns: 6; padding: 20px;"> 

                <label for="number">Pick any number between 5 and 25:</label>
                <!-- < creating a drop down menu with numbers 5-25 -->
                <select name="number" id="number">
                    <c:forEach begin="5" end="25" var="i">
                        <option value="${i}">${i}</option>
                    </c:forEach>
                </select required>

                <label for="city">Enter the name of any city: </label>
                <input style="margin-top: 5px;" type="text" name="city" id="city" required>

                <label for="name">Enter the name of any real person: </label>
                <input style="margin-top: 5px;" type="text" name="name" id="name" required>

                <label for="profession">Enter any professional endeavor or hobby: </label>
                <input style="margin-top: 5px;" type="text" name="profession" id="profession" required>

                <label for="thing">Enter the name of any living thing: </label>
                <input style="margin-top: 5px;" type="text" name="thing" id="thing" required>

                <label for="comment">Say a nice comment about anyone: </label>
                <input style="margin-top: 5px;" type="textarea" name="comment" id="comment" rows="10" cols="30" required>

                <input style="align-self: flex-end; margin-top: 15px;" class="btn btn-success" style="width: 100px;" type="submit" value="Submit">
            </form> 
        </div>
</div>
</body>
</html>