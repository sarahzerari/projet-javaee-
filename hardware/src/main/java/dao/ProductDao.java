package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import model.*;
public class ProductDao {
 private Connection con ;
 private String query;
 private PreparedStatement pst;
 private ResultSet rs;
public ProductDao(Connection con) {
	super();
	this.con = con;
}
 public List<produit>getAllProducts(){
	 List<produit> products=new ArrayList<produit>();
	 try {
		 query="select * from produit";
		 pst=this.con.prepareStatement(query);
		 rs=pst.executeQuery();
		 while(rs.next()) {
			 produit row =new produit ();
			 row.setId(rs.getInt("idproduit"));
			 row.setNom(rs.getString("nom"));
			 row.setPrix(rs.getInt("prix"));
			 row.setQauntite(rs.getInt("quantite"));
			 row.setImage(rs.getString("image"));
			 row.setCategorie(rs.getString("categorie"));
			 products.add(row);	
		 }
		 
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	return products;
 }
 
 public List<Cart> getCartProducts(ArrayList<Cart>cartList){
	List<Cart>products =new ArrayList<Cart>();
	try { 
		if(cartList.size()>0) {
		  for(Cart item:cartList) {
			  query="select *from produit where idproduit=?";
			  pst =this.con.prepareStatement(query);
			  pst.setInt(1,item.getId());
			  rs=pst.executeQuery();
			  while(rs.next()) {
				  Cart row =new Cart();
				  row.setId( rs.getInt("idproduit"));
				  row.setNom(rs.getString("nom"));
				  row.setCategorie(rs.getString("categorie"));
				  row.setPrix(rs.getInt("prix")*item.getQuantite());
				  row.setQuantite(item.getQuantite());
				  products.add(row);
			  }
			  
		  }	
		}	
		
	}catch(Exception e) {
		System.out.println(e);
		}
	return products;
	 
 }
 public produit getSingleProduct(int id) {
	 produit row = null;
        try {
            query = "select * from produit where idproduit=? ";

            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
            	row = new produit();
                row.setId(rs.getInt("idproduit"));
                row.setNom(rs.getString("nom"));
                row.setPrix(rs.getInt("prix"));
                row.setQauntite(rs.getInt("quantite"));
                row.setImage(rs.getString("image"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return row;
 }
 public double getTotalCartPrice(ArrayList<Cart> cartList) {
     double sum = 0;
     try {
         if (cartList.size() > 0) {
             for (Cart item : cartList) {
                 query = "select prix from produit where idproduit=?";
                 pst = this.con.prepareStatement(query);
                 pst.setInt(1, item.getId());
                 rs = pst.executeQuery();
                 while (rs.next()) {
                     sum+=rs.getInt("prix")*item.getQuantite();
                 }

             }
         }

     } catch (SQLException e) {
         e.printStackTrace();
         System.out.println(e);
     }
     return sum;
 }}
 
 
 
