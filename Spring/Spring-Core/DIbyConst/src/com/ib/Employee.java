package com.ib;

public class Employee {
	private int id;
	private String name;

	private Address address;// object of class Address

	public Employee() {
		System.out.println("def cons of Employee");
	}

	public Employee(int id) {
		this.id = id;
	}

	public Employee(String name) {
		this.name = name;
	}

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Employee(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	void show() {
		System.out.println("--Inside Show--");
		System.out.println(id + " " + name);
	}

	void show2() {
		System.out.println("--Inside Show2--");
		System.out.println(id + " " + name);
		System.out.println(address.toString());
	}

}
