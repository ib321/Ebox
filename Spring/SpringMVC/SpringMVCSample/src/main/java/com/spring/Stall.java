package com.spring;

public class Stall {
	String stallName;
	String stallDetails;
	String stallOwner;
	String ownerContact;

	public Stall() {
		super();
	}

	public Stall(String stallName, String stallDetails, String stallOwner, String ownerContact) {
		this.stallName = stallName;
		this.stallDetails = stallDetails;
		this.stallOwner = stallOwner;
		this.ownerContact = ownerContact;
	}

	public String getStallName() {
		return stallName;
	}

	public void setStallName(String stallName) {
		this.stallName = stallName;
	}

	public String getStallDetails() {
		return stallDetails;
	}

	public void setStallDetails(String stallDetails) {
		this.stallDetails = stallDetails;
	}

	public String getStallOwner() {
		return stallOwner;
	}

	public void setStallOwner(String stallOwner) {
		this.stallOwner = stallOwner;
	}

	public String getOwnerContact() {
		return ownerContact;
	}

	public void setOwnerContact(String ownerContact) {
		this.ownerContact = ownerContact;
	}

}
