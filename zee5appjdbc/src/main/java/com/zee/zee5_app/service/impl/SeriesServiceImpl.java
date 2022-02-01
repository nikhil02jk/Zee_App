package com.zee.zee5_app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5_app.dto.Series;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;
import com.zee.zee5_app.repository.SeriesRepository;
import com.zee.zee5_app.service.SeriesService;

@Service
public class SeriesServiceImpl implements SeriesService {
	
	private SeriesRepository seriesRepository;
	public SeriesServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		return seriesRepository.addSeries(series);
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return seriesRepository.getSeriesById(id);
	}

	@Override
	public Series[] getAllSeries() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return seriesRepository.getAllSeries();
	}

	@Override
	public String modifySeries(String id, Series series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.modifySeries(id, series);
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.deleteSeries(id);
	}

	@Override
	public Optional<List<Series>> getAllSeriesDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return seriesRepository.getAllSeriesDetails();
	}

}
