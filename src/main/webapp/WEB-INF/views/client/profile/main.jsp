<!DOCTYPE HTML>
<%--
  User: Maxim Sambulat
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<head>
    <title><spring:message code="profile.header"/></title>

    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"><jsp:text/></script>
    <link href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"><jsp:text/></script>

    <link href="<c:url value="/resources/css/profile.css" />" rel="stylesheet">

    <c:url value="/client/profile/edit/address" var="url_edit_address"/>
    <c:url value="/client/profile/edit/email" var="url_edit_email"/>
    <c:url value="/client/profile/edit/phone" var="url_edit_phone"/>
    <c:url value="/client/profile/edit/password" var="url_edit_password"/>
</head>

<body class="body-margin">

<div class="panel panel-info">
    <div class="panel-heading"><spring:message code="profile.header.auth"/></div>
    <div class="panel-body">
        <%--Login--%>
        <form role="form" class="form-horizontal">
            <div class="form-group">
                <label for="login" class="col-sm-2 control-label">
                    <spring:message code="client.login"/>
                </label>

                <div class="col-sm-10 col-sm-4">
                    <input id="login" type="text" class="form-control" readonly="true" value="${profinfo.login}"/>
                </div>
            </div>
        </form>

        <%--Password--%>
        <form action="${url_edit_password}" method="post" role="form" class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">
                    <spring:message code="profile.password.current"/>
                </label>

                <div class="col-sm-10 col-sm-2">
                    <div class="input-group">
                        <input id="login" type="password" class="form-control" readonly="true" value="00000000"/>
                        <span class="input-group-btn">
                        <button type="submit" class="btn">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </button>
                    </span>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="panel panel-info">
    <div class="panel-heading"><spring:message code="profile.header.userinfo"/></div>
    <div class="panel-body">
        <%--Address--%>
        <form action="${url_edit_address}" method="post" role="form" class="form-horizontal">
            <div class="form-group">
                <label for="address" class="col-sm-2 control-label">
                    <spring:message code="client.address"/>
                </label>

                <div class="col-sm-10 col-sm-4">
                    <div class="input-group">
                        <input type="text" id="address" class="form-control" readonly="true" value="${profinfo.address}"/>
                        <span class="input-group-btn">
                            <button type="submit" class="btn">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </button>
                        </span>
                    </div>
                </div>
            </div>
        </form>

        <%--Email--%>
        <form action="${url_edit_email}"  method="post" role="form" class="form-horizontal">
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">
                    <spring:message code="client.email"/>
                </label>

                <div class="col-sm-10 col-sm-4">
                    <div class="input-group">
                        <input id="email" type="text" class="form-control" readonly="true" value="${profinfo.email}"/>
                        <span class="input-group-btn">
                            <button type="submit" class="btn">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </button>
                        </span>
                    </div>
                </div>
            </div>
        </form>

        <%--Phone--%>
        <form action="${url_edit_phone}" method="post" role="form" class="form-horizontal">
            <div class="form-group">
                <label for="phone" class="col-sm-2 control-label">
                    <spring:message code="client.phone"/>
                </label>

                <div class="col-sm-10 col-sm-3">
                    <div class="input-group">
                        <input id="phone" type="text" class="form-control" readonly="true" value="${profinfo.phone}"/>
                        <span class="input-group-btn">
                            <button type="submit" class="btn">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </button>
                        </span>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>


</body>
</html>
