package com.springboot.workers.crudapi.model;

import java.sql.Date;

public class Title {
	private int workerRefId;
	private String workerTitle;
	private Date affectedFrom;
	
	
	public Title() {
		super();
	}
	public Title(int workerRefId, String workerTitle, Date affectedFrom) {
		super();
		this.workerRefId = workerRefId;
		this.workerTitle = workerTitle;
		this.affectedFrom = affectedFrom;
	}
	public int getWorkerRefId() {
		return workerRefId;
	}
	public void setWorkerRefId(int workerRefId) {
		this.workerRefId = workerRefId;
	}
	public String getWorkerTitle() {
		return workerTitle;
	}
	public void setWorkerTitle(String workerTitle) {
		this.workerTitle = workerTitle;
	}
	public Date getAffectedFrom() {
		return affectedFrom;
	}
	public void setAffectedFrom(Date affectedFrom) {
		this.affectedFrom = affectedFrom;
	}
	@Override
	public String toString() {
		return "Title [workerRefId=" + workerRefId + ", workerTitle=" + workerTitle + ", affectedFrom=" + affectedFrom
				+ "]";
	}
	
}
