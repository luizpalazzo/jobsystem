var qtySolved = parseInt(document.getElementById("qtySolved").value);
var qtyOpened = parseInt(document.getElementById("qtyOpened").value);

// Load google charts
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
function drawChart() {
  var data = google.visualization.arrayToDataTable([
  ['Task', 'Chamados abertos'],
  ['RESOLVIDOS', qtySolved],
  ['PENDENTES', qtyOpened]
]);

  // Optional; add a title and set the width and height of the chart
  var options = {'title':'Chamados pendentes X resolvidos', 'width':600, 'height':500};

  // Display the chart inside the <div> element with id="piechart"
  var chart = new google.visualization.PieChart(document.getElementById('opened_tickets_chart'));
  chart.draw(data, options);
}