<%--
  Created by IntelliJ IDEA.
  User: sayyed
  Date: 12/03/2019
  Time: 01:34 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>shop</title>


</head>
<body>


<div class="page-title">Product</div>

<table style="text-align:left;">
<form:form action="add" modelAttribute="product" method="POST" enctype="multipart/form-data" >
    <form:hidden path="id" />
        <tr>
            <td align="left" width="20%">CODE: </td>
            <td align="left" width="40%"><form:input path="code" size="30"/></td>
            <td align="left"><form:errors path="code" cssClass="error"/></td>
        </tr>

        <tr>
            <td align="left" width="20%">Name: </td>
            <td align="left" width="40%"><form:input path="name" size="30"/></td>
            <td align="left"><form:errors path="name" cssClass="error"/></td>
        </tr>

        <tr>
            <td>Price *</td>
            <td><form:input path="price" /></td>
            <td><form:errors path="price" class="error-message" /></td>
        </tr>
        <tr>
            <td>Image</td>
            <td>
                <img src="productImage?id=${product.id}" width="100"/></td>
            <td> </td>
        </tr>
        <tr>
            <td>Upload Image</td>
            <td><form:input type="file" path="fileData"/></td>

        </tr>


        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="save" /> <input type="reset"
                                                              value="Reset" /></td>
        </tr>

</form:form>
</table>

</body>
</html>