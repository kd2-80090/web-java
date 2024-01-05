package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.pojos.Review;

public interface ReviewDao extends AutoCloseable {
	 
	void close() throws Exception ;


	 int accept(Review r,int id)throws Exception;

	 List<Review> display() throws Exception ;

	 List<Review> myReview(int n) throws Exception;

	 List<Review> mySharedReview(int n ,int id) throws Exception;

	 List<Review> displaySharedReview(int id) throws Exception;

	
	 
	 //chaitanya
	public List<Review> findAll() throws Exception ;

	public int addReview(String movie ,String review ,int rating ,int userid )throws Exception;
	
	public List<Review> getSharedReviews(int userid) throws Exception;

	int deleteMyReview(int id,int user) throws Exception;
	
	public int update(int reviewid,String review,String rating,int userid) throws Exception;

	public int addSharedReview(int reviewid ,int userid )throws Exception;
		
				
}
