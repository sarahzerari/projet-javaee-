package dao;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.*;

public class ClientDAO {
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;

	public ClientDAO(Connection con) {
		this.con = con;
	}
	
	public Client userLogin(String email, String password) {
		Client user = null;
        try {
            query = "select * from client where adressmail=? and password=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next()){
            	user = new Client();
            	user.setId(rs.getInt("idclient"));
            	user.setNom(rs.getString("nom"));
            	user.setAdressmail(rs.getString("adressmail"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }
}