package com.sunbeam.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.pojos.Review;
import com.sunbeam.utils.DbUtil;

public class ReviewDaoImpl extends Dao implements ReviewDao, AutoCloseable 
{
	Connection con;

	public ReviewDaoImpl() throws Exception {
		// TODO Auto-generated constructor stub
		try {
			con = DbUtil.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void close() {
		// TODO Auto-generated method stub
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	}
	
	
	
	
//	
//	
//	public ReviewDaoImpl(	int id, int movie_id, String review, int rating, int user_id, Date modified) 
//    {
//	    	
//	}



	//adding new movie reviews
	public int accept(Review r,int id)throws Exception{
		String sql="insert into reviews(movie_id,review,rating,user_id,modified) values(?,?,?,?,now())";
		try(PreparedStatement stmt=con.prepareStatement(sql)){
			stmt.setInt(1, r.getMovie_id());
			stmt.setString(2, r.getReview());
			stmt.setInt(3, r.getRating());
			stmt.setInt(4, id);
			return stmt.executeUpdate();
		}
	}
	
	//Displaying movie reviews
	public List<Review> display() throws Exception {
		String sql = "select * from reviews";
		List<Review> list = new ArrayList<Review>();
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Review q = new Review();
					q.setId(rs.getInt("id"));
					q.setMovie_id(rs.getInt("movie_id"));
					q.setRating(rs.getInt("rating"));
					q.setReview(rs.getString("review"));
					q.setUser_id(rs.getInt("user_id"));
					q.setModified(rs.getDate("modified"));
					list.add(q);
					
				}
			}
		}
		return list;
	}
	
	
	
	//getting logged in user's reviews
	
	public List<Review> myReview(int n) throws Exception{
		String sql = "select * from reviews where user_id = ?";
		List<Review> list = new ArrayList <Review>();
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, n);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Review q = new Review();
					q.setId(rs.getInt("id"));
					q.setMovie_id(rs.getInt("movie_id"));
					q.setRating(rs.getInt("rating"));
					q.setReview(rs.getString("review"));
					q.setUser_id(rs.getInt("user_id"));
					q.setModified(rs.getDate("modified"));
					list.add(q);
					
				}
			}
		}
		return list;
	}
	
	
	//displaying shared reviews of particular user
	public List<Review> mySharedReview(int n,int id) throws Exception{
		String sql = "select * from reviews where user_id = ? and id = ?";
		List<Review> list = new ArrayList<Review>();
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, n);
			stmt.setInt(2, id);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Review q = new Review();
					q.setId(rs.getInt("id"));
					q.setMovie_id(rs.getInt("movie_id"));
					q.setRating(rs.getInt("rating"));
					q.setReview(rs.getString("review"));
					q.setUser_id(rs.getInt("user_id"));
					q.setModified(rs.getDate("modified"));
					list.add(q);
					
				}
			}
		}
		return list;
	}
	
	//displaying all shared reviews
	public List<Review> displaySharedReview(int id) throws Exception{
		String sql="select distinct id,movie_id,review,rating,reviews.user_id,modified from reviews,(select review_id from shares where user_id=?)prime where review_id=id";
		List<Review> rlist = new ArrayList<Review>();
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id);
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()){
					Review r = new Review();
					r.setId(rs.getInt("id"));
					r.setModified(rs.getDate("modified"));
					r.setRating(rs.getInt("rating"));
					r.setMovie_id(rs.getInt("movie_id"));
					r.setReview(rs.getString("review"));
					r.setUser_id(rs.getInt("user_id"));
					rlist.add(r);
				}
			}
		}
		return rlist;
	}
	
	
	
	//Chaitanya 
	public List<Review> findAll() throws Exception {
		List<Review> list = new ArrayList<>();
		String sql = "select * from reviews";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) 
				{
					int id = rs.getInt("id");
					int movie_id = rs.getInt("movie_id");
					String review = rs.getString("review");

					int rating = rs.getInt("rating");
					int user_id = rs.getInt("user_id");
					Date modified = rs.getDate("modified");
		
					Review review_ = new Review(id , movie_id ,review, rating , user_id, modified);
					list.add(review_);
				}
			} // rs.close();
		} // stmt.close();
		return list;
	}
	
	
	//adding new movie reviews
		public int addReview(String movie ,String review ,int rating ,int userid )throws Exception
		{
			int movie_id;
			try(MovieDao movie_=new MovieDaoImpl())
			{
			  movie_id=	movie_.getMovieIdByName(movie);
			  System.out.println("Movie Id"+movie_id);
			}
			String sql="insert into reviews(movie_id,review,rating,user_id,modified) values(?,?,?,?,now())";
			try(PreparedStatement stmt=con.prepareStatement(sql)){
				stmt.setInt(1, movie_id);
				stmt.setString(2, review);
				stmt.setInt(3, rating);
				stmt.setInt(4, userid);
				return stmt.executeUpdate();
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error in adding review as you already given a review for movie");
				return 0;
			}
		}
		
		public List<Review> getSharedReviews(int userid) throws Exception
		{
			
			String sql = " select s.review_id,s.user_id,r.movie_id,r.review,r.rating,r.modified from reviews r,shares s where s.review_id=r.id and r.user_id=?";
			List<Review> list = new ArrayList<Review>();
			try (PreparedStatement stmt = con.prepareStatement(sql)) 
			{
				stmt.setInt(1, userid);
				try (ResultSet rs = stmt.executeQuery())
				{
					while (rs.next())
					{
						Review review_ = new Review();
						
						review_.setId(rs.getInt("review_id"));
						review_.setMovie_id(rs.getInt("movie_id"));
						review_.setReview(rs.getString("review"));
						review_.setRating(rs.getInt("rating"));
						review_.setUser_id(rs.getInt("user_id"));
						review_.setModified(rs.getDate("modified"));
						list.add(review_);
					}
				}
			}
			return list;
			
		}
		
		//deleting reviews
		public int deleteMyReview(int reviewid,int userid) throws Exception
		{
//			String s="select * from reviews where id=? and user_id=?";
//			try(PreparedStatement st=con.prepareStatement(s)){
//				st.setInt(1, id);
//				st.setInt(2, user);
//				try(ResultSet rs=st.executeQuery()){
//					while(rs.next()) {
//						Review q = new Review();
//						q.setId(rs.getInt("id"));
//						q.setMovie_id(rs.getInt("movie_id"));
//						q.setRating(rs.getInt("rating"));
//						q.setReview(rs.getString("review"));
//						q.setUser_id(rs.getInt("user_id"));
//						q.setModified(rs.getDate("modified"));
//						System.out.println(q.toString());
//					}
//				}
//			}
			
			String sql="delete from reviews where id=? and user_id=?";
			try(PreparedStatement stmt=con.prepareStatement(sql)){
				stmt.setInt(1, reviewid);
				stmt.setInt(2, userid);
				return stmt.executeUpdate();	
			}
			
		}
		
		//update movie reviews
		public int update(int reviewid,String review,String rating,int userid) throws Exception{
			String sql="update reviews set review=?,rating=? where id=? and user_id = ?";
			
			try(PreparedStatement stmt=con.prepareStatement(sql))
			{
				stmt.setString(1,review );
				stmt.setString(2,rating );
				stmt.setInt(3,reviewid );
				stmt.setInt(4,userid );
				
				return stmt.executeUpdate();
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error in adding  review as you already added a review ");
				return 0;
			}
		}
		
		public int addSharedReview(int reviewid ,int userid )throws Exception
		{
			
			String sql="insert into shares(review_id,user_id) values(?,?)";
			try(PreparedStatement stmt=con.prepareStatement(sql)){
				stmt.setInt(1, reviewid);
				stmt.setInt(2, userid);
				return stmt.executeUpdate();
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error in adding shared review as you already shared a review to this user");
				return 0;
			}
		}
		


		
	 
}
