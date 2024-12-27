package com.ib;

import java.util.Iterator;
import java.util.List;

public class Question2 {
	private int id;
	private String name;
	private List<Answer> answers2;

	public Question2() {
	}

	public Question2(int id, String name, List<Answer> answers2) {
		super();
		this.id = id;
		this.name = name;
		this.answers2 = answers2;
	}

	public void displayInfo2() {
		System.out.println(id + " " + name);
		System.out.println("answers are:");
		Iterator<Answer> itr = answers2.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
