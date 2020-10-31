<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/tlds/mytld" prefix="t" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <t:hello /><p />
            <t:hello name="Vincent" /><p />
            <t:bmi h="170" w="60" /><p />
        </h1>
    </body>
</html>
