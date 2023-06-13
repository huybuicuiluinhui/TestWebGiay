<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<div class="container mt-3" >
<%--    <%@include file="../../layout/headerAdmin.jsp" %>--%>
    <h1 style="text-align: center">Thêm Vào Danh Sách Giầy </h1>
    <form action="/asm/product/admin/addProduct" method="post" class="row g-3" enctype="multipart/form-data">
        <div class="row mt-3">
            <div class="col">
                <label class="form-label">Name Shoe</label>
                <input type="text" class="form-control" placeholder="Name"  name="nameProduct" required value="${product.nameProduct}">
            </div>
            <div class="col">
                <label class="form-label">Brand</label>
                <input type="text" class="form-control" placeholder="brand"  value="${product.brand}" name="brand" required>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col">
                <label class="form-label">Price</label>
                <input type="text" class="form-control" placeholder="price"  name="price"  value="${product.price}" required>
            </div>
            <div class="col">
                <label class="form-label">Size</label>
            <div class="col">
                <select class="form-select" aria-label="Default select example" name="size">
                    <option value="34" >34</option>
                    <option value="35" >35</option>
                    <option value="36" >36</option>
                    <option value="37" >37</option>
                    <option value="38" >38</option>
                    <option value="39" >39</option>
                    <option value="40" >40</option>
                    <option value="41" >41</option>
                    <option value="42" >42<option>
                    <option value="43" >43</option>
                    <option value="44" >44</option>
                </select>
            </div>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col">
                <label class="form-label">Quantity</label>
                <input type="text" class="form-control" placeholder="quantity"  name="quantity"  value="${product.quantity}" required>
            </div>
            <div class="col">
                <label class="form-label">Material</label>
                <input type="text" class="form-control" placeholder="material"  name="material"  value="${product.material}"required>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col">
                <label class="form-label">Categories</label>
                <select class="form-select" id="validationDefault04" name="category">
                    <c:forEach items="${listCategories}" var="ch">
                        <option value="${ch.id}" >${ch.nameCate}</option>
                    </c:forEach>

                </select>
            </div>
            <div class="col">
                <label class="form-label">Status</label>
                <div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="status"  value="true" checked>
                        <label class="form-check-label" >Còn</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="status"  value="false">
                        <label class="form-check-label" >Hết</label>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-6">
            <label class="form-label">Image</label>
            <input
                    value="${product.img}"
                    name="img"
                type="file"
                    class="form-control"
                    required
            />
        </div>
        <div class="form-group">
            <button  type="submit" class="btn btn-primary" onclick="if(!confirm('Bạn có chắc chắn muốn thêm ?')){return false;}else{return true;}">Thêm</button>
        </div>
    </form>

</div>
</body>
</html>