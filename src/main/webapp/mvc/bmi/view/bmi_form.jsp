<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css" integrity="sha384-cg6SkqEOCV1NbJoCu11+bm0NvBRc8IYLRGXkmNrqUBfTjmMYwNKPWBTIKyw9mHNJ" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BMI Page</title>
    </head>
    <body style="padding: 20px">
        <form class="pure-form">
            <fieldset>
                <legend>BMI form</legend>
                序號: <input type="number" placeholder="請輸入序號" /><p />
                身高: <input type="number" placeholder="請輸入身高" /><p />
                體重: <input type="number" placeholder="請輸入體重" /><p />
                性別: <input type="radio" value="1">&nbsp;男&nbsp;&nbsp;<input type="radio" value="2">&nbsp;女<p />
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
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td> </td>
                    <td> </td>
                    <td> </td>
                    <td> </td>
                    <td> </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
