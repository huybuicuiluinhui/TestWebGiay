<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    />
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"
    />
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"
    />
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <link
            href="https://fonts.googleapis.com/css?family=Roboto"
            rel="stylesheet"
    />
    <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    />
</head>
<body>
<div class="container mt-5 mb-5">
    <div class="d-flex justify-content-center row">
        <div class="col-md-8">
            <div class="p-2">
                <h4>Shopping cart</h4>
            </div>
            <c:forEach items="${sanPhamTrongGio}" var="sanPham">
            <form action="/shopping-cart/update" method="post">
             <input type="hidden" name="id" value="${sanPham.idProduct}">
            <div
                    class="d-flex flex-row justify-content-between align-items-center p-2 bg-white mt-4 px-3 rounded"
            >
                <div class="mr-1">
                    <img src="/resources/imgProduct/${sanPham.img}" width="70" name="img"/>
                </div>
                <div class="d-flex flex-column align-items-center product-details">
                <span class="font-weight-bold"> ${sanPham.nameProduct}</span>
                    <div class="d-flex flex-row product-desc">
                        <div class="size mr-1">
                  <span class="text-grey">Size:</span
                  ><span class="font-weight-bold">&nbsp;${sanPham.size}</span>
                        </div>
                        <div class="color">
                  <span class="text-grey">Color:</span
                  ><span class="font-weight-bold">&nbsp;Grey</span>
                        </div>
                    </div>
                </div>
                <div class="d-flex flex-row align-items-center qty">
                  <input name="qty" value="${sanPham.qty}" onblur="this.form.submit()">
                </div>
                <div>
                    <h5 class="text-grey">${sanPham.qty * sanPham.price } $</h5>
                </div>
                <div class="d-flex align-items-center">
                    <a href="/shopping-cart/delete/${sanPham.idProduct}"> <i class="fa fa-trash mb-1 text-danger" ></i></a>
                </div>
            </div>
            </form>
            </c:forEach>
            <div class="order_total">
                <div class="order_total_content text-md-right">
                    <div class="order_total_title">Order Total:</div>
                    <div class="order_total_amount"> ${total} $</div>
                </div>
            </div>
                    <a class="btn btn-warning " href="/shopping-cart/clear">Clear cart</a>
            <a class="btn btn-warning "  href="/asm/product/user">Add more</a>
            <div
                    class="d-flex flex-row align-items-center mt-3 p-2 bg-white rounded"
            >

                <form action="/checkout" method="post">
                    <div class="col"  style="margin-bottom: 20px">
                        <label class="form-label">Thong tin dia chi nhan hang</label>
                        <input type="text" class="form-control"   name="address" required >
                    </div>
                <button
                        class="btn btn-warning btn-block btn-lg ml-2 pay-button"
                        type="submit"
                >
                    Proceed to Pay
                </button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>