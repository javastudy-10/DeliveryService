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
    <title><spring:message code="profile.address.header"/></title>

    <jsp:include page="edit-head.jsp">
        <jsp:param name="flag" value="address"/>
    </jsp:include>

    <c:url value="/client/profile/change/address" var="url"/>
</head>

<body class="body-margin">

<jsp:include page="../../utils/message-box.jsp"/>

<div class="panel panel-info">
    <div class="panel-heading"><spring:message code="profile.address.header"/></div>
    <div class="panel-body">
        <%--Change address--%>
        <form:form action="${url}" modelAttribute="address" method="post"
                   role="form" class="form-horizontal">

            <%--Current Address--%>
            <div class="form-group">
                <form:label path="currentAddress" class="col-sm-2 control-label">
                    <spring:message code="profile.address.current"/>
                </form:label>

                <div class="col-sm-10 col-sm-4">
                    <form:input path="currentAddress" class="form-control" readonly="true" />
                </div>
            </div>

            <%--New Address--%>
            <div class="form-group">
                <form:label path="newAddress" class="col-sm-2 control-label">
                    <spring:message code="profile.address.new"/>
                </form:label>

                <div class="col-sm-10 col-sm-4">
                    <form:input path="newAddress" class="form-control"/>
                        <%--minlength="4" maxlength="128"--%>
                    <form:errors path="newAddress" delimiter=" " cssStyle="color: red"/>
                </div>
            </div>

            <%--Password--%>
            <div class="form-group">
                <form:label path="password" class="col-sm-2 control-label">
                    <spring:message code="client.password"/>
                </form:label>

                <div class="col-sm-10 col-sm-2">
                    <form:input type="password" path="password" class="form-control" />
                        <%--minlength="6" maxlength="16"--%>
                    <form:errors path="password" delimiter=" " cssStyle="color: red"/>
                </div>

                <div class="col-sm-10 col-sm-4">
                    <form:button type="submit" class="btn" >
                        <spring:message code="profile.address.change"/>
                    </form:button>
                </div>
            </div>
        </form:form>
    </div>
</body>
</html>
