<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SSO Login</title>
        <script src="https://www.google.com/recaptcha/api.js"></script>
        <script>
            function onSubmit(token) {
                document.getElementById("demo-form").submit();
            }
        </script>
    </head>
    <body>
        <form id="demo-form" method="post" action="${pageContext.request.contextPath}/captcha/sso/login">
            <button class="g-recaptcha" 
                    data-sitekey="${captcha_client_key}" 
                    data-callback='onSubmit' 
                    data-action='submit'>Submit</button>
        </form>
    </body>
</html>
