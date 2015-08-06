<%--
  User: Maxim Sambulat
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"><jsp:text/></script>
<link href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"><jsp:text/></script>
<script src="<c:url value="/resources/js/profile/edit-main.js"/>" type="text/javascript"><jsp:text/></script>
<link href="<c:url value="/resources/css/profile.css" />" rel="stylesheet">

<%--Message for error MessageBox--%>
<script type="text/javascript" language="JavaScript">
    var msg_password_error = "<spring:message code="profile.password.error"/>";
    var msg_password_fix = "<spring:message code="profile.password.fix"/>";
</script>

<c:if test="${param.get('flag') == 'address'}">
    <script type="text/javascript" src="<c:url value="/resources/js/profile/edit-address.js" />" >
        <jsp:text/>
    </script>

    <%--Message for error MessageBox--%>
    <script type="text/javascript" language="JavaScript">
        var msg_address_error = "<spring:message code="profile.address.error"/>";
        var msg_address_fix = "<spring:message code="profile.address.fix"/>";
    </script>
</c:if>

<c:if test="${param.get('flag') == 'email'}">
    <script type="text/javascript" src="<c:url value="/resources/js/profile/edit-email.js" />" >
        <jsp:text/>
    </script>

    <%--Message for error MessageBox--%>
    <script type="text/javascript" language="JavaScript">
        var msg_email_error = "<spring:message code="profile.email.error"/>";
        var msg_email_fix = "<spring:message code="profile.email.fix"/>";
    </script>
</c:if>

<c:if test="${param.get('flag') == 'phone'}">
    <script type="text/javascript" src="<c:url value="/resources/js/profile/edit-phone.js" />" >
        <jsp:text/>
    </script>

    <%--Message for error MessageBox--%>
    <script type="text/javascript" language="JavaScript">
        var msg_phone_error = "<spring:message code="profile.phone.error"/>";
        var msg_phone_fix = "<spring:message code="profile.phone.fix"/>";
    </script>
</c:if>

<c:if test="${param.get('flag') == 'password'}">
    <script type="text/javascript" src="<c:url value="/resources/js/profile/edit-password.js" />" >
        <jsp:text/>
    </script>

    <%--Message for error MessageBox--%>
    <script type="text/javascript" language="JavaScript">
        var msg_new_password_error = "<spring:message code="profile.password.new.error"/>";
        var msg_new_password_fix = "<spring:message code="profile.password.new.fix"/>";

        var msg_confirm_password_error = "<spring:message code="profile.password.confirm.error"/>";
        var msg_confirm_password_fix = "<spring:message code="profile.password.confirm.fix"/>";

        var msg_match_password_error = "<spring:message code="profile.password.match.error"/>";
        var msg_match_password_fix = "<spring:message code="profile.password.match.fix"/>";
    </script>
</c:if>

