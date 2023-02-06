package servlete;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.DbCon;
import model.*;
import dao.*;

@WebServlet("/login-two-servlet")
public class LoginTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 RequestDispatcher dispatcher  = null;
        try {
        	String nom = request.getParameter("nom");
    		String adressmail = request.getParameter("adressmail");
    		String password = request.getParameter("password");
    		String codepostal = request.getParameter("codepostal");
    		Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet?useSSL=false","root","30mars2002");
        	PreparedStatement pst = con.prepareStatement("insert into client(nom,password,adressmail,codepostal) values (?,?,?,?)");
            pst.setString(1, nom);
            pst.setString(2, password);
            pst.setString(3, adressmail);
            pst.setString(4, codepostal);
            int rowCount = pst.executeUpdate();
            
            ClientDAO udao = new ClientDAO(DbCon.getConnection());
			Client user = udao.userLogin(adressmail, password);
			if (user != null) {
				request.getSession().setAttribute("auth", user);
				System.out.print("user logged in");
				response.sendRedirect("Cart.jsp");
			} else {
				System.out.println("there is no user");
			}
          
    		
        	
        }catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("connection echoui");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection impossible");
        
        }
	}

}
