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
    <title><spring:message code="profile.password.header"/></title>

    <jsp:include page="profile-edit-head.jsp">
        <jsp:param name="flag" value="password"/>
    </jsp:include>

    <c:url value="/client/profile/change/password" var="url"/>
</head>

<body class="body-margin">

<jsp:include page="../../utils/message-box.jsp"/>

<div class="panel panel-info">
    <div class="panel-heading"><spring:message code="profile.password.header"/></div>
    <div class="panel-body">
        <%--Change Password--%>
        <form:form action="${url}" modelAttribute="password" method="post"
                   role="form" class="form-horizontal">
            <div class="form-group">
                    <%--Current Password--%>
                <div class="form-group">
                    <form:label path="password" class="col-sm-2 control-label">
                        <spring:message code="profile.password.current"/>
                    </form:label>

                    <div class="col-sm-10 col-sm-2">
                        <form:input type="password" path="password" class="form-control" minlength="6" maxlength="16"/>
                        <form:errors path="password" delimiter=" " cssStyle="color: red"/>
                    </div>
                </div>

                    <%--New Password--%>
                <div class="form-group">
                    <form:label path="newPassword" class="col-sm-2 control-label">
                        <spring:message code="profile.password.new"/>
                    </form:label>

                    <div class="col-sm-10 col-sm-2">
                        <form:input type="password" path="newPassword" class="form-control" minlength="6" maxlength="16"
                                    onkeyup="checkConfirmPassword()"/>
                        <form:errors path="newPassword" delimiter=" " cssStyle="color: red"/>
                            <%--onkeyup="checkConfirmPassword()"--%>
                    </div>

                    <span id="imageConfirmPassword" class="glyph-margin glyphicon"><jsp:text/></span>
                </div>

                    <%--Confirm Password--%>
                <div class="form-group">
                    <form:label path="confirmPassword" id="labelConfirmPassword" class="col-sm-2 control-label">
                        <spring:message code="profile.password.confirm"/>
                    </form:label>

                    <div class="col-sm-10 col-sm-2">
                        <form:input type="password" path="confirmPassword" class="form-control" minlength="6" maxlength="16"
                                    onkeyup="checkConfirmPassword()"/>
                        <form:errors path="confirmPassword" delimiter=" " cssStyle="color: red"/>
                            <%--onkeyup="checkConfirmPassword()" --%>
                    </div>

                    <div class="col-sm-10 col-sm-4">
                        <form:button type="submit" class="btn">
                            <spring:message code="profile.password.change"/>
                        </form:button>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</body>
</html>
