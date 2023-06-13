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
    <h1>Detail Product</h1>
    <form action="/asm/product/admin/updateProduct/${product.idProduct}" method="post" class="row g-3" enctype="multipart/form-data">
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
                <input type="text" class="form-control" placeholder="price"  name="price"  value="${product.price}" >
            </div>
            <div class="col">
                <label class="form-label">Size</label>
                <div class="col">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" name="size"  value="34" ${product.size.contains("34") ? "checked":""}>
                        <label class="form-check-label" >34</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox"  name="size" value="35"  ${product.size.contains("35") ? "checked":""}>
                        <label class="form-check-label" >35</label>
                    </div>

                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox"  name="size" value="36"  ${product.size.contains("36") ? "checked":""}>
                        <label class="form-check-label" >36</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox"  name="size" value="37"  ${product.size.contains("37") ? "checked":""}>
                        <label class="form-check-label" >37</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox"  name="size" value="38"  ${product.size.contains("38") ? "checked":""}>
                        <label class="form-check-label" >38</label>
                    </div></div>
                <div class="col">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox"  name="size" value="39"  ${product.size.contains("39") ? "checked":""}>
                        <label class="form-check-label" >39</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox"  name="size" value="40"  ${product.size.contains("40") ? "checked":""}>
                        <label class="form-check-label" >40</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox"  name="size" value="41"  ${product.size.contains("41") ? "checked":""}>
                        <label class="form-check-label" >41</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox"  name="size" value="42"  ${product.size.contains("42") ? "checked":""}>
                        <label class="form-check-label" >42</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox"  name="size" value="43"  ${product.size.contains("43") ? "checked":""}>
                        <label class="form-check-label" >43</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox"  name="size" value="44"  ${product.size.contains("44") ? "checked":""}>
                        <label class="form-check-label" >44</label>
                    </div>
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
                <select class="form-select"  name="category">
                    <c:forEach items="${list}" var="ch">
                        <option value="${ch.id}"  ${product.category.nameCate == ch.nameCate ? "selected" : ""} >${ch.nameCate}</option>
                    </c:forEach>

                </select>
            </div>
            <div class="col">
                <label class="form-label">Status</label>
                <div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="status"  value="True" ${product.status ==true ?  "checked":""}>
                        <label class="form-check-label" >Còn</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="status" value="False"  ${product.status == false? "checked":""} >
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
            />
            <img alt="" src="/resources/imgProduct/${product.img}" width="200px" height="150px" >

        </div>
        <div class="form-group">
            <button  type="submit" class="btn btn-primary"  onclick="if(!confirm('Bạn có chắc chắn muốn cập nhật?')){return false;}else{return true;}">Sửa </button>
        </div>
    </form>

</div>
</body>
</html>