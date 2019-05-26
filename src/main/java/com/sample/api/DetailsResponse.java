package com.sample.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailsResponse {

	private int id;
	private String name;
	private int age;
	private String phoneNumber;
	private String image;
	private String bio;
	
	
}
