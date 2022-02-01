package com.zee.zee5_app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.zee5_app.dto.Movie;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;
import com.zee.zee5_app.repository.MovieRepository;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
	
	@Autowired
	private DataSource dataSource;
	public MovieRepositoryImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement;
		String insertStatement = "INSERT INTO movies"
				+ " (movieId, name, ageLimit, cast, genre, length, trailer, releaseDate, language)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, movie.getId());
			preparedStatement.setString(2, movie.getName());
			preparedStatement.setInt(3, movie.getAgeLimit());
			preparedStatement.setString(4, movie.getCast());
			preparedStatement.setString(5, movie.getGenre());
			preparedStatement.setFloat(6, movie.getLength());
			preparedStatement.setString(7, movie.getTrailer());
			preparedStatement.setString(8, movie.getReleaseDate());
			preparedStatement.setString(9, movie.getLanguage());
			
			int result = preparedStatement.executeUpdate();
			
			if(result>0) {
				connection.commit();
				return "Success";
			}
			else {
				connection.rollback();
				return "Fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Fail";
		}
	}
	
	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		
		String selectStatement = "SELECT * FROM movies WHERE movieId=?";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Movie movie = new Movie();
				movie.setId(resultSet.getString("movieId"));
				movie.setName(resultSet.getString("name"));
				movie.setAgeLimit(resultSet.getInt("ageLimit"));
				movie.setCast(resultSet.getString("cast"));
				movie.setGenre(resultSet.getString("genre"));
				movie.setLength(resultSet.getFloat("length"));
				movie.setTrailer(resultSet.getString("trailer"));
				movie.setReleaseDate(resultSet.getString("releaseDate"));
				movie.setLanguage(resultSet.getString("language"));
				return Optional.of(movie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	@Override
	public Movie[] getAllMovies() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Optional<List<Movie>> optional = getAllMovieDetails();
		if(optional.isEmpty())
			return null;
		else {
			List<Movie> list = optional.get();
			Movie[] movies = new Movie[list.size()];
			return list.toArray(movies);
		}
	}
	
	@Override
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement;
		
		String updateStatement = "UPDATE movies"
				+ " SET movieId = ?, name = ?, ageLimit = ?, cast = ?, genre = ?,"
				+ " length = ?, trailer = ?, releaseDate = ?, language = ?"
				+ " WHERE (movieId = ?)";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, movie.getId());
			preparedStatement.setString(2, movie.getName());
			preparedStatement.setInt(3, movie.getAgeLimit());
			preparedStatement.setString(4, movie.getCast());
			preparedStatement.setString(5, movie.getGenre());
			preparedStatement.setFloat(6, movie.getLength());
			preparedStatement.setString(7, movie.getTrailer());
			preparedStatement.setString(8, movie.getReleaseDate());
			preparedStatement.setString(9, movie.getLanguage());
			preparedStatement.setString(10, id);
			
			int result = preparedStatement.executeUpdate();
			
			if(result>0) {
				connection.commit();
				return "Success";
			}
			else {
				connection.rollback();
				return "Fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Fail";
		}
	}
	
	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement;
		
		String deleteStatement = "DELETE FROM movies WHERE movieId=?";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, id);
			
			int result = preparedStatement.executeUpdate();
			
			if(result>0) {
				connection.commit();
				return "Success";
			}
			else {
				connection.rollback();
				return "Fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Fail";
		}
	}
	
	@Override
	public Optional<List<Movie>> getAllMovieDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<Movie> arrayList = new ArrayList<Movie>();
		
		String selectStatement = "SELECT * FROM movies";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movie movie = new Movie();
				movie.setId(resultSet.getString("movieId"));
				movie.setName(resultSet.getString("name"));
				movie.setAgeLimit(resultSet.getInt("ageLimit"));
				movie.setCast(resultSet.getString("cast"));
				movie.setGenre(resultSet.getString("genre"));
				movie.setLength(resultSet.getFloat("length"));
				movie.setTrailer(resultSet.getString("trailer"));
				movie.setReleaseDate(resultSet.getString("releaseDate"));
				movie.setLanguage(resultSet.getString("language"));
				arrayList.add(movie);
			}
			return Optional.ofNullable(arrayList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}

}
