package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Administrator extends Model {

	private final String name;
	private final String password;

	public Administrator(String name, String password) {
		this.name = name;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrator [name=" + this.name + ", password=" + this.password + "]";
	}
}
