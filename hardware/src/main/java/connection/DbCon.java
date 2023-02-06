package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbCon {
private static Connection con;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","30mars2002");
            System.out.println("connecter");
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
	
}
