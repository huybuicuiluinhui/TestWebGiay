<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.google.gson.Gson" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-xxxxx" crossorigin="anonymous" />
</head>
<body>
<h1>Bi?u ?? th?ng ke</h1>
<div id="container" style="height: 400px"></div>
<script src="/js/jquery.js"></script>
<script src="/js/highcharts.js"></script>
<script>
    $(document).ready(function() {
        console.log("123345567");
        var productNames = JSON.stringify(<%= new Gson().toJson(request.getAttribute("productNames")) %>);
        var monthNames = JSON.stringify(<%= new Gson().toJson(request.getAttribute("monthNames")) %>);
        var quantities = JSON.stringify(<%= new Gson().toJson(request.getAttribute("quantities")) %>);
        var productNamesArray = JSON.parse(productNames);
        var monthNamesArray = JSON.parse(monthNames);
        var quantitiesArray = JSON.parse(quantities);
        console.log("productNamesArray"+productNamesArray)
        console.log("monthNamesArray"+monthNamesArray)
        console.log("quantitiesArray"+quantitiesArray)
        drawLineChart(productNamesArray, monthNamesArray,quantitiesArray);
        function drawLineChart(productNamesArray,monthNamesArray, quantitiesArray) {
            Highcharts.chart('container', {
                chart: {
                    type: 'line',
                    width: 500
                },
                title: {
                    text: 'Bieu do thong ke giay ban chay nhat'
                },
                xAxis: {

                    categories: productNamesArray
                },
                tooltip: {
                    formatter: function() {
                        return '<strong>' + this.x + ': </strong>' + this.y;
                    }
                },
                series: [{
                    name:'So Luong',
                    data: quantitiesArray
                }]
            });
        }
    });
</script>
</body>
</html>
