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
    <title><spring:message code="profile.phone.header"/></title>

    <jsp:include page="edit-head.jsp">
        <jsp:param name="flag" value="phone"/>
    </jsp:include>

    <c:url value="/client/profile/change/phone" var="url"/>
</head>

<body class="body-margin">

<jsp:include page="../../utils/message-box.jsp"/>

<div class="panel panel-info">
    <div class="panel-heading"><spring:message code="profile.phone.header"/></div>
    <div class="panel-body">
        <%--Change Phone--%>
        <form:form action="${url}" modelAttribute="phone" method="post"
                   role="form" class="form-horizontal">
            <div class="form-group">
                    <%--Current Phone--%>
                <div class="form-group">
                    <form:label path="currentPhone" class="col-sm-2 control-label">
                        <spring:message code="profile.phone.current"/>
                    </form:label>

                    <div class="col-sm-10 col-sm-2">
                        <form:input path="currentPhone" class="form-control" readonly="true" />
                    </div>
                </div>

                    <%--New Phone--%>
                <div class="form-group">
                    <form:label path="newPhone" id="labelNewPhone" class="col-sm-2 control-label">
                        <spring:message code="profile.phone.new"/>
                    </form:label>

                    <div class="col-sm-10 col-sm-2">
                        <form:input path="newPhone" class="form-control" minlength="4" maxlength="20" onkeyup="checkPhone()"/>
                        <form:errors path="newPhone" delimiter=" " cssStyle="color: red"/>
                            <%--onkeyup="checkPhone()"--%>
                    </div>

                    <span id="imageValidPhone" class="glyph-margin glyphicon"><jsp:text/></span>
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
                        <form:button type="submit" class="btn">
                            <spring:message code="profile.phone.change"/>
                        </form:button>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</body>
</html>
