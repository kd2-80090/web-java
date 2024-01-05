package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.pojos.Movie;

public interface MovieDao extends AutoCloseable {
   
	public void close() throws Exception ;
	public String getMovie(int movie_id) throws Exception;
	public List<Movie> displayAll() throws Exception;
	public int getMovieIdByName(String movie) throws Exception;

	

}
