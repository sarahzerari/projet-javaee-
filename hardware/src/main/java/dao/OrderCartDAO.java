package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import connection.DbCon;
import model.*;

public class OrderCartDAO {
	
	

	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    
    

	public OrderCartDAO(Connection con) {
		super();
		this.con = con;
	}
	

	public boolean insertOrderCartDAO(OrderCart model) {
        boolean result = false;
        try {
            query = "insert into panier (idproduit,quantitep,prixp,idclient ) values (?,?,?,?)";
            pst = this.con.prepareStatement(query);
        
            pst.setInt(1, model.getIdproduit());
            pst.setInt(2, model.getQunatity());
            pst.setInt(3, model.getPrixp());
            pst.setInt(4, model.getIdclient());
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
	

    public List<OrderCart> userOrders(int id) {
        List<OrderCart> list = new ArrayList<>();
        
        try {
            query = "select * from panier where idclient='"+id+"'";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
            	OrderCart order = new OrderCart();
                ProductDao productDao = new ProductDao(this.con);
                int pId = rs.getInt("idproduit");
                produit product = productDao.getSingleProduct(pId);
                order.setIdpanier(rs.getInt("idpanier"));
                order.setIdproduit(pId);
             
               
                order.setPrixp(product.getPrix()*rs.getInt("quantitep"));
                order.setQunatity(rs.getInt("quantitep"));
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void cancelOrder(int id) {
        //boolean result = false;
        try {
            query = "delete from panier where idpanier=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            //result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        //return result;
    }
}
