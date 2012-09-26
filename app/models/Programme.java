package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

@Entity
public class Programme extends Model {

	@Temporal(TemporalType.DATE)
	private final Date debut;

	@Temporal(TemporalType.DATE)
	private final Date fin;

	private final String titre;
	private final String detail;
	private final String auteur;
	private final String lieu;

	@OneToMany(mappedBy = "programme", cascade = CascadeType.ALL)
	private final List<Commentaire> commentaires;

	public Programme(Date debut, Date fin, String titre, String detail, String auteur, String lieu) {
		this.commentaires = new ArrayList<Commentaire>();
		this.debut = debut;
		this.fin = fin;
		this.titre = titre;
		this.detail = detail;
		this.auteur = auteur;
		this.lieu = lieu;

	}
}