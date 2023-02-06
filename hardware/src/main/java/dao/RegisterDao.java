package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Client;

public class RegisterDao {
private String dburl="jdbc:mysql://localhost:3306/projet";
private String dbuname="root";
private String dbpassword="30mars2002";
private String dbdriver="com.mysql.jdbc.Driver";
public void loadDriver(String dbDriver) {
	try {
		Class.forName(dbDriver);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
public Connection getConnection () {
	Connection con=null;
	try {
		con=DriverManager.getConnection(dburl,dbuname,dbpassword);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return con;
	
}
public String insert(Client  client) {
	loadDriver(dbdriver);
	Connection con=getConnection();
	String result="Data entered successfuly";
	String sql="insert into client values(?,?,?,?)";
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, client.getNom());
		ps.setString(2, client.getAdressmail());
		ps.setString(3, client.getPassword());
		ps.setString(4, client.getCodepostal());
		
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		result="data not entered";
	}
	return result;
	}
}
