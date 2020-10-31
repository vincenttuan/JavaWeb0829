<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="mobile" required="true" rtexprvalue="true" %>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['工作', 8],
          ['飲食', 2],
          ['手機', ${mobile}],
          ['電視', 2],
          ['睡覺', 7]
        ]);

        var options = {
          title: 'My Daily Activities',
          is3D: true
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
