package com.sample.data;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class NotFoundException extends Exception implements ExceptionMapper<NotFoundException> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5268000035610352116L;

	public NotFoundException() {
		super();
	}

	public NotFoundException(String msg) {
		super(msg);
	}

	public NotFoundException(String msg, Exception cause) {
		super(msg, cause);
	}

	@Override
	public Response toResponse(NotFoundException exception) {
		return Response.status(400).entity(exception.getMessage()).type("text/plain").build();
	}

}
