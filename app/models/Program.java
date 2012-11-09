package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

@Entity
public class Program extends Model {

	private final Date begin;
	private final Date end;

	private final String title;
	private final String detail;
	private final String author;
	private final String location;

	public Program(Date begin, Date end, String title, String detail, String author, String location) {
		this.begin = begin;
		this.end = end;
		this.title = title;
		this.detail = detail;
		this.author = author;
		this.location = location;

	}
}