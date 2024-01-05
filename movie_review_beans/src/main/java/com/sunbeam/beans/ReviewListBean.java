package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.ReviewDao;
import com.sunbeam.daos.ReviewDaoImpl;
import com.sunbeam.pojos.Review;
import com.sunbeam.pojos.User;

public class ReviewListBean {

	private int currUser;
	private String type;
	private String reviewTitle;

	private List<Review> reviewList;

	public ReviewListBean() {
	}

	

	public int getCurrUser() {
		return currUser;
	}



	public void setCurrUser(int currUser) {
		this.currUser = currUser;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getReviewTitle() {
		return reviewTitle;
	}



	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}



	public List<Review> getReviewList() {
		return reviewList;
	}



	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}



	public void fetchReviews() {

		try (ReviewDao reviewDao = new ReviewDaoImpl()) {

			if (type == null || type.equals("allreviews")) 
			{
				reviewList = reviewDao.findAll();
				System.out.println("allreviews reviewList"+reviewList);
				reviewTitle = "All Reviews";
			} else if (type.equals("myreviews")) {
				System.out.println("*****"+currUser);
				reviewList = reviewDao.myReview(currUser);
				System.out.println("myreviews reviewList"+reviewList);
				reviewTitle = "My Reviews";
			} else if (type.equals("sharedreviews")) {
				reviewList = reviewDao.getSharedReviews(currUser);
				System.out.println("sharedreviews reviewList"+reviewList);
				reviewTitle = "Shared Reviews";
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
}
