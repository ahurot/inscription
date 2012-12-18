package controllers;

import java.util.List;

import models.Program;
import play.mvc.Controller;

public class Programme extends Controller {

	public static void programme() {
		List<Program> laterProgrammes = Program.find().order("-begin").asList();

		render(laterProgrammes);
	}
}
