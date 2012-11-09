package models;

import javax.persistence.Entity;

import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class User extends Model {

	@Required
	public String name;
	@Required
	public String firstName;
	@Required
	public String phoneNumber;
	@Required
	@Email
	public String mail;
	public boolean isPresent;
	public String comment;
	

	public User(String name, String firstName, String phoneNumber, String mail, String comment) {
		this.name = name;
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
		this.mail = mail;
		this.comment = comment;
		this.isPresent = true;
	}

	@Override
	public String toString() {
		return this.name + ';' + this.firstName + ';' + this.phoneNumber + ';' + this.mail + ';' + this.comment + ';' + this.isPresent;
	}
}
