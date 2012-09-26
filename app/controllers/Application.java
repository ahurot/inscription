package controllers;

import java.util.Date;
import java.util.List;

import models.Administrateur;
import models.Programme;
import models.User;
import play.data.validation.Required;
import play.mvc.Controller;

public class Application extends Controller {

	public static void index() {
		new Administrateur("admin", "admin").save();
		new Programme(new Date(2012, 10, 1), new Date(2012, 10, 3), "titre", "detail", "auteur", "lieu").save();
		render();
	}

	public static void inscription() {
		render();
	}

	public static void programme() {

		Programme frontProgramme = Programme.find("order by debut asc").first();
		List<Programme> laterProgrammes = Programme.find("order by debut asc").from(1).fetch(5);

		render(frontProgramme, laterProgrammes);
	}

	public static void association() {
		render();
	}

	public static void postInscription(@Required String nom, @Required String prenom, @Required String tel, @Required String mail, String commentaire) {
		validation.email(mail).message("Email invalide");
		validation.required(nom).message("Nom Requis");
		validation.required(prenom).message("Prenom Requis");
		validation.required(tel).message("Tel Requis");
		validation.required(mail).message("Mail Requis");
		validation.phone(tel).message("Numero invalide");
		params.flash();
		if (validation.hasErrors()) {
			render("Application/inscription.html");
		}
		new User(nom, prenom, tel, mail, commentaire).save();
		flash.success("Welcome %s", prenom);
		inscription();
	}

	public static void postProgramme(@Required Date debut, @Required Date fin, @Required String titre, @Required String detail, @Required String auteur,
			@Required String lieu) {

		if (validation.hasErrors()) {
			render("Application/admin.html");
		}

		new Programme(debut, fin, titre, detail, auteur, lieu).save();
		flash.success("Programme ajouté avec succès");
		render("Application/admin.html");
	}

	public static void connection() {
		render();
	}

}