<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<html>
    <jsp:useBean id="random" class="java.util.Random" scope="page" />
    <c:set var="hour" value="${random.nextInt(10)}" />
    <t:pichart mobile="${hour}" />
</html>
