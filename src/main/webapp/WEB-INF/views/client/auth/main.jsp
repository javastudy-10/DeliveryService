<%--
User: Maxim Sambulat
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/auth.css" />" rel="stylesheet">
</head>
<body>
<spring:url var="authUrl" value="/client/login"/>
<div class="wrapper">

    <form:form class="form-login" method="post" action="${authUrl}">
        <h2 class="text-center form-login-heading">
            <spring:message code="client.auth.header"/>
        </h2>

        <input name="username" type="text" class="form-control"
               placeholder = "<spring:message code="client.auth.username.placeholder" />"
               required="true" autofocus="true"/>

        <input type="password" class="form-control" name="password"
               placeholder="<spring:message code="client.auth.password.placeholder"/>" required="true"/>

        <c:if test="${param.get('error') == 'true'}">
            <h2 class="text-center form-login-heading">
                <spring:message code="client.auth.error"/>
            </h2>
        </c:if>

        <label class="checkbox">
            <input type="checkbox" id="remember_me" name="remember-me">
            <spring:message code="client.auth.remember_me"/>
        </label>

        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <spring:message code="client.auth.submit"/>
        </button>
    </form:form>
</div>
</body>
</html>
