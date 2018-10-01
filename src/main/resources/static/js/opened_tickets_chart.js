// Load google charts
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
function drawChart() {
  var data = google.visualization.arrayToDataTable([
  ['Task', 'Chamados abertos'],
  ['CRM', 8],
  ['BILLING', 2],
  ['OSS', 4]
]);

  // Optional; add a title and set the width and height of the chart
  var options = {'title':'Chamados abertos por torre', 'width':550, 'height':400};

  // Display the chart inside the <div> element with id="piechart"
  var chart = new google.visualization.PieChart(document.getElementById('opened_tickets_chart'));
  chart.draw(data, options);
}