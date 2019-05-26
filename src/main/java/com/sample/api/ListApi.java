package com.sample.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



@Path("/list")
public class ListApi {

	private static final Gson gson = new GsonBuilder().create();
	
	
	@GET
	@Produces("application/json")
	public String listPeople(@QueryParam("token") String token) {
		ListResponse response;
		if (null == token) {
			response = ListResponse.builder().result(ImmutableList.of(1,2,3,4,5,6,7)).token("abcd").build();
		}else {
			response = ListResponse.builder().result(ImmutableList.of(1,2,3,7)).build();
		}
		return gson.toJson(response);
	}

	
}
