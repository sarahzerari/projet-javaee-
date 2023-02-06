<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/header.jsp"%>
<link type="text/css" href="main.css" rel="stylesheet" />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
        />
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'><link rel="stylesheet" href="style/style.css">

<meta charset="windows-1256">
<title>Login</title>
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

<div class="container">
   <section id="formHolder">

      <div class="row">

         
         <div class="col-sm-6 brand">
            <a href="#" class="logo"><span></span></a>

            <div class="heading">
               <h2>Hardware Store</h2>
            </div>

            <div class="success-msg">
               <p>Great! You are one of our members now</p>
               <a href="#" class="profile">Your Profile</a>
            </div>
         </div>


         
         <div class="col-sm-6 form">

            
            <div class="login form-peice switched">
               <form class="login-form" action=Login-servlet method=post>
                  <div class="form-group">
                     <label for="loginemail">Email Address</label>
                     <input type="email" name="txtName" id="loginemail" required>
                  </div>

                  <div class="form-group">
                     <label for="loginPassword">Password</label>
                     <input type="password" name="txtPwd" id="loginPassword" required>
                  </div>

                  <div class="CTA">
                     <input type="submit" value="Login">
                     <a href="Register" class="switch">I'm New</a>
       </div>
               </form>
         </div>
       <!-- hadi la partie mzl ma tamshish-->
            <div class="signup form-peice">
               <form class="signup-form" action="login-two-servlet" method="post">

                  <div class="form-group">
                     <label for="name">Full Name</label>
                     <input type="text" name="nom" id="name" class="name">
                     <span class="error"></span>
                  </div>

                  <div class="form-group">
                     <label for="email">Email Adderss</label>
                     <input type="email" name="adressmail" id="email" class="email">
                     <span class="error"></span>
                  </div>

                 

                  <div class="form-group">
                     <label for="password">Password</label>
                     <input type="password" name="password" id="password" class="pass">
                     <span class="error"></span>
                  </div>

                 
                   <div class="form-group">
                     <label for="phone">Code Postal  </label>
                     <input type="text" name="codepostal" id="code">
                  </div>

                  <div class="CTA">
                     <input type="submit" value="Register" >
                     <a href="login"  class="switch" >I have an account</a>
                  </div>
                 
               </form>
            </div>
         </div>
      </div>

   </section>

</div>
<!-- partial -->
 <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script><script  src="scripts/script.js"></script>
 <%@include file="/includes/footer.jsp"%>
</body>
</html>