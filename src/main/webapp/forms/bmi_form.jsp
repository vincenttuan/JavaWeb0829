<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BMI</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css" integrity="sha384-cg6SkqEOCV1NbJoCu11+bm0NvBRc8IYLRGXkmNrqUBfTjmMYwNKPWBTIKyw9mHNJ" crossorigin="anonymous">
    </head>
    <body style="padding: 20px">
        <form action="/JavaWeb0829/servlet/bmi">
            姓名 : <input type="text" name="name"><p />
            身高 : <input type="text" name="h"><p />
            體重 : <input type="text" name="w"><p />
            <input type="submit" value="計算"><p />
        </form>

        <form method="post" class="pure-form" action="/JavaWeb0829/servlet/bmi">
            <fieldset>
                <legend>BMI Form</legend>
                <input type="text" placeholder="請輸入姓名" name="name" /><p />
                <input type="number" placeholder="請輸入身高" name="h" /><p />
                <input type="number" placeholder="請輸入體重" name="w" /><p />
                <button type="submit" class="pure-button pure-button-primary">計算</button>
            </fieldset>
        </form>

    </body>
</html>
