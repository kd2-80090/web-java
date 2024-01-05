package com.sunbeam.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunbeam.pojos.Review;
import com.sunbeam.utils.DbUtil;

public class SharesDaoImpl implements AutoCloseable {
	Connection con;

	public SharesDaoImpl() {
		// TODO Auto-generated constructor stub
		try {
			con = DbUtil.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		if (con != null)
			con.close();
	}

	//adding shared reviews to the desired users
	public void add(int rid,int uid) throws Exception {
		String sql = "insert into shares values(?,?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, rid);
			stmt.setInt(2, uid);
			stmt.executeUpdate();
		}
	}
	
	//deleting shared reviews
	public void delete(int rid) throws Exception{
		String sql = "delete from shares where review_id = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, rid);
		
			stmt.executeUpdate();
		}
	}
	
	public List<Review> getSharedReviews() throws Exception
	{
		
		String sql = "select r.* from reviews r,shares s where s.review_id=r.id ";
		List<Review> list = new ArrayList<Review>();
		try (PreparedStatement stmt = con.prepareStatement(sql)) 
		{
			try (ResultSet rs = stmt.executeQuery())
			{
				while (rs.next())
				{
					Review review_ = new Review();
					
					review_.setId(rs.getInt("id"));
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
	
}
