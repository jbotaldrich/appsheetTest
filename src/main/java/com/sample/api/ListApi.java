package com.sample.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.sample.exceptions.NotFoundException;
import com.sample.manager.ApplicationManager;

import lombok.RequiredArgsConstructor;



@Path("/list")
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class ListApi {

	private final ApplicationManager manager;
	
	@GET
	@Produces("application/json")
	public String listPeople(@QueryParam("token") String token) throws NotFoundException {
		return manager.listIds(token);
	}

	
}
