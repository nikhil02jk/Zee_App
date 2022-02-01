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

import com.zee.zee5_app.dto.Series;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;
import com.zee.zee5_app.repository.SeriesRepository;

@Repository
public class SeriesRepositoryImpl implements SeriesRepository {
	
	@Autowired
	private DataSource dataSource;
	public SeriesRepositoryImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement;
		
		String insertStatement = "INSERT INTO series"
				+ " (seriesId, name, ageLimit, trailer, cast, genre, length, releaseDate, language, noOfEpisodes)"
				+ " VALUES (?, ?, ?, null, ?, ?, ?, ?, ?, ?)";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, series.getId());
			preparedStatement.setString(2, series.getName());
			preparedStatement.setInt(3, series.getAgeLimit());
			preparedStatement.setString(4, series.getCast());
			preparedStatement.setString(5, series.getGenre());
			preparedStatement.setFloat(6, series.getLength());
			preparedStatement.setString(7, series.getReleaseDate());
			preparedStatement.setString(8, series.getLanguage());
			preparedStatement.setInt(9, series.getNoOfEpisodes());
			
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
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		
		String selectStatement = "SELECT * FROM series WHERE seriesId=?";
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
				Series series = new Series();
				series.setId(resultSet.getString("seriesId"));
				series.setName(resultSet.getString("name"));
				series.setAgeLimit(resultSet.getInt("ageLimit"));
				series.setCast(resultSet.getString("cast"));
				series.setGenre(resultSet.getString("genre"));
				series.setLength(resultSet.getFloat("length"));
				series.setReleaseDate(resultSet.getString("releaseDate"));
				series.setLanguage(resultSet.getString("language"));
				series.setNoOfEpisodes(resultSet.getInt("noOfEpisodes"));
				return Optional.of(series);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	@Override
	public Series[] getAllSeries() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Optional<List<Series>> optional = getAllSeriesDetails();
		if(optional.isEmpty())
			return null;
		else {
			List<Series> list = optional.get();
			Series[] series = new Series[list.size()];
			return list.toArray(series);
		}
	}
	
	@Override
	public String modifySeries(String id, Series series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement;
		
		String updateStatement = "UPDATE series"
				+ " SET seriesId = ?, name = ?, ageLimit = ?, cast = ?, genre = ?,"
				+ " length = ?, releaseDate = ?, language = ?, noOfEpisodes = ?"
				+ " WHERE (seriesId = ?)";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, series.getId());
			preparedStatement.setString(2, series.getName());
			preparedStatement.setInt(3, series.getAgeLimit());
			preparedStatement.setString(4, series.getCast());
			preparedStatement.setString(5, series.getGenre());
			preparedStatement.setFloat(6, series.getLength());
			preparedStatement.setString(7, series.getReleaseDate());
			preparedStatement.setString(8, series.getLanguage());
			preparedStatement.setInt(9, series.getNoOfEpisodes());
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
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement;
		
		String deleteStatement = "DELETE FROM series WHERE seriesId=?";
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
	public Optional<List<Series>> getAllSeriesDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<Series> arrayList = new ArrayList<Series>();
		
		String selectStatement = "SELECT * FROM series";
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
				Series series = new Series();
				series.setId(resultSet.getString("seriesId"));
				series.setName(resultSet.getString("name"));
				series.setAgeLimit(resultSet.getInt("ageLimit"));
				series.setCast(resultSet.getString("cast"));
				series.setGenre(resultSet.getString("genre"));
				series.setLength(resultSet.getFloat("length"));
				series.setReleaseDate(resultSet.getString("releaseDate"));
				series.setLanguage(resultSet.getString("language"));
				series.setNoOfEpisodes(resultSet.getInt("noOfEpisodes"));
				arrayList.add(series);
			}
			return Optional.ofNullable(arrayList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}

}
