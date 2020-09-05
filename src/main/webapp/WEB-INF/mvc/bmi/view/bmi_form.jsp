<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css" integrity="sha384-cg6SkqEOCV1NbJoCu11+bm0NvBRc8IYLRGXkmNrqUBfTjmMYwNKPWBTIKyw9mHNJ" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BMI Page</title>
    </head>
    <body style="padding: 20px">
        <form class="pure-form" method="post" action="/JavaWeb0829/mvc/bmi">
            <fieldset>
                <legend>BMI form</legend>
                序號: <input type="number" placeholder="請輸入序號" id="_id" name="_id" /><p />
                身高: <input type="number" placeholder="請輸入身高" id="height" name="height" /><p />
                體重: <input type="number" placeholder="請輸入體重" id="weight" name="weight" /><p />
                性別: <input type="radio" value="1" id="sex" name="sex">&nbsp;男&nbsp;&nbsp;
                <input type="radio" value="2" id="sex" name="sex">&nbsp;女<p />
                <button type="submit" class="pure-button pure-button-primary">儲存並計算</button>
                <button type="reset" class="pure-button pure-button-primary">重置</button>
            </fieldset>
        </form>

        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>序號</th>
                    <th>身高</th>
                    <th>體重</th>
                    <th>性別</th>
                    <th>BMI</th>
                    <th>判斷</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="bmi" items="${bmis}">
                <tr>
                    <td>${bmi.id}</td>
                    <td>${bmi.height}</td>
                    <td>${bmi.weight}</td>
                    <td>${bmi.sex==1?"男":"女"}</td>
                    <td><fmt:formatNumber maxFractionDigits="2" value="${bmi.bmi}" /></td>
                    <td>${bmi.result}</td>
                </tr>
                </c:forEach>
                <tr>
                    <td>平均</td>
                    <td><fmt:formatNumber maxFractionDigits="1" value="${avgHeight}" /></td>
                    <td><fmt:formatNumber maxFractionDigits="1" value="${avgWeight}" /></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
        </tbody>
    </table>
</body>
</html>
