<%@ page import="connection.DbCon"%>
<%@ page import="java.sql.*"%>
<%@page import="dao.*" %>
<%@page import="servlete.*" %>
<%@page import="model.*" %>
<%@ page import="java.text.DecimalFormat"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);
Client auth = (Client) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
}
ArrayList<Cart> cart_list =  (ArrayList<Cart>)  session.getAttribute("cart-list");
List<Cart> cartProduct = null;
if (cart_list != null) {
	ProductDao p = new ProductDao(DbCon.getConnection());
	cartProduct = p.getCartProducts(cart_list);
	double total = p.getTotalCartPrice(cart_list);
	request.setAttribute("total", total);
	request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/header.jsp"%>
<link type="text/css" href="main.css" rel="stylesheet" />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
            integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
            crossorigin="anonymous"
        />
<title>E-Commerce Cart</title>
<style type="text/css">
.table tbody td{
vertical-align: middle;
}
.btn-incre, .btn-decre{
box-shadow: none;
font-size: 25px;
}
</style>
</head>
<body>
<nav>
            <!--Navbar has two part the top one and the bottom one-->
            <!--Here is top one and in this part I put logo, my account part, and the shopping cart-->
            <div class="navbar-top">
                <div>
                    <button id="menuButton"><i class="fas fa-bars"></i></button>
                    <!--Logo-->
                    <a href="produit.jsp">
                        <h2 class="logo" >HardeWar.Dz</h2>
                    </a>
                </div>
                <div>
                    <!--My account part-->
                    <div class="account">
                        <a href="login.jsp">
                            <button class="account-btn">
                                <i class="fas fa-user-alt"></i>
                            </button>
                            <span class="account-text">My account</span>
                        </a>
                        <!--When we click the btnShowAccountInfo this section will be displayed-->
                    </div>
                    <!--Shopping cart-->
                    <div class="shopping-cart">
                        <div class="sum-prices">
                         <a href="Cart.jsp">
                            <button class="account-btn">
                            <i
                                class="fas fa-shopping-cart shoppingCartButton" href="Cart.jsp"
                            ></i>
                              </button>
                        </div>
                        </a>
                    </div>
                </div>
            </div>
        </nav>

	<div class="container my-3">
		<div class="d-flex py-3"><h3>Total Price: $ ${(total>0)?dcf.format(total):0} </h3> </div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (cart_list != null) {
					for (Cart c : cartProduct) {
				%>
				<tr>
					<td><%=c.getNom()%></td>
					<td><%=c.getCategorie()%></td>
					<td id="prixp"><%= dcf.format(c.getPrix())%></td>
					<td>
						<form action="add-cart-db" method="post" class="form-inline">
						<input type="hidden" name="id" value="<%= c.getId()%>" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn bnt-sm btn-incre" href="inc-dec-servlet? action=inc&id=<%=c.getId()%>"><i class="fas fa-plus-square"></i></a> 
								<input type="text" name="quantite" class="form-control"  value="<%=c.getQuantite()%>" readonly> 
								<a class="btn btn-sm btn-decre" href="inc-dec-servlet? action=dec&id=<%=c.getId()%>"><i class="fas fa-minus-square"></i></a>
							</div>
						</form>
					</td>
					<td><form>
					
					<td><a href="remove-function?id=<%=c.getId() %>" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>

				<%
				}}%>
			</tbody>
		</table>
		<div>
		  <center><a class="mx-3 btn btn-primary" href="button-buy-cart" >BUY</a></center>          
		  </div>
	</div>

	<%@include file="includes/footer.jsp"%>
</body>
</html>