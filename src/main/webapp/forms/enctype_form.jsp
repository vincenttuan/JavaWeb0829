<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>探討各種表單的編碼</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css" integrity="sha384-cg6SkqEOCV1NbJoCu11+bm0NvBRc8IYLRGXkmNrqUBfTjmMYwNKPWBTIKyw9mHNJ" crossorigin="anonymous">
    </head>
    <body style="padding: 20px">
        <table  class="pure-table pure-table-bordered">
            <thead>
                <tr><td>探討各種表單的編碼</td><td>結果</td></tr>
            </thead>
            <tbody>
                <tr>
                    <td valign="top">
                        <form method="post" class="pure-form" action="/JavaWeb0829/servlet/enctype" enctype="application/x-www-form-urlencoded" target="myiframe">
                            <fieldset>
                                <legend>預設編碼 : application/x-www-form-urlencoded</legend>
                                <input type="text" placeholder="請輸入姓名" name="name" value="王小明" /><p />
                                <input type="number" placeholder="請輸入年齡" name="age" value="18" /><p />
                                <button type="submit" class="pure-button pure-button-primary">傳送</button>
                            </fieldset>
                        </form>
                        <p />
                        <form method="post" class="pure-form" action="/JavaWeb0829/servlet/enctype" enctype="multipart/form-data" target="myiframe">
                            <fieldset>
                                <legend>指定編碼 : multipart/form-data</legend>
                                <input type="text" placeholder="請輸入姓名" name="name" value="王小明" /><p />
                                <input type="number" placeholder="請輸入年齡" name="age" value="18" /><p />
                                <button type="submit" class="pure-button pure-button-primary">傳送</button>
                            </fieldset>
                        </form>
                        <p />
                        <form method="post" class="pure-form" action="/JavaWeb0829/servlet/enctype" enctype="text/plain" target="myiframe">
                            <fieldset>
                                <legend>指定編碼 : text/plain</legend>
                                <input type="text" placeholder="請輸入姓名" name="name" value="王小明" /><p />
                                <input type="number" placeholder="請輸入年齡" name="age" value="18" /><p />
                                <button type="submit" class="pure-button pure-button-primary">傳送</button>
                            </fieldset>
                        </form>
                    </td>
                    <td valign="top">
                        <iframe id="myiframe" name="myiframe" width="500" height="1000"></iframe>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
