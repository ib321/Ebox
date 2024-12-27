package com.ib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class Question3 {
	private int id;
	private String name;
	private HashMap<Answer2, User> answers;

	public Question3() {
	}

	public Question3(int id,String name, HashMap<Answer2, User> answers) {
		super();
		this.id = id;
		this.name = name;
		this.answers = answers;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<Answer2, User> getAnswers() {
		return answers;
	}

	public void setAnswers(HashMap<Answer2, User> answers) {
		this.answers = answers;
	}

	public void displayInfo3() {
		System.out.println("question id:" + id);
		System.out.println("question name:" + name);
		System.out.println("Answers....");
		Set<Entry<Answer2, User>> set = answers.entrySet();
		Iterator<Entry<Answer2, User>> itr = set.iterator();
		while (itr.hasNext()) {
			Entry<Answer2, User> entry = itr.next();
			Answer2 ans = entry.getKey();
			User user = entry.getValue();
			System.out.println("Answer Information:");
			System.out.println(ans);
			System.out.println("Posted By:");
			System.out.println(user);
		}
	}
}
