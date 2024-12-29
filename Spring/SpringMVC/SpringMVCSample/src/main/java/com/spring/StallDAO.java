package com.spring;

import java.util.ArrayList;

public class StallDAO {
	
	public StallDAO() {}
	
	ArrayList<Stall> stallList;

	public  ArrayList<Stall> returnList(){
		stallList = new ArrayList<>();
		stallList.add(new Stall("FS","Extolls about the free softwares","Manickam","9878906781"));
		stallList.add(new Stall("Mobile Mela","Old mobile models and newer one in the market - Combo offer!","Mani","9878806781"));
		stallList.add(new Stall("Behavioural Cognition","Extolls about the relationship between behaviour and cognition","Vinayak","9809906781"));
		return stallList;
	}
}
