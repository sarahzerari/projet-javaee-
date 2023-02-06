package model;

public class OrderCart extends produit{
	private int idpanier;
	private int idproduit;
	private int qunatity;
	private int idclient;
	private int prixp;
	
	public OrderCart() {
	}
	
	public OrderCart(int idpanier, int idproduit, int qunatity, int  idclient,int prixp) {
		super();
		this.idpanier = idpanier;
		this.idproduit =idproduit;
		this.qunatity = qunatity;
		this. idclient =  idclient;
		this.prixp=prixp;
	}

	public OrderCart(int idproduit, int qunatity, int idclient) {
		super();
		this.idproduit = idproduit;
		this.qunatity = qunatity;
		this.idclient = idclient;
	}

	public int getIdpanier() {
		return idpanier;
	}
	public void setIdpanier(int idpanier) {
		this.idpanier =idpanier ;
	}
	
	public int getIdproduit() {
		return idproduit;
	}

	public void setIdproduit(int Idproduit) {
		this.idproduit = Idproduit;
	}

	public int getQunatity() {
		return qunatity;
	}
	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	public int getPrixp() {
		return prixp;
	}
	public void setPrixp(int prixp) {
		 this.prixp=prixp;
	}
}