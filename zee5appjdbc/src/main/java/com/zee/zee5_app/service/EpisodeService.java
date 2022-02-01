package com.zee.zee5_app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5_app.dto.Episode;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;

public interface EpisodeService {
	
	public String addEpisode(Episode episode);
	public Optional<Episode> getEpisodeById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException;
	public Episode[] getAllEpisode() throws InvalidIdLengthException, InvalidNameException;
	public String modifyEpisode(String id, Episode episode) throws IdNotFoundException;
	public String deleteEpisode(String id) throws IdNotFoundException;
	public Optional<List<Episode>> getAllEpisodeDetails() throws InvalidIdLengthException, InvalidNameException;

}
