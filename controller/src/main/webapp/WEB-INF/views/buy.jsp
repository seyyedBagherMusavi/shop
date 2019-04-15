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
            <input type="button" id="buyButtom" onclick="testAjax()">buy</input>
            <input id="buyState"/>
            <script>
                function testAjax() {

                    var xhttp;
                    xhttp=new XMLHttpRequest();
                    xhttp.onreadystatechange = function() {
                        if (this.readyState == 4 && this.status == 200) {
                            if(this.responseText.includes("succesfull")){
                                document.getElementById("buyState").value="your buy is complete"
                                alert("your buy is complete");
                                window.location= "http://localhost:8080/controller_war_exploded/";
                            }else{
                                document.getElementById("buyState").value="not enough mony or etc"
                            }
                        }
                    };
                    xhttp.open("GET", "http://localhost:8081/rest/balance/"+${user.cardNumber}+"/"+${orderObj.price}, true);
                    xhttp.send();
                }
            </script>
        </div>

</body>
</html>