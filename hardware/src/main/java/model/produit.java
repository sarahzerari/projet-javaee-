package model;

public class produit {
	private int idproduit;
	private String nom;
	private String categorie;
	private int prix;
	private String image;
	private int quantite;

	
	
	public produit() {
	}

	
	public produit(int  idproduit, String nom, String categorie, int prix, String image,int quantite) {
		super();
		this. idproduit=  idproduit;
		this.nom = nom;
		this.categorie = categorie;
		this.prix = prix;
		this.image = image;
		this.quantite = quantite;
	}


	public int getId() {
		return  idproduit;
	}

	public void setId(int idproduit) {
		this. idproduit = idproduit;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}

	public void setQauntite(int quantite) {
		this.quantite = quantite;
	}

	public String getImage() {
		return image;
	}
	

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "produit [id=" + idproduit + ", name=" + nom + ", category=" + categorie + ", price=" + prix + ", image="
				+ image + "]";
	}
	
	
}