package com.zee.zee5_app.repository;

import java.util.List;
import java.util.Optional;

import com.zee.zee5_app.dto.Series;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;

public interface SeriesRepository {
	
	public String addSeries(Series series);
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException;
	public Series[] getAllSeries() throws InvalidIdLengthException, InvalidNameException;
	public String modifySeries(String id, Series series) throws IdNotFoundException;
	public String deleteSeries(String id) throws IdNotFoundException;
	public Optional<List<Series>> getAllSeriesDetails() throws InvalidIdLengthException, InvalidNameException;

}
