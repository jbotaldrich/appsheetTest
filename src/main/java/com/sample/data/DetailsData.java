package com.sample.data;

import lombok.Data;

@Data
public class DetailsData implements IdData{

	private int id;
	private String name;
	private int age;
	private String phoneNumber;
	private String photo;
	private String bio;
	private String token;
	 
	
}
