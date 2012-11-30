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

	public static void connection() {
		render();
	}

}