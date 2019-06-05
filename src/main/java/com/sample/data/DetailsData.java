package com.sample.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailsData implements IdData, Comparable<DetailsData>{

	private int id;
	private String name;
	private int age;
	private String phoneNumber;
	private String photo;
	private String bio;
	private String token;
	@Override
	public int compareTo(DetailsData o) {
		if (this.id < o.id) {
			return -1;
		} else if (this.id == o.id) {
			return 0;
		} else {
			return 1;
		}
	} 
	
}
