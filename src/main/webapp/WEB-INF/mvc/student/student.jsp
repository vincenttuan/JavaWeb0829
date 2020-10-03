<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student CRUD Page</title>
    </head>
    <body style="padding: 20px">

        <form id="student_form" class="pure-form">
            <fieldset>
                <legend>Student CRUD</legend>
                ID : <input type="text" id="id" name="id" placeholder="請輸入ID" /><p/>
                Name : <input type="text" id="name" name="name" placeholder="請輸入名字" /><p/>
                Score : <input type="number" id="score" name="score" placeholder="請輸入分數" /><p/>
                <button type="button" id="add_button"    onclick="addStudent()"    class="pure-button pure-button-primary">新增</button>
                <button type="button" id="update_button" onclick="updateStudent()" class="pure-button pure-button-primary">修改</button>
                <button type="button" id="query_button"  onclick="readStudent()" class="pure-button pure-button-primary">查詢</button>
                <button type="reset" class="pure-button pure-button-primary">清除</button>
            </fieldset>
        </form>

        <div id="result"></div>

        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>序號</th>
                    <th>名字</th>
                    <th>分數</th>
                    <th>刪除</th>
                </tr>
            </thead>
            <tbody id="student_table" >
                
            </tbody>
        </table>
    </body>
</html>
