<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/shoppingCartStyle.css">
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script src="../js/shoppingCart.js"></script>
</head>
<body>
	<h1>Welcome ${userDetail.username} !!!</h1>
	<br>
	<h3><a href="/viewCartDetails">View Items in Cart</a></h3>
	<br>
	<form:form method="POST" action="/productSearch"
		modelAttribute="productSearch">
		<table>
			<tr>
				<th colspan="6" style="text-align: left;">Search by</th>
			</tr>
			<tr>
				<td>Product id</td>
				<td><input type="number" name="productId" min="0"></td>
				<td>Product name</td>
				<td><input type="text" name="productName"></td>
				<td>Product category</td>
				<td><select name="productType">
						<option value="">Select</option>
						<c:forEach items="${productTypes}" var="productType">
							<option value='<c:out value="${productType}"/>'><c:out
									value="${productType}" /></option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan="6"><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form:form>

	<div>
		<c:if test="${productMapList.size() > 0}">
			<c:forEach items="${productMapList}" var="productMap">
				<br>
				<c:choose>
					<c:when test="${productMap.key eq 'BOOK'}">
						<table class="result">
							<tr>
								<th colspan="7" style="text-align: center;">Books</th>
							</tr>
							<tr>
								<th>Product Id</th>
								<th>Product Name</th>
								<th>Genre</th>
								<th>Author</th>
								<th>Publications</th>
								<th>Price</th>
								<th>Add to cart</th>
							</tr>
							<c:forEach items="${productMap.value}" var="product">
								<tr>
									<td>${product.productId}</td>
									<td><c:out value="${product.prodName}" /></td>
									<td><c:out value="${product.genre}" /></td>
									<td><c:out value="${product.author}" /></td>
									<td><c:out value="${product.publications}" /></td>
									<td><c:out value="${product.price}" /></td>
									<td><input type="number" min="1" value="1"
										style="width: 10%; margin-right: 5px"><input
										type="button" value="add"
										onclick="return addToCart(this, '${product.productId}');"></td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:when test="${productMap.key eq 'APPAREL'}">
						<table class="result">
							<tr>
								<th colspan="7" style="text-align: center;">Apparel</th>
							</tr>
							<tr>
								<th>Product Id</th>
								<th>Product Name</th>
								<th>Type</th>
								<th>Brand</th>
								<th>Design</th>
								<th>Price</th>
								<th>Add to cart</th>
							</tr>
							<c:forEach items="${productMap.value}" var="product">
								<tr>
									<td>${product.productId}</td>
									<td><c:out value="${product.prodName}" /></td>
									<td><c:out value="${product.type}" /></td>
									<td><c:out value="${product.brand}" /></td>
									<td><c:out value="${product.design}" /></td>
									<td><c:out value="${product.price}" /></td>
									<td><input type="number" min="1" value="1"
										style="width: 10%; margin-right: 5px"><input
										type="button" value="add"
										onclick="return addToCart(this, '${product.productId}');"></td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
				</c:choose>
			</c:forEach>
			<br>
		</c:if>
		<c:if test="${productMapList.size() == 0}">
			<br>
		<h3>No Results!!!</h3>
	</c:if>
	</div>

</body>
</html>