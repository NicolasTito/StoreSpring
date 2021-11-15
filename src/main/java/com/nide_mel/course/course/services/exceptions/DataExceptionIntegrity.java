package com.nide_mel.course.course.services.exceptions;

public class DataExceptionIntegrity extends RuntimeException{
	private static final long serialVersionUID = 1l;

	public DataExceptionIntegrity(String msg){
		super(msg);
	}

	public DataExceptionIntegrity(String msg, Throwable cause){
		super(msg, cause);
	}
}
