package com.zee.zee5_app.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Episode implements Comparable<Episode> {
	
	public Episode(String id, String serId, String name, float length, String location, String trailer) {
		super();
		this.id = id;
		this.serId = serId;
		this.name = name;
		this.length = length;
		this.location = location;
		this.trailer = trailer;
	}

	private String id;
	private String serId;
	private String name;
	private float length;
	private String location;
	private String trailer;
	
	@Override
	public int compareTo(Episode o) {
		// TODO Auto-generated method stub
		return o.id.compareTo(this.getId());
	}

}
