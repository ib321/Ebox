package com.ib;

import java.util.Date;

public class Answer2 {
	private int id;
	private String answer;
	private Date postedDate;

	public Answer2() {
	}

	public Answer2(int id, String answer, Date postedDate) {
		super();
		this.id = id;
		this.answer = answer;
		this.postedDate = postedDate;
	}

	public String toString() {
		return "Id:" + id + " Answer:" + answer + " Posted Date:" + postedDate;
	}
}
