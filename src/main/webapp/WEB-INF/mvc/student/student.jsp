<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student CRUD Page</title>
        <script>
            function getStudent(id) {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4) {
                        var jo = JSON.parse(this.responseText); // 將文字資料轉成 json 物件
                        switch (this.status) {
                            case 200:
                                document.getElementById("id").value = jo.id;
                                document.getElementById("name").value = jo.name;
                                document.getElementById("score").value = jo.score;
                                break;
                            case 400:
                                alert(jo.text);
                                break;
                        }
                    }
                }
                var uri = '/JavaWeb0829/rest/student/' + id;
                xhttp.open('GET', uri, true);
                xhttp.send();
            }
            
            function deleteStudent(id) {
                if(!confirm('確定要刪除 id = ' + id + ' 的資料嗎 ?')) {
                    return;
                }
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4) {
                        var jo = JSON.parse(this.responseText); // 將文字資料轉成 json 物件
                        switch (this.status) {
                            case 200:
                                readStudent();
                            case 400:
                                alert(jo.text);
                                break;
                        }
                    }
                }
                var uri = '/JavaWeb0829/rest/student/' + id;
                xhttp.open('DELETE', uri, true);
                xhttp.send();
            }
            
            function updateStudent() {
                // 抓取表單資料
                var id = document.getElementById("id").value;
                var name = document.getElementById("name").value;
                var score = document.getElementById("score").value;
                // 建立物件
                var st = new Object();
                st.id = id * 1;
                st.name = name;
                st.score = score * 1;
                // 將物件 st 轉 json 字串
                var jsonstring = JSON.stringify(st);

                // 傳送到指定的地方: /JavaWeb0829/rest/student/
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4) {
                        var jo = JSON.parse(this.responseText); // 將文字資料轉成 json 物件
                        switch (this.status) {
                            case 200:
                                readStudent();
                            case 400:
                                alert(jo.text);
                                break;
                        }
                    }
                }
                var uri = '/JavaWeb0829/rest/student/' + id;
                xhttp.open('PUT', uri, true);
                xhttp.setRequestHeader("Content-type", "application/json;charset=utf-8");
                xhttp.send(jsonstring);

            }
            function addStudent() {
                // 抓取表單資料
                var name = document.getElementById("name").value;
                var score = document.getElementById("score").value;
                // 建立物件
                var st = new Object();
                st.id = 0;
                st.name = name;
                st.score = score * 1;
                // 將物件 st 轉 json 字串
                var jsonstring = JSON.stringify(st);

                // 傳送到指定的地方: /JavaWeb0829/rest/student/
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4) {
                        var jo = JSON.parse(this.responseText); // 將文字資料轉成 json 物件
                        switch (this.status) {
                            case 200:
                                readStudent();
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
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4) {
                        var jo = JSON.parse(this.responseText); // 將文字資料轉成 json 物件
                        switch (this.status) {
                            case 200:
                                showTable(jo);
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

            function showTable(jo) {
                // 清空
                var lens = document.getElementById("student_table").rows.length;
                for (var i = 0; i < lens; i++) {
                    document.getElementById("student_table").deleteRow(0);
                }
                var table = document.getElementById("student_table");
                for (var i = 0; i < jo.length; i++) {
                    var row = table.insertRow(0);
                    var cell1 = row.insertCell(0);
                    var cell2 = row.insertCell(1);
                    var cell3 = row.insertCell(2);
                    var cell4 = row.insertCell(3);
                    cell1.innerHTML = '<a href="javascript:getStudent(' + jo[i].id + ')">' + jo[i].id + '</a>';
                    cell2.innerHTML = jo[i].name;
                    cell3.innerHTML = jo[i].score;
                    cell4.innerHTML = '<input type="button" value="刪除" onclick="deleteStudent(' + jo[i].id + ')">';
                }
            }
        </script>
    </head>
    <body style="padding: 20px" onload="readStudent()">

        <form id="student_form" class="pure-form">
            <fieldset>
                <legend>Student CRUD</legend>
                ID : <input type="text" id="id" name="id" readonly /><p/>
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
