<%@ page language="java" contentType="text/html; charset=UTF8"
         pageEncoding="UTF8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link
            href="https://fonts.googleapis.com/css?family=Roboto"
            rel="stylesheet"
    />
    <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/icon?family=Material+Icons"
    />
    <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <style>
        .center-product{
            text-align: center;
            margin: auto 0}
    </style>
</head>
<body>
<div class="screen">
    <%@include file="../../layout/headerAdmin.jsp" %>

    <div class="">
        <div  style="width: 100%;">
            <h2 style="text-align: center">Danh sách hóa đơn</h2>
        </div>
        <div class="table-responsive" style="overflow-x: hidden">
                <table class="table table-striped table-hover table-bordered">
                    <thead>
                    <tr>
                        <th class="center-product">ID Hóa Đơn</th>
                        <th class="center-product">Tên khách hàng</th>
                        <th class="center-product">Ngày đặt hàng</th>
                        <th class="center-product">Địa chỉ nhận</th>
                        <th class="center-product">View </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td class="center-product">${order.id}</td>
                            <td class="center-product">${order.account.username}</td>
                            <td class="center-product">${order.oderDate}</td>
                            <td class="center-product">${order.address}</td>
                            <td class="center-product"><a href="/view-order-detail/${order.id}">Detail</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
        </div>
    </div>
</div>

</body>
</html>
