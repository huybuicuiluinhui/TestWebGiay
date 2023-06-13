<%@ page language="java" contentType="text/html; charset=UTF8"
         pageEncoding="UTF8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>
<%@include file="../../layout/headerAdmin.jsp" %>
<a href="/viewOrder"  class="btn btn-primary">Quay lại</a>
<section class="h-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-10 col-xl-8">
                <div class="card" style="border-radius: 10px;">
                    <div class="card-header px-4 py-5">
                            <h5 class="text-muted mb-0">Thanks for your Order, <span style="color: #a8729a;">${order.account.username}</span>!</h5>
                    </div>
                    <div class="card-body p-4">
                        <div class="d-flex justify-content-between align-items-center mb-4">
                            <p class="lead fw-normal mb-0" style="color: #a8729a;">Receipt</p>
                            <p class="small text-muted mb-0">Receipt Voucher : 1KAU9-84UIL</p>
                        </div>
<c:forEach items="${list}" var="ls">
    <div class="card shadow-0 border mb-4">
        <div class="card-body">
            <div class="row">
                <div class="col-md-2">
                    <img src="/resources/imgProduct/${ls.product.img}"
                         class="img-fluid" alt="Phone">
                </div>
                <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
                    <p class="text-muted mb-0">${ls.product.nameProduct}</p>
                </div>
                <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
                    <p class="text-muted mb-0 small">${ls.product.brand}</p>
                </div>
                <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
                    <p class="text-muted mb-0 small">Size: ${ls.product.size}</p>
                </div>
                <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
                    <p class="text-muted mb-0 small">Qty: ${ls.quantity} đôi</p>
                </div>
                <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
                    <p class="text-muted mb-0 small">Price: ${ls.price} $</p>
                </div>
            </div>

        </div>
    </div>
</c:forEach>

                        <div class="d-flex justify-content-between pt-2">
                            <p class="fw-bold mb-0">Order Details</p>
                            <p class="text-muted mb-0"><span class="fw-bold me-4">Address: </span>${order.address}</p>
                        </div>

                        <div class="d-flex justify-content-between pt-2">
                            <p class="text-muted mb-0">Invoice Number :${order.id}</p>
                        </div>

                        <div class="d-flex justify-content-between">
                            <p class="text-muted mb-0">Invoice Date :${order.oderDate}</p>
                            <p class="text-muted mb-0"><span class="fw-bold me-4">Address: </span>${total} $</p>
                        </div>


                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</div>
</body>
</html>
