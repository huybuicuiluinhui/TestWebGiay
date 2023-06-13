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

    <style>
        .card{
            width: 30%;
            justify-content: space-between;
        }
    </style>
</head>
<body>
<div class="container">
    <%@include file="../layout/header.jsp" %>
    <div class=" section-products">
        <div class="row justify-content-center text-center">
            <div class="col-md-8 col-lg-6">
                <div class="header">
                    <h3>Featured Product</h3>
                    <h2>Product List</h2>
                </div>
            </div>
        </div>
        <div style="margin-bottom: 20px">
            <form action="/asm/product/user/searchName" method="post" >
                <span class="title-search">Tìm kiếm sản phẩm theo tên:</span> <br/><input name="nameProduct" value="${param.nameProduct}" class="col-6 col-sm-3" placeholder="Tìm kiếm theo tên sản phẩm"/>
                <input type="submit" value="Tìm kiếm" class="btn btn-primary"/>
            </form>
        </div>
        <div class="row justify-content-between">
            <c:forEach items="${page.getContent()}" var="pr">
                <div class="card p-3 bg-white  mb-3">
                    <div class="about-product text-center mt-2">
                        <img src="/resources/imgProduct/${pr.img}" width="300" name="img"/>
                        <div>
                            <h6 class="mt-0 text-black">${pr.nameProduct}</h6>
                            <h8 class="mt-0 text-black-50"></h8>
                            <br/>
                            <h8 class="mt-0 text-black-50">${pr.category.nameCate}</h8>
                        </div>
                    </div>
                    <div class="stats mt-2">
                        <div class="d-flex justify-content-between ">
                            <span>Chat lieu</span><span>${pr.material}</span>
                        </div>
                        <div class="d-flex justify-content-between ">
                            <span>Thuong hieu</span><span>${pr.brand}</span>
                        </div>
                        <div class="d-flex justify-content-between p-price">
                            <span>Size</span><span>${pr.size}</span>
                        </div>
                        <div class="d-flex justify-content-between p-price">
                            <span>So luong ton</span><span>${pr.quantity}</span>
                        </div>
                        <div class="d-flex justify-content-between p-price">
                            <span>Trang thai</span><span>${!!pr.status?"Con":"Het"}</span>
                        </div>

                    </div>
                    <div class="d-flex justify-content-between total font-weight-bold mt-4">
                        <span>Price</span><span>${pr.price} $</span>
                        <a href="/shopping-cart/add/${pr.idProduct}">Add to cart</a>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:if test="${page.getNumber() + 1 > 1}">

                <li class="page-item">
                    <a href="?page=${page.getNumber()}"
                       class="page-link">Previous</a>
                </li>
            </c:if>
            <c:forEach begin="1" end="${page.getTotalPages()}" varStatus="status">
                <li class="page-item">
                    <a href="${pageContext.request.contextPath}/asm/product/user?page=${status.index}"
                       class="page-link">${status.index}</a>
                </li>
            </c:forEach>
            <c:if test="${page.getNumber() + 1 lt page.getTotalPages()}">
                <li class="page-item">
                    <a href="?page=${page.getNumber() + 2}"
                       class="page-link">Next</a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>
</body>
</html>
