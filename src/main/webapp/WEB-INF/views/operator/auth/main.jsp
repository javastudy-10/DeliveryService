
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.08.2015
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title></title>
</head>
<body>
<spring:url var="authUrl" value="/operator/login"/>
<%--'<c:url value="/j_spring_security_check"></c:url>'--%>
<form:form method="post" class="signin" action="${authUrl}">
  <fieldset>
    <table cellspacing="0">
      <tr>
        <th><label for="username_or_email">Username or Email</label></th>
        <td><input id="username_or_email"
                   name="username"
                   type="text"/> <!-- Поле ввода имени пользователя -->
        </td>
      </tr>
      <tr>
        <th><label for="password">Password</label></th>
        <td><input id="password"
                   name="password"
                   type="password"/> <!-- Поле ввода пароля -->
          <small><a href="/user/resend_password">Forgot?</a></small>
        </td>
      </tr>
      <tr>
        <th></th>
        <td><input id="remember_me"
                   name="_spring_security_remember_me"
                   type="checkbox"/> <!-- Флажок "запомнить меня" -->
          <label for="remember_me"
                 class="inline">Remember me</label></td>
      </tr>
      <tr>
        <th></th>
        <td><input name="commit" type="submit" value="Sign In"/></td>
      </tr>
    </table>
  </fieldset>
</form:form>
</body>
</html>
