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
    <title><spring:message code="profile.email.header"/></title>

    <jsp:include page="edit-head.jsp">
        <jsp:param name="flag" value="email"/>
    </jsp:include>

    <c:url value="/client/profile/change/email" var="url"/>
</head>

<body class="body-margin">

<jsp:include page="../../utils/message-box.jsp"/>

<div class="panel panel-info">
    <div class="panel-heading"><spring:message code="profile.email.header"/></div>
    <div class="panel-body">
        <%--Change email--%>
        <form:form action="${url}" modelAttribute="email" method="post"
                   userRole="form" class="form-horizontal">
            <div class="form-group">
                    <%--Current email--%>
                <div class="form-group">
                    <form:label path="currentEmail" class="col-sm-2 control-label">
                        <spring:message code="profile.email.current"/>
                    </form:label>

                    <div class="col-sm-10 col-sm-4">
                        <form:input path="currentEmail" class="form-control" readonly="true"/>
                    </div>
                </div>

                    <%--New email--%>
                <div class="form-group">
                    <form:label path="newEmail" id="labelNewEmail" class="col-sm-2 control-label">
                        <spring:message code="profile.email.new"/>
                    </form:label>

                    <div class="ol-sm-10 col-sm-4">
                        <form:input path="newEmail" class="form-control" minlength="5" maxlength="64" onkeyup="checkEmail()"/>
                        <form:errors path="newEmail" delimiter=" " cssStyle="color: red"/>
                            <%--onkeyup="checkEmail()"--%>
                    </div>

                    <span id="imageValidEmail" class="glyph-margin glyphicon"> <jsp:text/> </span>
                </div>

                    <%--Password--%>
                <div class="form-group">
                    <form:label path="password" class="col-sm-2 control-label">
                        <spring:message code="client.password"/>
                    </form:label>

                    <div class="col-sm-10 col-sm-2">
                        <form:input type="password" path="password" class="form-control" minlength="6" maxlength="16"/>
                        <form:errors path="password" delimiter=" " cssStyle="color: red"/>
                    </div>

                    <div class="col-sm-10 col-sm-4">
                        <form:button type="submit" class="btn" >
                            <spring:message code="profile.email.change"/>
                        </form:button>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</body>
</html>
