<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart Details</title>
<link rel="stylesheet" href="../css/shoppingCartStyle.css">
<script src = "https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script src="../js/shoppingCart.js"></script>
</head>
<body>
<h1>Shopping Cart</h1>
<br>
<h3><a href="/productSearch">Back to Product Search</a></h3>
<br>

<div>
	<c:if test="${cartItemsMapList.size() > 0}">
	<c:forEach items="${cartItemsMapList}" var="cartItemsMap" >
	<br>
	<c:choose>
	<c:when test="${cartItemsMap.key eq 'BOOK'}">
	<table class="result" id="bookTable">
		<tr>
			<th colspan="8" style="text-align: center;">Books</th>
		</tr>
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Genre</th>
			<th>Author</th>
			<th>Publications</th>
			<th>Price per unit</th>
			<th>Price</th>
			<th>Update Cart</th>
		</tr>
		<c:forEach items="${cartItemsMap.value}" var="cartItem"  varStatus="status">
			<tr>
				<td>${cartItem.product.productId}</td> 
				<td><c:out value="${cartItem.product.prodName}"/></td>
				<td><c:out value="${cartItem.product.genre}"/></td>
				<td><c:out value="${cartItem.product.author}"/></td>
				<td><c:out value="${cartItem.product.publications}"/></td>
				<td id="bookPrice${status.index}"><c:out value="${cartItem.product.price}"/></td>
				<td id="bookTotalPrice${status.index}"><c:out value="${cartItem.product.price * cartItem.quantity}"/></td>
				<td><input type="number" min="0"  id="bookQuantity${status.index}" value='<c:out value="${cartItem.quantity}"/>' style="width: 10%; margin-right: 5px">
					<input type="button" value="update" onclick="return addUpdateCart(this, '${cartItem.product.productId}', '${status.index}');">
					<input type="button" value="remove" onclick="return removeCartItem(this, '${cartItem.product.productId}', '${status.index}');" ></td>
			</tr>
		</c:forEach>
	</table>
	</c:when>
	<c:when test="${cartItemsMap.key eq 'APPAREL'}">
	<table class="result" id="apparelTable">
		<tr>
			<th colspan="8" style="text-align: center;">Apparel</th>
		</tr>
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Type</th>
			<th>Brand</th>
			<th>Design</th>
			<th>Price per unit</th>
			<th>Price</th>
			<th>Update cart</th>
		</tr>
		<c:forEach items="${cartItemsMap.value}" var="cartItem" varStatus="status">
			<tr>
				<td>${cartItem.product.productId}</td> 
				<td><c:out value="${cartItem.product.prodName}"/></td>
				<td><c:out value="${cartItem.product.type}"/></td>
				<td><c:out value="${cartItem.product.brand}"/></td>
				<td><c:out value="${cartItem.product.design}"/></td>
				<td id="apparelPrice${status.index}"><c:out value="${cartItem.product.price}"/></td>
				<td id="apparelTotalPrice${status.index}"><c:out value="${cartItem.product.price * cartItem.quantity}"/></td>
				<td><input type="number" min="0" id="apparelQuantity${status.index}" value='<c:out value="${cartItem.quantity}"/>' style="width: 10%; margin-right: 5px">
					<input type="button" value="update" onclick="return addUpdateCart(this, '${cartItem.product.productId}', '${status.index}');" >
					<input type="button" value="remove" onclick="return removeCartItem(this, '${cartItem.product.productId}', '${status.index}');" ></td>
			</tr>
		</c:forEach>
	</table>
	</c:when>
	</c:choose>
	</c:forEach>
	<br>
	<table id="TotalAmountTable" class="result">
	<tr id="emptyCart" style="display: none;">
		<th style="text-align: center;">Cart is Empty!!! </th>
	</tr>
	<tr>
		<th style="text-align: right;padding-right: 40px;">Total Amount <span id="totalAmount" style="margin-left: 10px;margin-right: 10px;"></span></th>
	</tr>
	</table>
	</c:if>
	<c:if test="${cartItemsMapList.size() == 0}">
		<br>
		<table class="result">
	<tr>
		<th style="text-align: center;">No items added to cart!!!</th>
	</tr>
	</table>
	</c:if>
	<br>
</div>

</body>
</html>