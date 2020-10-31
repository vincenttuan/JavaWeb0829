<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            
        </h1>
    </body>
</html>
