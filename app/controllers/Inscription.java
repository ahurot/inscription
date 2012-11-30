package controllers;

import models.User;
import play.data.validation.Required;
import play.mvc.Controller;

public class Inscription extends Controller {
	public static void inscription() {
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
			render("Inscription/inscription.html");
		}
		new User(nom, prenom, tel, mail, commentaire).save();
		flash.success("Welcome %s", prenom);
		inscription();
	}
}
