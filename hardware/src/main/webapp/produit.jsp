<%@ page import="connection.DbCon"%>
<%@ page import="java.sql.*"%>
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
Client auth = (Client) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
}
ProductDao pd=new ProductDao(DbCon.getConnection());
List<produit> products= pd.getAllProducts();


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
<title>Hardewar.Dz</title>
</head>
<body>
	<//%@include file="includes/navBare.jsp"%>
 <nav>
            <!--Navbar has two part the top one and the bottom one-->
            <!--Here is top one and in this part I put logo, my account part, and the shopping cart-->
            <div class="navbar-top">
                <div>
                    <button id="menuButton"><i class="fas fa-bars"></i></button>
                    <!--Logo-->
                    <a href="produit.jsp">
                        <h2 class="logo" >HardWare.Dz</h2>
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
	<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
				<% if(!products.isEmpty()){
				for(produit p:products){%>	
				
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" src="images/<%=p.getImage()%>"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%=p.getNom() %></h5>
						<h6 class="price">Price: $<%=p.getPrix() %></h6>
						<h6 class="category">Category: <%=p.getCategorie()%></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-primary" href="add-to-cartt?id=<%=p.getId()%>">Buy Now</a>
						</div>
						
					</div>
				</div>
			</div>
			<%}
			}
			%>
		</div>
	</div>

	<%@include file="includes/footer.jsp"%>
</body>
</html>