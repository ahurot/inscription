package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import models.User;

public class CsvHelper {

	public static File generateCSV(List<User> users) {
		File f = new File("exportCSV.csv");

		try {
			BufferedWriter bufferedWritter = new BufferedWriter(new FileWriter(f));
			{
				bufferedWritter.write("nom");
				bufferedWritter.write(';');
				bufferedWritter.write("prenom");
				bufferedWritter.write(';');
				bufferedWritter.write("tel");
				bufferedWritter.write(';');
				bufferedWritter.write("mail");
				bufferedWritter.write(';');
				bufferedWritter.write("commentaire");
				bufferedWritter.write(';');
				bufferedWritter.write("inscrit");
				bufferedWritter.append('\n');

				StringBuilder string = new StringBuilder();
				for (User user : users) {
					string.append(user);
					string.append('\n');
				}
				bufferedWritter.append(string);

				bufferedWritter.flush();
				bufferedWritter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return f;
	}
}
