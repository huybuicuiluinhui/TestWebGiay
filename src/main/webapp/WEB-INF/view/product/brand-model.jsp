<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<h1>Brand model</h1>
<table border="1">
    <tr>
        <th>Hang kiem</th>
        <th>So luong</th>
    </tr>
    <c:forEach items="${products}" var="sanPham">
            <tr>
                <td> ${sanPham[0]} </td>
                <td> ${sanPham[1]} </td>
            </tr>
    </c:forEach>
</table>