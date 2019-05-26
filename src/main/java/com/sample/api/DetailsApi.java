package com.sample.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/details")
public class DetailsApi {
	
	@GET
	@Path("{personId}")
	@Produces("application/json")
	public String getDetails(@PathParam("personId") int id) {
		String result = "shit";
		if (id == 2) {
			result = "you got it";
		}
		return result;
	}
	
}
