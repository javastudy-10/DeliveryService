<%-- 
    Document   : doroshenko
    Created on : Jul 17, 2015, 7:02:31 PM
    Author     : Tanya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${name}!</h1>
        <select>
        <c:forEach items="${list}" var="item">
            <option> ${item} </option>
        </c:forEach>  
        </select>
    </body>
</html>

