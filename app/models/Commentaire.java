package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Commentaire extends Model {

	private final String auteur;
	private Date postedAt;

	@Lob
	private final String contenu;

	@ManyToOne
	private final Programme programme;

	public Commentaire(String auteur, String contenu, Programme programme) {
		this.auteur = auteur;
		this.contenu = contenu;
		this.programme = programme;
	}

}
