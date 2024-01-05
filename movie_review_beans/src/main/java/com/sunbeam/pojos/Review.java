package com.sunbeam.pojos;

import java.util.Date;

import java.util.Scanner;

//pojo class of reviews table

public class Review {
	private int id;
	private int movie_id;
	private String review;
	private int rating;
	private int user_id;
	private Date modified;

	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int id, int movie_id, String review, int rating, int user_id, Date modified) 
	{

		this.id = id;
		this.movie_id = movie_id;
		this.review = review;
		this.rating = rating;
		this.user_id = user_id;
		this.modified = modified;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	@Override
	public String toString() {
		return "Reviews [id=" + id + ", movie_id=" + movie_id + ", review=" + review + ", rating=" + rating
				+ ", user_id=" + user_id + ", modified=" + modified + "]";
	}

	Scanner sc = new Scanner(System.in);

	public int accept() {

		System.out.print("Enter movies id = ");
		int x = sc.nextInt();
		setMovie_id(x);
		System.out.print("Enter rating = ");
		x = sc.nextInt();
		setRating(x);
		System.out.print("Enter Review = ");
		sc.nextLine();

		String r = sc.nextLine();
		if (r.length() == 0) {
			System.out.println("Review cannot be empty.");
			return 0;
		}
		int c = r.indexOf(" ");
		if (c == -1) {
			System.out.println("Review cannot be single word.");
			return 0;
		}
		if (c == r.length() - 1) {
			System.out.println("Review is short");
			return 0;
		}
		setReview(r);
		return 1;
	}
}
