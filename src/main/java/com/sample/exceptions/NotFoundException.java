package com.sample.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class NotFoundException extends WebApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5268000035610352116L;


	public NotFoundException(String msg) {
	       super(Response.status(Response.Status.BAD_REQUEST)
	               .entity(msg).type(MediaType.TEXT_PLAIN).build());
	       
	}




}
