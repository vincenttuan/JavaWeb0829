<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://my.scwcd" prefix="s"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        Username : <input type="text"> <s:required /><p />
        <s:greet /><p />
        <s:greet user="Vincent" /><p />
        <s:greet user="${param.name}" /><p />
        <s:if condition="${param.score >= 60}">
            Pass
        </s:if>
        <p />
        <jsp:useBean id="random" class="java.util.Random" scope="page" />
        <c:set var="score" value="${random.nextInt(100)}" />
        <c:out value="${score}" />
        <s:if condition="${score >= 60}">
            Pass
        </s:if>
        <p />
        4 Stars : 
        <s:loop count="4">
            <c:set var="num" value="${random.nextInt(10)}" />
            <c:out value="${num}" />
        </s:loop>
        <p />
        <s:mark search="s">
            she sell sea shell on the sea shore
        </s:mark>
        <p />
        <c:set var="money" value="90" scope="session" />
        <c:set var="money" value="9" scope="request" />
        <s:implicit attributeName="money" scopeName="session" /><p />
        <s:implicit attributeName="money" scopeName="request" /><p />
        <p />
        <c:set var="id" value="A123456789" />
        <s:switch conditionValue="${fn:substring(id, 1, 2)}">  <!-- ${fn:substring(id, 1, 2)}, ${id.charAt(1)} -->
            <s:case caseValue="1">
                Man
            </s:case>
            <s:case caseValue="2">
                Female
            </s:case>
            <s:default>
                Error
            </s:default>    
        </s:switch>
    </body>
</html>
