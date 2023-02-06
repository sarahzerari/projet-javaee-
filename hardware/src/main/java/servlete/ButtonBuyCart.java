package servlete;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.OrderCart;
import model.Cart;
import model.Client;
import dao.*;
import connection.DbCon;

@WebServlet("/button-buy-cart")
public class ButtonBuyCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			
			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			Client auth = (Client) request.getSession().getAttribute("auth");
			if(cart_list != null && auth!=null) {
				for(Cart c:cart_list) {
					OrderCart AddCartModel = new OrderCart();
           		        AddCartModel.setIdproduit(c.getId());
		                AddCartModel.setQunatity(c.getQuantite());
		                AddCartModel.setPrix(c.getPrix()*(c.getQuantite()));
		                AddCartModel.setIdclient(auth.getId());
		                OrderCartDAO oDao = new OrderCartDAO(DbCon.getConnection());
					boolean result = oDao.insertOrderCartDAO(AddCartModel);
					if(!result) break;
				}
				cart_list.clear();
				response.sendRedirect("facture.jsp");
			}else {
				if(auth==null) {
					response.sendRedirect("login.jsp");
				}else
				 response.sendRedirect("Cart.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}