<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fastfood Order</title>
    </head>
    <body style="padding: 20px">
        <h1>OOO 您好 ! 請點餐</h1>
        <form class="pure-form">
            <fieldset>
                <legend>點餐單</legend>
                主餐: 
                <select name="mainfoods">
                    <c:forEach var="entry" items="${mainFoods}">
                        <option value="${entry.key}">${entry.value}</option>
                    </c:forEach>
                </select><p />
                副餐: <select name="secondfoods"></select><p />
                飲料: <select name="drinks"></select><p />
                <button type="submit" class="pure-button pure-button-primary">加入</button>
                <button type="button" class="pure-button pure-button-primary">結帳</button>
            </fieldset>
        </form>
        <form class="pure-form">
            <fieldset>
                <legend>購物車</legend>
                <table class="pure-table pure-table-bordered">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>品名</th>
                            <th>價格</th>
                            <th>刪除</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th> </th>
                            <th> </th>
                            <th> </th>
                            <th> </th>
                        </tr>
                    </tbody>
                    <thead>
                        <tr>
                            <th colspan="3" align="right">小計: </th>
                            <th> </th>
                        </tr>
                    </thead>
                </table>
            </fieldset>
        </form>
    </body>
</html>
