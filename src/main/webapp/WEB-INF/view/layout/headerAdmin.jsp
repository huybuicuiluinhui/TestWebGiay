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
    <link rel="stylesheet" href="../../../resources/css/productView.css">

</head>
<body>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-black" style="background: bisque">
        <a class="navbar-brand" href="#">HUYBUI</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item ">
                    <a class="nav-link" href="/asm/product/admin">Quản lý danh sách sản phẩm<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" href="/asm/product/admin/viewAdd">Thêm sản phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/view-tk">Thống kê bán chạy</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/view-tk-ton">Thống kê hàng tồn</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/viewOrder">Danh sách hóa đơn</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <a class="btn btn-outline-dark nav-link active" href="${pageContext.request.contextPath}/logout">Logout</a>
            </form>
        </div>
    </nav>
</body>
</html>