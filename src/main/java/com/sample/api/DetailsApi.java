package com.sample.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.sample.exceptions.NotFoundException;
import com.sample.manager.ApplicationManager;

import lombok.RequiredArgsConstructor;

@Path("/details")
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class DetailsApi {
	
	private final ApplicationManager manager;
	
	@GET
	@Path("{personId}")
	@Produces("application/json")
	public String getDetails(@PathParam("personId") int id) throws NotFoundException {
		return manager.getDetails(id);
	}
	
}
