package com.zee.zee5_app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5_app.dto.Movie;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;
import com.zee.zee5_app.repository.MovieRepository;
import com.zee.zee5_app.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	private MovieRepository movieRepository;
	public MovieServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepository.addMovie(movie);
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return movieRepository.getMovieById(id);
	}

	@Override
	public Movie[] getAllMovies() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return movieRepository.getAllMovies();
	}

	@Override
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.modifyMovie(id, movie);
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.deleteMovie(id);
	}

	@Override
	public Optional<List<Movie>> getAllMovieDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return movieRepository.getAllMovieDetails();
	}

}
