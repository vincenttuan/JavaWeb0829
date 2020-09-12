<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css" integrity="sha384-cg6SkqEOCV1NbJoCu11+bm0NvBRc8IYLRGXkmNrqUBfTjmMYwNKPWBTIKyw9mHNJ" crossorigin="anonymous">
    </head>
    <body style="padding: 20px">
        <form method="post" class="pure-form">
            <fieldset>
                <legend>Login Form</legend>
                <input type="text" placeholder="請輸入使用者名稱" name="username" /><p />
                <input type="password" placeholder="請輸入使用者密碼" name="password" /><p />
                <button type="submit" class="pure-button pure-button-primary">確認</button>
            </fieldset>
        </form>

    </body>
</html>
