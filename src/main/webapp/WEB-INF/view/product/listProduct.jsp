<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<div class="container">
    <h1>Danh sach san pham <h1>
        <form action=""  method="post">
            <div class="col-md-3">
                <label class="form-label">Name</label>
                <input
                        value="${product.nameProduct}"
                        name="nameProduct"
                        type="text"
                        class="form-control"
                        required
                />

            </div>

            <div class="col-md-3">
                <label class="form-label">Name</label>
                <input
                        value="${product.brand}"
                        name="brand"
                        type="text"
                        class="form-control"
                        required
                />

            </div>
            <div class="col-md-3">
                <label class="form-label">Name</label>
                <input
                        value="${product.price}"
                        name="nameProduct"
                        type="text"
                        class="form-control"
                        required
                />

            </div>
            <div class="col-md-3">
            <label class="form-label">Name</label>
            <input
                    value="${product.size}"
                    name="nameProduct"
                    type="text"
                    class="form-control"
                    required
            />
                <input
                        value="${product.category}"
                        name="category"
                        type="text"
                        class="form-control"
                        required
                />

        </div>
            <div class="col-md-3">
            <label class="form-label">Name</label>
            <input
                    value="${product.quantity}"
                    name="quantity"
                    type="text"
                    class="form-control"
                    required
            />

        </div>
        </form>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Product ID</th>
                <th scope="col">Image</th>
                <th scope="col">Product Name</th>
                <th scope="col">Material</th>
                <th scope="col">Brand</th>
                <th scope="col">Price</th>
                <th scope="col">Size</th>
                <th scope="col">Quantity</th>
                <th scope="col">Status</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="pr">
                <tr>
                    <th scope="row align-items-center justify-content-center
">${pr.idProduct}</th>
                    <td>${pr.nameProduct}</td>

                    <td><img alt="" src="${pr.img}" width="200px" height="150px"></td>
                    <td style="text-align: center;margin: auto 0">${pr.material}</td>
                    <td>${pr.brand}</td>
                    <td>${pr.price}</td>
                    <td>${pr.size}</td>
                    <td>${pr.quantity}</td>
                    <td>${pr.status?"Con":"Het"}</td>
                    <td>
                        <a href="#" class="btn btn-info" role="button" style="width: 70px;display: flex;justify-content: center;align-items: center">Update</a>
                        <a href="#" class="btn btn-info mt-3" role="button" style="width: 70px;display: flex;justify-content: center;align-items: center">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
</div>
</html>
