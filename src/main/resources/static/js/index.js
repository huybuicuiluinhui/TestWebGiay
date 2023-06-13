$.ajax({
	uri:'linechartData',
	success: function (result){
		var chartDataElement = document.getElementById('chartData');
		var productNames = JSON.parse(chartDataElement.getAttribute('data-product-names'));
		var monthNames = JSON.parse(chartDataElement.getAttribute('data-month-names'));
		var quantities = JSON.parse(chartDataElement.getAttribute('data-quantities'));
		drawLineChart(productNames,monthNames,quantities)
	}
})
function  drawLineChart(nameProduct,month,quantity){
	Highcharts.chart('container', {
		chart: {
			type: 'line',
			width: 500
		},

		title: {
			text: 'Width is set to 300px'
		},

		xAxis: {
			categories: nameProduct
		},

		tooltip: {
			formatter: function() {
				return '<strong>'+this.x+': </strong>'+ this.y;
			}
		},

		series: [{
			data: quantity
		}]
	});
}
