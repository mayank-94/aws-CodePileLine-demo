package com.spring.boot.todo.mytodoapp.exception;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class ErrorResponse {
	
	private String message;
	private String Description;
	private int code;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private Date timeStamp;
	
	public ErrorResponse() {
		super();
	}
	
	public ErrorResponse(String message, String description, int code, Date timeStamp) {
		super();
		this.message = message;
		Description = description;
		this.code = code;
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", Description=" + Description + ", code=" + code + ", timeStamp="
				+ timeStamp + "]";
	}
}
