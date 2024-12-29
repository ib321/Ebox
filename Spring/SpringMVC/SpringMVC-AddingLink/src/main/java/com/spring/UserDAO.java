package com.spring;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class UserDAO {
	
	User user=new User();
	
	
	public User getUser() {
		return user;
	}

    @Autowired
	public void setUser(User user) {
		this.user = user;
	}
    
    ArrayList<User> userList=new ArrayList<User>();

	public  ArrayList<User> returnList(){
		if(true) {
			user=new User();
			user.setId(1);
			user.setUserName("Adhithya");
			user.setPassword("adhithya");
			user.setEmailId("adhi@gmail.com");
			user.setPhoneNumber("9874563210");
			user.setLine1("Kattoor road");
			user.setLine2("PN Palayam");
			user.setCity("Coimbatore");
			user.setPincode("64123");
			
			userList.add(user);
			user=new User();
			user.setId(2);
			user.setUserName("Aakash");
			user.setPassword("aakash");
			user.setEmailId("akash@gmail.com");
			user.setPhoneNumber("9874554210");
			user.setLine1("K.R road");
			user.setLine2("Rolls Nagar");
			user.setCity("Coimbatore");
			user.setPincode("64123");
			userList.add(user);
			user=new User();
			user.setId(3);
			user.setUserName("Aniruth");
			user.setPassword("aniruth");
			user.setEmailId("aniruth@gmail.com");
			user.setPhoneNumber("9872223210");
			user.setLine1("33rd Street");
			user.setLine2("Nagar");
			user.setCity("Chennai");
			user.setPincode("64123");
			userList.add(user);
			user=new User();
			user.setUserName("Aravinth");
			user.setPassword("aravinth");
			user.setEmailId("aravinth@gmail.com");
			user.setPhoneNumber("9874563210");
			user.setLine1("23rd Street");
			user.setLine2("Balaji Nagar");
			user.setCity("Chennai");
			user.setPincode("64123");
			userList.add(user);
			user=new User();
			user.setUserName("Amith");
			user.setPassword("amith");
			user.setEmailId("amith@gmail.com");
			user.setPhoneNumber("9874563210");
			user.setLine1("23rd Street");
			user.setLine2("Bala Nagar");
			user.setCity("Avadi");
			user.setPincode("64123");
			userList.add(user);
			user=new User();
			user.setUserName("Raghul");
			user.setPassword("raghul");
			user.setEmailId("raghul@gmail.com");
			user.setPhoneNumber("98745673210");
			user.setLine1("22nd Street");
			user.setLine2("Rose Colony");
			user.setCity("Avadi");
			user.setPincode("64123");
			userList.add(user);
			user=new User();
			user.setUserName("Rangan");
			user.setPassword("rangan");
			user.setEmailId("rangu@gmail.com");
			user.setPhoneNumber("98705673210");
			user.setLine1("21st Street");
			user.setLine2("Base Colony");
			user.setCity("Avadi");
			user.setPincode("64123");
			userList.add(user);
		}
		return userList;
	}
	

}
