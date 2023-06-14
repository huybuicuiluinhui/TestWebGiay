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
</head>

<style>
    .center-product{
    text-align: center;
        margin: auto 0}
    .screen{
        width: 100%;
        height: 100%;
        padding-right: 20px;
        padding-left: 20px;
        overflow-x: hidden
    }
    .menu{
        display: flex;
        justify-content: space-between;
    }
    .page-buttom{
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .title-search{
        font-size: 16px;
        font-weight: bold;

    }
</style>
<body>
<div class="screen">
    <%@include file="../../layout/headerAdmin.jsp" %>
    <nav class="navbar  ">
        <a class="navbar-brand" style="float: left">Admin</a>
        <a href="/asm/product/admin/viewAdd" class="btn btn-primary
" type="button">Thêm sản
            phẩm</a>


    </nav>

    <div class="">
        <div  style="width: 100%;">
            <h2 style="text-align: center">Quản lý danh sách giày</h2>
        </div>
        <div class="col" >
            <form action="/asm/product/admin/searchName" method="post" >
                <span class="title-search">Tìm kiếm sản phẩm theo tên:</span> <br/><input name="nameProduct" value="${param.nameProduct}" class="col-6 col-sm-3" placeholder="Tìm kiếm theo tên sản phẩm"/>
                <input type="submit" value="Tìm kiếm" class="btn btn-primary"/>
            </form>
            <form  action="/asm/product/admin/searchPrice" method="post"  style="margin-top: 20px; margin-bottom: 20px">
                <span class="title-search">Tìm kiếm sản phẩm theo khoảng giá:</span> <br/>
              Min  <input name="min" value="${param.min}" placeholder="Min price"/>
                Max  <input name="max" value="${param.max}" placeholder="Max price"/>
                <input type="submit" value="Tìm kiếm" class="btn btn-primary" />
            </form>
            <form  action="/asm/product/admin/searchNameAndBrandAndSize" method="post"  style="margin-top: 20px;margin-bottom: 20px">
                <span class="title-search">Tìm kiếm sản phẩm đa thuộc tính: </span> <br/>
                Name  <input name="nameProduct" value="${param.nameProduct}" placeholder="Name"/>
                Brand  <input name="brand" value="${param.brand}" placeholder="Brand"/>
                Size  <input name="size" value="${param.size}" placeholder="Size"/>
                <input type="submit" value="Tìm kiếm" class="btn btn-primary" />
            </form>
        </div>
        <div class="table-responsive" style="overflow-x: hidden">
            <c:if test="${page.isEmpty()}">
                <h2>Not found any record!!</h2>
            </c:if>
            <c:if test="${not page.isEmpty()}">
                <p>Found ${pageTotal} records</p>
                <table class="table table-striped table-hover table-bordered">
                    <thead>
                    <tr>
                        <th class="center-product">Shoe  ID</th>
                        <th class="center-product">Shoe Name</th>
                        <th class="center-product">Image</th>
                        <th class="center-product">Material</th>
                        <th class="center-product">Brand</th>
                        <th class="center-product">Price</th>
                        <th class="center-product">Size</th>
                        <th class="center-product">Quantity</th>
                        <th class="center-product">Category</th>
                        <th class="center-product">CreateDate</th>
                        <th class="center-product">Status</th>
                        <th class="center-product">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="pr">
                        <tr>
                            <td class="center-product">${pr.idProduct}</td>
                            <td class="center-product">${pr.nameProduct}</td>
                            <td class="center-product"><img alt="" src="/resources/imgProduct/${pr.img}" width="200px" height="150px"></td>
                            <td style="text-align: center;margin: auto 0">${pr.material}</td>
                            <td class="center-product">${pr.brand}</td>
                            <td class="center-product">${pr.price} $</td>
                            <td class="center-product">${pr.size}</td>
                            <td class="center-product">${pr.quantity} đôi </td>
                            <td class="center-product">${pr.category.nameCate}</td>
                            <td class="center-product">${pr.createDate}</td>
                            <td class="center-product">${pr.status== true ? "Còn":"Hết"}</td>
                            <td class="center-product">
                                <a  class="view" title="View"  data-bs-toggle="modal" data-bs-target="#exampleModal"
<%--                                    href="/asm/product/admin/viewUpdate/${pr.idProduct}"--%>
                                ><i class="material-icons">&#xE417;</i></a
                                >
                                <a href="/asm/product/admin/viewUpdate/${pr.idProduct}" class="edit" title="Edit"
                                   data-toggle="tooltip"
                                ><i class="material-icons">&#xE254;</i></a
                                >
                                <a
                                        onclick="if(!confirm('Bạn có chắc chắn muốn xóa chứ?')){return false;}else{return true;}"
                                        href="/asm/product/admin/delete/${pr.idProduct}"
                                        class="delete"
                                        title="Delete"
                                        data-toggle="tooltip"
                                ><i class="material-icons">&#xE872;</i></a
                                >
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </c:if>
            <nav aria-label="Page navigation example" class="page-buttom">
                <ul class="pagination">
                    <c:if test="${pageNumber + 1 > 1}">

                        <li class="page-item">
                            <a href="?page=${pageNumber}"
                               class="page-link">Previous</a>
                        </li>
                    </c:if>
                    <c:forEach begin="1" end="${pageTotal}" varStatus="status">
                        <li class="page-item">
                            <a href="${pageContext.request.contextPath}/asm/product/admin?page=${status.index}"
                               class="page-link">${status.index}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${pageNumber + 1 lt pageTotal}">
                        <li class="page-item">
                            <a href="?page=${pageNumber + 2}"
                               class="page-link">Next</a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </div>
    </div>
</div>
<!-- Button trigger modal -->
<%--<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">--%>
<%--    Launch demo modal--%>
<%--</button>--%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
