<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SSO Login</title>
        <script src="https://www.google.com/recaptcha/api.js"></script>
        <script>
            function onSubmit(token) {
                document.getElementById("demo-form").submit();
            }
        </script>
    </head>
    <body style="padding: 20px">
        <form class="pure-form" id="demo-form" method="post" action="${pageContext.request.contextPath}/captcha/sso/login">
            <legend>SSO Login 登入</legend>
            <input type="text" placeholder="請輸入 Username" name="username"/><p/>
            <input type="password" placeholder="請輸入 Password" name="password"/><p/>
            <button class="g-recaptcha pure-button pure-button-primary" 
                    data-sitekey="${captcha_client_key}" 
                    data-callback='onSubmit' 
                    data-action='submit'>登入</button>
            <button class="pure-button pure-button-primary" type="button" onclick="window.location.href='${pageContext.request.contextPath}/forms/captcha/sso_login_new.jsp'">建立</button>
            <button class="pure-button pure-button-primary" type="button"  onclick="window.location.href='${pageContext.request.contextPath}/captcha/sso/view/member'">檢視</button>
            <button class="pure-button pure-button-primary" type="button"  onclick="window.location.href='${pageContext.request.contextPath}/captcha/sso/logout'">登出</button>
        </form>
        <font color="red">${result}</font>
    </body>
</html>
