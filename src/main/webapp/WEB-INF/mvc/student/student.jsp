<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student CRUD Page</title>
        <script>
            function addStudent() {
                // 抓取表單資料
                var id = document.getElementById("id").value;
                var name = document.getElementById("name").value;
                var score = document.getElementById("score").value;
                // 建立物件
                var st = new Object();
                st.id = id;
                st.name = name;
                st.score = score;
                // 將物件 st 轉 json 字串
                var jsonstring = JSON.stringify(st);
                
                // 傳送到指定的地方: /JavaWeb0829/rest/student/
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function() {
                    if(this.readyState == 4) {
                        var jo = JSON.parse(this.responseText); // 將文字資料轉成 json 物件
                        switch(this.status) {
                            case 200:
                                alert(jo);
                                break;
                            case 400:
                                alert(jo.text);
                                break;    
                        }
                    }
                }
                xhttp.open('POST', '/JavaWeb0829/rest/student/', true);
                xhttp.setRequestHeader("Content-type", "application/json;charset=utf-8");
                xhttp.send(jsonstring);
                
            }
            
            function readStudent() {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function() {
                    if(this.readyState == 4) {
                        var jo = JSON.parse(this.responseText); // 將文字資料轉成 json 物件
                        switch(this.status) {
                            case 200:
                                alert(jo);
                                break;
                            case 400:
                                alert(jo.text);
                                break;    
                        }
                    }
                }
                xhttp.open('GET', '/JavaWeb0829/rest/student/', true);
                xhttp.send();
            }
        </script>
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
