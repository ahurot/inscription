package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Administrateur extends Model {

	private final String nom;
	private final String motDePasse;

	public Administrateur(String nom, String motDePasse) {
		this.nom = nom;
		this.motDePasse = motDePasse;
	}

}
