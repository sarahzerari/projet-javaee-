package servlete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.DbCon;
import model.*;
import dao.*;

@WebServlet("/Login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		
		ClientDAO udao = new ClientDAO(DbCon.getConnection());
		String n =request.getParameter("txtName");
		String p =request.getParameter("txtPwd");
		
		Client user = udao.userLogin(n, p);
		if (user != null) {
			request.getSession().setAttribute("auth", user);
//				System.out.print("user logged in");
			response.sendRedirect("Cart.jsp");
		} else {
			out.println("there is no user");
			response.sendRedirect("Login.jsp");
		}
	}
}

