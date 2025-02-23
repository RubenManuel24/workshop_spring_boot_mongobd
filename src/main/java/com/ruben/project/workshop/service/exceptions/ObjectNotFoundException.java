package com.ruben.project.workshop.service.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    public ObjectNotFoundException(String obj) {
    	super(obj);
    }

}
