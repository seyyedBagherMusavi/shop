<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>shop</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>

<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <h2>product list</h2>
        <hr />
        <c:url var="addLink" value="/admin/addProduct"/>
        <input type="button" value="Add Product"
               onclick="window.location.href='${addLink}'; return false;"
               class="btn btn-primary" />
        <br/><br/>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Customer List</div>
            </div>
            <div class="panel-body">
                <table class="table table-striped table-bordered">

    <tr>
        <th>code</th>
        <th>name</th>
        <th>image</th>
        <th>price</th>
        <th>action</th>

    </tr>


    <c:forEach items="${productList}" var="product">
        <c:url var="updateLink" value="/admin/update">
            <c:param name="productId" value="${product.id}" />
        </c:url>

        <!-- construct an "delete" link with customer id -->
        <c:url var="deleteLink" value="/admin/delete">
            <c:param name="productId" value="${product.id}" />
        </c:url>
        <tr>
            <td><c:out value="${product.code}" /></td>
            <td><c:out value="${product.name}" /></td>
            <td> <img class="product-image"
                      src="<c:url value='/home/productImage?id=${product.id}'/>"  height="100" width="100"/></td>
            <td><c:out value="${product.price}" /></td>

            <td>
                <!-- display the update link --> <a href="${updateLink}">Update</a>
                | <a href="${deleteLink}"
                     onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
            </td>
        </tr>
    </c:forEach>

</table>


</body>

</html>