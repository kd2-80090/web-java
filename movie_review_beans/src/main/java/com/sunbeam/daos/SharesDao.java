package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.pojos.Review;

public interface SharesDao extends AutoCloseable
 {
	public void add(int rid,int uid) throws Exception ;
	public void delete(int rid) throws Exception;


	
	public List<Review> getSharedReviews() throws Exception;

}
