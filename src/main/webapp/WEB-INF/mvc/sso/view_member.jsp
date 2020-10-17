<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Member</title>
    </head>
    <body>
        <h1>Hello ${sessionScope.username}</h1>
        ${members}
    </body>
</html>
