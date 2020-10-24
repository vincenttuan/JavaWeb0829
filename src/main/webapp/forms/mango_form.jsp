<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mango</title>
    </head>
    <body style="padding: 20px">
        <form class="pure-form" method="post" action="/WebSecure/mango/buy">
            <table>
                <tr>
                    <td valign="top"><img border=0 width="300" src="/JavaWeb0829/images/mango.jpg" /></td>
                    <td valign="top">
                        <fieldset>
                            <legend>Mango</legend>
                            <input type="text" placeholder="姓名" name="name" /><p />
                            <input type="text" placeholder="性別" name="sex"  /><p />
                            <input type="number" placeholder="數量" name="amount" /><p />
                            <button type="submit" class="pure-button pure-button-primary">Buy</button>
                        </fieldset>
                    </td>
                </tr>
            </table>
        </form>
        
        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>SEX</th>
                    <th>AMOUNT</th>
                    <th>TS</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="map" items="${list}">
                <tr>
                    <c:forEach var="m" items="${map}">
                        <td>${m.value}</td>
                    </c:forEach>    
                </tr>
                </c:forEach>
            </tbody>
        </table>                
    </body>
</html>