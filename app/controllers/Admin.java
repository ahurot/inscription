package controllers;

import java.io.File;
import java.util.Date;
import java.util.List;

import models.Administrator;
import models.Program;
import models.User;
import play.data.validation.Required;
import play.mvc.Controller;
import play.mvc.Router;
import utils.CsvHelper;

public class Admin extends Controller {

	public static void connect(@Required String nom, @Required String password) {

		if (validation.hasErrors()) {
			render("Admin/connection.html");
		}

		if (Administrator.find("select a from Administrator a where a.name = ? and a.password = ?", nom, password).first() != null) {
			session.put("admin.identifiant", nom);
			render("Admin/connection.html");
		} else {
			flash.error("Erreur de connection");
			render("Admin/connection.html");
		}
	}

	public static void listUser() {

		List<User> users = User.findAll();

		render(users);
	}

	public static void deleteUser(String userid) {

		User user = User.findById(Long.valueOf(userid));
		user.delete();
		flash.success("L'utilisateur a bien été supprimé");
		listUser();
	}

	public static void editUser(String userid, String nom, String prenom, String tel, String mail) {

		User user = User.findById(Long.valueOf(userid));
		user.name = nom;
		user.firstName = prenom;
		user.phoneNumber = tel;
		user.mail = mail;
		user.save();
		flash.success("L'utilisateur à bien été modifié");
		listUser();
	}

	public static void exportUsers() {
		List<User> users = User.findAll();
		CsvHelper.generateCSV(users);

		File f = new File("exportCSV.csv");
		if (f.exists() && f.isFile()) {
			renderBinary(f);
		}
		listUser();
	}

	public static void logout() {
		session.clear();

		redirect(Router.getFullUrl("Application.index"));
	}

	public static void desinscription() {
		render();
	}
	public static void connection() {
		render();
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

}
