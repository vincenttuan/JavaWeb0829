<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css" integrity="sha384-cg6SkqEOCV1NbJoCu11+bm0NvBRc8IYLRGXkmNrqUBfTjmMYwNKPWBTIKyw9mHNJ" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Page</title>
    </head>
    <body style="padding: 20px">
        <form class="pure-form pure-form-stacked" method="post" action="/JavaWeb0829/servlet/employee/add">
            <fieldset>
                <legend>Employee Form</legend>
                員工 : <select id="empName" name="empName">
                    <option value="John">John 喬治</option>
                    <option value="Mary">Mary 瑪莉</option>
                    <option value="Mark">Mark 馬克</option>
                </select>
                <p/>
                薪資 : <input type="number" id="empSalary" name="empSalary" placeholder="請輸入薪資" />
                <p/>
                性別 : <input type="radio" id="empSex" name="empSex" value="1" />&nbsp;男
                <input type="radio" id="empSex" name="empSex" value="2" />&nbsp;女 
                <p/>
                主管 : <input type="checkbox" id="empType" name="empType" value="true" /> 是
                <p/>
                <button type="submit" class="pure-button pure-button-primary">Add</button>
            </fieldset>
        </form>
        <%
            List<Map<String, String>> emps = null;
            if(request.getAttribute("emps") != null) {
                emps = (List<Map<String, String>>)request.getAttribute("emps");
            }
        %>

        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>員工</th>
                    <th>薪資</th>
                    <th>性別</th>
                    <th>主管</th>
                </tr>
            </thead>
            <%if (emps != null) {%>
            <%int total = 0;%>
            <tbody>
                <%for(Map<String, String> emp : emps) {%>
                <tr>
                    <td><% out.print(emp.get("empName")); %></td>
                    <td><%=String.format("%,d", Integer.parseInt(emp.get("empSalary"))) %></td>
                    <td><%=emp.get("empSex").equals("1")?"男":"女" %></td>
                    <td><%=emp.get("empType")==null?"":"V" %></td>
                </tr>
                <%total = total + Integer.parseInt(emp.get("empSalary")); %>
                <%}%>
                <tr>
                    <td></td>
                    <td><%=String.format("%,d", total) %></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
            <%}%>
        </table>

    </body>
</html>
