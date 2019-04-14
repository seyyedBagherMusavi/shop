<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


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

		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Product List</div>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered">

				<tr>
					<th>code</th>
					<th>name</th>
					<th>image</th>
					<th>price</th>
					<th>quantity</th>
					<th>addToOrders</th>

				</tr>


				<c:forEach items="${productList}" var="product">


					<!-- construct an "delete" link with customer id -->
					<c:url var="addProductLink" value="/home/addProduct">
						<c:param name="productId" value="${product.id}" />
						<c:param name="quantity"  />
					</c:url>
					<tr>
						<td><c:out value="${product.code}" /></td>
						<td><c:out value="${product.name}" /></td>
						<td> <img class="product-image"
								  src="<c:url value='/home/productImage?id=${product.id}'/>"  height="100" width="100"/></td>
						<td><c:out value="${product.price}" /></td>
						<td> <input type="text" id="${product.code}" name="quantity" /> </td>

						<td>
							<script>
								function doalert(obj,obj1,obj2) {
									obj.href = obj2 + document.getElementById(obj1).value;
									return false;
								}
							</script>
							 <a  onclick="doalert(this,'${product.code}','${addProductLink}')"
								 >add</a>
						</td>
					</tr>
				</c:forEach>

			</table>
			</div>
		</div>
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Order List</div>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered">
					<tr>

						<th>name</th>
						<th>image</th>
						<th>price</th>
						<th>quantity</th>


					</tr>


					<c:forEach items="${orderObj.orderInfos}" var="order">


						<!-- construct an "delete" link with customer id -->

						<tr>
							<td><c:out value="${order.product.name}" /></td>

							<td> <img class="product-image"
									  src="<c:url value='/home/productImage?id=${order.product.id}'/>"  height="100" width="100"/></td>
							<td><c:out value="${order.product.price}" /></td>
							<td> <c:out value="${order.quantity}" /></td>

							</td>
						</tr>
					</c:forEach>

				</table>
			</div>
			<c:out value="price: ${orderObj.price}"></c:out>
		</div>

</body>
</html>