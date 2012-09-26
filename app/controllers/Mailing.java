package controllers;

import java.util.List;

import models.User;

import org.apache.commons.mail.SimpleEmail;

import play.Logger;
import play.data.validation.Required;
import play.libs.Mail;
import play.mvc.Controller;

public class Mailing extends Controller {

	public static void show() {

		List<User> users = User.find("byIsInscrit", true).fetch();

		render(users);
	}

	public static void sendToSelected(@Required List<Long> listUsers, @Required String titre, @Required String contenu) {

		validation.required(titre);
		validation.required(contenu);
		params.flash();

		if (validation.hasErrors()) {
			show();
		}
		if (listUsers != null) {
			for (Long id : listUsers) {
				User user = User.findById(id);
				try {
					SimpleEmail email = new SimpleEmail();
					email.setFrom("anthony.hurot@enovea.net");
					email.addTo(user.mail);
					email.setSubject(titre);
					email.setMsg(contenu);
					Mail.send(email);
				} catch (Exception emailEx) {
					Logger.error("Error creating the email", emailEx);
				}
			}
			flash.success("Mail Envoye avec succès");
			show();
		} else {
			show();
		}
	}
}
