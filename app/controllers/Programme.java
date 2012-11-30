package controllers;

import java.util.List;

import models.Program;
import play.mvc.Controller;

public class Programme extends Controller {

	public static void programme() {
		List<Program> laterProgrammes = Program.find("order by begin asc").fetch();

		render(laterProgrammes);
	}
}
