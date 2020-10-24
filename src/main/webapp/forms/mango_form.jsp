<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mango</title>
        <script>
            function addCustomer() {
                // 抓取表單資料
                var name = document.getElementById("name").value;
                var sex = document.getElementById("sex").value;
                var amount = document.getElementById("amount").value;
                
                // 建立物件
                var ct = new Object();
                ct.id = 0;
                ct.name = name;
                ct.sex = sex;
                ct.amount = amount;
                // 將物件 st 轉 json 字串
                var jsonstring = JSON.stringify(ct);
                // 傳送到指定的地方: /JavaWeb0829/rest/mango/customer
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4) {
                        alert('新增成功:' + this.responseText);
                        readCustomer();
                    }
                }
                xhttp.open('POST', '/JavaWeb0829/rest/mango/customer', true);
                xhttp.setRequestHeader("Content-type", "application/json;charset=utf-8");
                xhttp.send(jsonstring);

            }
            
            function readCustomer() {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4) {
                        var jo = JSON.parse(this.responseText); // 將文字資料轉成 json 物件
                        showTable(jo);
                    }
                }
                xhttp.open('GET', '/JavaWeb0829/rest/mango/customers', true);
                xhttp.send();
            }
            function showTable(jo) {
                // 清空
                var lens = document.getElementById("customer_table").rows.length;
                for (var i = 0; i < lens; i++) {
                    document.getElementById("customer_table").deleteRow(0);
                }
                var table = document.getElementById("customer_table");
                for (var i = 0; i < jo.length; i++) {
                    var row = table.insertRow(0);
                    var cell1 = row.insertCell(0);
                    var cell2 = row.insertCell(1);
                    var cell3 = row.insertCell(2);
                    var cell4 = row.insertCell(3);
                    var cell5 = row.insertCell(4);
                    cell1.innerHTML = jo[i].id;
                    cell2.innerHTML = jo[i].name;
                    cell3.innerHTML = jo[i].sex;
                    cell4.innerHTML = jo[i].amount;
                    cell5.innerHTML = jo[i].ts;
                }
            }
        </script>
    </head>
    <body style="padding: 20px" onload="readCustomer()">
        <form class="pure-form">
            <table>
                <tr>
                    <td valign="top"><img border=0 width="300" src="/JavaWeb0829/images/mango.jpg" /></td>
                    <td valign="top">
                        <fieldset>
                            <legend>Mango</legend>
                            <input type="text" placeholder="姓名" name="name" id="name" /><p />
                            <input type="text" placeholder="性別" name="sex" id="sex"  /><p />
                            <input type="number" placeholder="數量" name="amount" id="amount" /><p />
                            <button type="button" class="pure-button pure-button-primary" onclick="addCustomer()">Buy</button>
                        </fieldset>
                    </td>
                </tr>
            </table>
        </form>
        
        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>SEX</th>
                    <th>AMOUNT</th>
                    <th>TS</th>
                </tr>
            </thead>
            <tbody id="customer_table">
                
            </tbody>
        </table>                
    </body>
</html>