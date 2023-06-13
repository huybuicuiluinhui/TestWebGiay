<%@ page language="java" contentType="text/html; charset=UTF8"
         pageEncoding="UTF8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.google.gson.Gson" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Document</title>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" href="../../../resources/css/productView.css">

    <style>
        .card{
            width: 30%;
            justify-content: space-between;
        }
    </style>
</head>
<body>
<c:import url="../../layout/headerAdmin.jsp"/>
<div class="row mb-3">
   <div class="col">
       <form action="/thong-ke" method="post" >
    <span class="title-search">Tìm kiếm theo ngay:
    </span> <br/>
           <input name="startDate" value="${param.startDate}" class="col-6 col-sm-3" type="date"/>
           </span>
           <br/>
           <input name="endDate" value="${param.endDate}" class="col-6 col-sm-3" type="date"/>
           <button type="submit" name="action" value="search" class="btn btn-primary" style="margin-left: 20px">Xem bảng</button>
           <button type="submit" name="action" value="view-chart" class="btn btn-primary" style="margin-left: 20px">Xem biểu đồ</button>
       </form>
   </div>
    <div class="col">
        <form action="/thong-ke-thang" method="post" >
    <span class="title-search">Tìm kiếm theo tháng:
    </span> <br/>
            <input name="startMonth" value="${param.startMonth}" class="col-6 col-sm-3"  type="number" min="1" max="12"/>
            </span>
            <br/>
            <input name="endMonth" value="${param.endMonth}" class="col-6 col-sm-3"  type="number" min="1" max="12"/>
            <button type="submit" name="action" value="search" class="btn btn-primary" style="margin-left: 20px">Xem bảng</button>
            <button type="submit" name="action" value="view-chart" class="btn btn-primary" style="margin-left: 20px">Xem biểu đồ</button>
        </form>
    </div>

</div>
<c:if test="${type eq 'table'}">
    <table class="table table-striped">
        <thead>
        <tr>
            <c:if test="${methodSource eq 'method2'}">
                <th scope="col">Tên sản phẩm</th>
                <th scope="col">Số lượng đã bán</th>
                <th scope="col"> Tháng</th>
            </c:if>


            <c:if test="${methodSource eq 'method1'}">
                <th scope="col">Tên sản phẩm</th>
                <th scope="col">Số lượng đã bán</th>
            </c:if>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${topSellingProducts}" var="sanPham">
            <tr>
                <td> ${sanPham[0]} </td>
                <td> ${sanPham[1]} </td>

                <c:if test="${methodSource eq 'method2'}">
                    <td> ${sanPham[2]} </td>
                </c:if>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</c:if>
<c:if test="${type eq 'chart'}">
    <div id="container" style="height: 500px"></div>
</c:if>
<script src="/js/jquery.js"></script>
<script src="/js/highcharts.js"></script>
<script>
    $(document).ready(function() {
        var productNames = JSON.stringify(<%= new Gson().toJson(request.getAttribute("productNames")) %>);
        var monthNames = JSON.stringify(<%= new Gson().toJson(request.getAttribute("monthNames")) %>);
        var quantities = JSON.stringify(<%= new Gson().toJson(request.getAttribute("quantities")) %>);
        var productNamesArray = JSON.parse(productNames);
        var monthNamesArray = JSON.parse(monthNames);
        var quantitiesArray = JSON.parse(quantities);
        drawLineChart(productNamesArray, monthNamesArray,quantitiesArray);
        function drawLineChart(productNamesArray,monthNamesArray, quantitiesArray) {
            Highcharts.chart('container', {
                chart: {
                    type: 'line',
                    width: 1000
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