package com.sunbeam.pojos;

import java.util.Date;

//pojo class of movies table

public class Movie {
	private int id;
	
	private String title;
	private Date release_date;
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	
	
	
	@Override
	public String toString() {
		return "movies [id=" + id + ", title=" + title + ", release_date=" + release_date + "]";
	}
	public Movie(int id, String title, Date release_date) {
		super();
		this.id = id;
		this.title = title;
		this.release_date = release_date;
	}
	
	
}
