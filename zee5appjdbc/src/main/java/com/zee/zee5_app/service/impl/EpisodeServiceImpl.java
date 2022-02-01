package com.zee.zee5_app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5_app.dto.Episode;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;
import com.zee.zee5_app.repository.EpisodeRepository;
import com.zee.zee5_app.service.EpisodeService;

@Service
public class EpisodeServiceImpl implements EpisodeService {
	
	private EpisodeRepository episodeRepository;
	public  EpisodeServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addEpisode(Episode episode) {
		// TODO Auto-generated method stub
		return episodeRepository.addEpisode(episode);
	}

	@Override
	public Optional<Episode> getEpisodeById(String id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return episodeRepository.getEpisodeById(id);
	}

	@Override
	public Episode[] getAllEpisode() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifyEpisode(String id, Episode episode) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return episodeRepository.modifyEpisode(id, episode);
	}

	@Override
	public String deleteEpisode(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return episodeRepository.deleteEpisode(id);
	}

	@Override
	public Optional<List<Episode>> getAllEpisodeDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return episodeRepository.getAllEpisodeDetails();
	}

}
