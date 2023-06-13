<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<table class="table">
    <thead>
    <tr>
        <th>Quantity</th>
        <th>Price</th>
        <th>Total</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${cart.items}">
        <tr>
            <td>${item.qty}</td>
            <td>${item.nameProduct}</td>
            <td>${item.price}</td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
        <td colspan="3">Total Price:</td>

    </tr>
    </tfoot>
</table>