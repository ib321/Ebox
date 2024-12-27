package com.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.domain.Hall;

@Component
public class HallDAO {
	public List<Hall> list() {
    	ArrayList<Hall> hallList = new ArrayList<Hall>();
    	hallList.add(new Hall(1L,"La Centrale Food Hall","Miami","John",750.0));
    	hallList.add(new Hall(2L,"Grand Central Market","Los Angeles","Sandra",1500.0));
    	hallList.add(new Hall(3L,"Great Northern Food Hall","New York","Jack",200.0));
    	hallList.add(new Hall(4L,"Fareground","Austin","Mark",250.0));
		return hallList;
	}
}
