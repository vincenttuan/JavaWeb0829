<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://my.scwcd" prefix="s"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            Username : <input type="text"> <s:required /><p />
            <s:greet /><p />
            <s:greet user="Vincent" /><p />
            <s:greet user="${param.name}" /><p />
            <s:if condition="${param.score >= 60}">
                Pass
            </s:if>
            <jsp:useBean id="random" class="java.util.Random" scope="page" />
            <c:set var="score" value="${random.nextInt(100)}" />
            <c:out value="${score}" />
            <s:if condition="${score >= 60}">
                Pass
            </s:if>
        </h1>
    </body>
</html>
