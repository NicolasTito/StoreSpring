package com.nide_mel.store.store.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer	status;
	private String	msg;
	private Long	timeStamp;


	public StandardError(Integer status, String msg, Long timeStamp) {
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}


	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public StandardError status(Integer status) {
		setStatus(status);
		return this;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public StandardError msg(String msg) {
		setMsg(msg);
		return this;
	}

	public Long getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public StandardError timeStamp(Long timeStamp) {
		setTimeStamp(timeStamp);
		return this;
	}

}
