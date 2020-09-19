<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fastfood Order</title>
        <script>
            function logout() {
                if (confirm('是否要登出 ?')) {
                    window.location.href = '/JavaWeb0829/fastfood/logout';
                }
            }
            
            function orderSubmit() {
                if (confirm('是否要結帳 ?')) {
                    window.location.href = '/JavaWeb0829/fastfood/submit';
                }
            }

            function itemDelete(no) {
                if (confirm('是否要刪除 no = ' + no + ' 的資料 ?')) {
                    var xhttp = new XMLHttpRequest();
                    xhttp.onreadystatechange = function () {
                        if (this.readyState == 4 && this.status == 200) {
                            //window.location.href = '/JavaWeb0829/fastfood/order';
                        }
                    };
                    xhttp.open("DELETE", "/JavaWeb0829/fastfood/order", true);
                    xhttp.send("no="+no);
                }
            }
        </script>
    </head>
    <body style="padding: 20px">
        <h1>${sessionScope.username} 您好 ! 請點餐</h1>
        <form class="pure-form" method="post" action="/JavaWeb0829/fastfood/order">
            <fieldset>
                <legend>點餐單</legend>
                主餐: 
                <select name="mainfoods">
                    <option value="">請選擇</option>
                    <c:forEach var="entry" items="${mainFoods}">
                        <option value="${entry.key}">${entry.key} $${entry.value}</option>
                    </c:forEach>
                </select><p />
                副餐: 
                <select name="secondfoods">
                    <option value="">請選擇</option>
                    <c:forEach var="entry" items="${secondFoods}">
                        <option value="${entry.key}">${entry.key} $${entry.value}</option>
                    </c:forEach>
                </select><p />
                飲料: 
                <select name="drinks">
                    <option value="">請選擇</option>
                    <c:forEach var="entry" items="${drinks}">
                        <option value="${entry.key}">${entry.key} $${entry.value}</option>
                    </c:forEach>
                </select><p />
                <button type="submit" class="pure-button pure-button-primary">加入</button>
                <button type="button" class="pure-button pure-button-primary" onclick="orderSubmit()">結帳</button>
                <button type="button" class="pure-button pure-button-primary" onclick="logout()">登出</button>
                <a href="/JavaWeb0829/fastfood/order">重新整理</a>
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
                        <c:set var="subtotal" value="0" />
                        <c:forEach var="food" items="${sessionScope.shoppingCar}">
                            <tr>
                                <th>${food.no}</th>
                                <th><img src="/JavaWeb0829/images/fastfood/${food.name}.png" width="50" valign="middle" align="left">${food.name}</th>
                                <th>${food.price}</th>
                                <th><button type="submit" class="pure-button pure-button-primary" onclick="itemDelete(${food.no})">刪除</button></th>
                            </tr>
                            <c:set var="subtotal" value="${subtotal + food.price}" />
                        </c:forEach>
                    </tbody>
                    <thead>
                        <tr>
                            <th colspan="2" align="right">小計: </th>
                            <th><fmt:formatNumber value="${subtotal}" /></th>
                            <th> </th>
                        </tr>
                    </thead>
                </table>
            </fieldset>
        </form>
    </body>
</html>
