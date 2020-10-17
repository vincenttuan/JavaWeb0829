<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Member</title>
    </head>
    <body style="padding: 20px">
        <h1>Hello ${sessionScope.username}</h1>
        ${members}
        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="map" items="${members}">
                    <tr>
                        <c:forEach var="m" items="${map}">
                            <td>${m.value}</td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <button class="pure-button pure-button-primary" type="button" onclick="window.location.href='${pageContext.request.contextPath}/forms/captcha/sso_login_form.jsp'">回登入</button>
    </body>
</html>
