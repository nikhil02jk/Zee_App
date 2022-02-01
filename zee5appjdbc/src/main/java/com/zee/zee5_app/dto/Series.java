package com.zee.zee5_app.dto;

import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Series implements Comparable<Series> {
	
	public Series(String id, String name, int ageLimit, String trailer, String cast, String genre, float length,
			String releaseDate, String language, int noOfEpisodes) throws InvalidIdLengthException, InvalidNameException {
		super();
		this.setId(id);
		this.setName(name);
		this.ageLimit = ageLimit;
		this.trailer = trailer;
		this.cast = cast;
		this.genre = genre;
		this.length = length;
		this.releaseDate = releaseDate;
		this.language = language;
		this.noOfEpisodes = noOfEpisodes;
	}

	@Setter(value = AccessLevel.NONE)
	private String id;
	@Setter(value = AccessLevel.NONE)
	private String name;
	private int ageLimit;
	private String trailer;
	private String cast;
	private String genre;
	private float length;
	private String releaseDate;
	private String language;
	private int noOfEpisodes;
	
	public void setId(String id) throws InvalidIdLengthException {
		if(id.length()<6) {
			throw new InvalidIdLengthException("id length is less than 6");
		}
		this.id = id;
	}
	
	public void setName(String name) throws InvalidNameException {
		if(name==null || name=="" || name.length()<2)
			throw new InvalidNameException("name is not valid");
		this.name = name;
	}
	
	@Override
	public int compareTo(Series o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

}
