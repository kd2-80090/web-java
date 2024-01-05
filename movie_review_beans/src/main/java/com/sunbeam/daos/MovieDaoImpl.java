package com.sunbeam.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojos.Movie;
import com.sunbeam.utils.DbUtil;

public class MovieDaoImpl implements MovieDao,AutoCloseable{
	Connection con;
	public MovieDaoImpl() {
		// TODO Auto-generated constructor stub
		try {
			con=DbUtil.getConnection();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		if(con!=null) {
			con.close();
		}	
	}
	 
	public String getMovie(int movie_id) throws Exception
	{
		String sql="select * from movies where id= ?";
		String movie_title=null;
		try(PreparedStatement stmt=con.prepareStatement(sql)){
			stmt.setInt(1, movie_id);
			try(ResultSet rs=stmt.executeQuery()){
				while(rs.next()) 
				{
					movie_title =rs.getString("title");
				}
			}
		}
		
		return movie_title;
		
	}
	public int getMovieIdByName(String movie) throws Exception
	{
		String sql="select id from movies where title= ?";
		int id=0;
		try(PreparedStatement stmt=con.prepareStatement(sql)){
			stmt.setString(1, movie);
			try(ResultSet rs=stmt.executeQuery()){
				while(rs.next()) 
				{
					id=rs.getInt("id");
				}
				
			}
		}
		return id;	
		
	}
	
//	
//	public int getUnreviewdMovieIdByName(String movie) throws Exception
//	{
//		String sql="select distinct m.id from reviews,movies m where reviews.movie_id !=m.id and title= ?";
//		int id=0;
//		try(PreparedStatement stmt=con.prepareStatement(sql)){
//			stmt.setString(1, movie);
//			try(ResultSet rs=stmt.executeQuery()){
//				while(rs.next()) 
//				{
//					id=rs.getInt("id");
//				}
//				
//			}
//		}
//		return id;	
//		
//	}
	
	//displaying all Movie
	public List<Movie> displayAll() throws Exception{
		String sql="select * from movies";
		List<Movie> list=new ArrayList<Movie>();
		try(PreparedStatement stmt=con.prepareStatement(sql)){
			try(ResultSet rs=stmt.executeQuery()){
				while(rs.next()) {
					Movie q=new Movie();
					q.setId(rs.getInt("id"));
					q.setTitle(rs.getString("title"));
					q.setRelease_date(rs.getDate("rel_date"));
					list.add(q);
				}
			}
		}
		return list;
	}
	
}

