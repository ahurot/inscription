package controllers;

import java.util.Date;
import java.util.List;

import models.Administrator;
import models.Program;
import models.User;
import play.data.validation.Required;
import play.mvc.Controller;

public class Application extends Controller {

	public static void index() {
		render();
	}

	public static void init() {
		new Administrator("admin", "admin").save();
		new Program(new Date(2012, 10, 1, 12,0,0), new Date(2012, 10, 1, 12, 30,0), "introduction", "présentation du Sessad Anatole France", "Mr Lefort", "Amphi 3").save();
		new Program(new Date(2012, 10, 1, 14, 00, 0), new Date(2012, 10, 1, 15,0, 0), "présentation 1", "présentation du SAT Le Robec", "Mr Lefort", "Amphi 4").save();
		new Program(new Date(2012, 10, 1, 15, 00, 0), new Date(2012, 10, 1, 17, 45, 0), "cloture", "mot du président", "Bertrand Hauguel", "Amphi 2").save();
		render();
	}
	
	public static void inscription() {
		render();
	}

	public static void programme() {
		List<Program> laterProgrammes = Program.find("order by begin asc").fetch();

		render(laterProgrammes);
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

		new Program(debut, fin, titre, detail, auteur, lieu).save();
		flash.success("Programme ajouté avec succès");
		render("Application/admin.html");
	}

	public static void connection() {
		render();
	}

}