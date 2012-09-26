package models;

import javax.persistence.Entity;

import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class User extends Model {

	@Required
	public String nom;
	@Required
	public String prenom;
	@Required
	public String tel;

	@Required
	@Email
	public String mail;

	public boolean isInscrit;

	public String commentaire;

	public User(String nom, String prenom, String tel, String mail, String commentaire) {
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.mail = mail;
		this.commentaire = commentaire;
		this.isInscrit = true;
	}

	@Override
	public String toString() {
		return this.nom + ';' + this.prenom + ';' + this.tel + ';' + this.mail + ';' + this.commentaire + ';' + this.isInscrit;
	}
}
