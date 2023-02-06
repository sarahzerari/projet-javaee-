package model;
public class Client {
private int id;
	private String nom,adressmail, password,codepostal;
public Client() {
	super();
}

public Client(String nom, String adressmail, String password,  String codepostal) {
	super();
	this.nom = nom;
	this.adressmail = adressmail;
	this.password = password;
	
	this.codepostal = codepostal;
}
public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getAdressmail() {
	return adressmail;
}

public void setAdressmail(String adressmail) {
	this.adressmail = adressmail;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getCodepostal() {
	return codepostal;
}

public void setCodepostal(String codepostal) {
	this.codepostal = codepostal;
}

public int getId() {
	
	return id;
}

public void setId(int id) {
	this.id=id;
	
}





}

