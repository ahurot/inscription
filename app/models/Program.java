package models;

import java.util.Date;

import play.modules.morphia.Model;

import com.google.code.morphia.annotations.Entity;


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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Program [begin=");
		builder.append(begin);
		builder.append(", end=");
		builder.append(end);
		builder.append(", title=");
		builder.append(title);
		builder.append(", detail=");
		builder.append(detail);
		builder.append(", author=");
		builder.append(author);
		builder.append(", location=");
		builder.append(location);
		builder.append("]");
		return builder.toString();
	}
}