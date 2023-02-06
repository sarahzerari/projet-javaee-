package servlete;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.Cart;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/add-to-cartt")
public class AddToCartServlett extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out=response.getWriter()){
			ArrayList<Cart>cartList=new ArrayList<>();

			//malek idproduit
			int id =Integer.parseInt(request.getParameter("id"));
			
			//saleeeeeeeeh
			Cart cm =new Cart();
			cm.setId(id);
			cm.setQuantite(1);
			
			HttpSession session=request.getSession();
				ArrayList<Cart> cart_list =(ArrayList<Cart>) session.getAttribute("cart-list");
				if (cart_list == null) {
	                cartList.add(cm);
	                session.setAttribute("cart-list", cartList);
	                response.sendRedirect("produit.jsp"); 
	               
	                
	            } else {
	                cartList = cart_list;
	                boolean exist = false;
	                for (Cart c : cart_list) {
	                    if (c.getId() == id) {
	                        exist = true; 
	                        out.println("<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='Cart.jsp'>GO to Cart Page</a></h3>");
	                      
	                    }
	                }

	                if (!exist) {
	                    cartList.add(cm);
	                   
	                    response.sendRedirect("produit.jsp");
	          
	                }
	            }
				
				 
				
						   	
         } catch (Exception e) {
			System.out.println(e);
		}
		}

	}