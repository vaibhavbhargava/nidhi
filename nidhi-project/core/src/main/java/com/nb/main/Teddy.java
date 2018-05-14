package com.nb.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Teddy {

	public static void main(String[] args) {
	
		MyModel m1 = new MyModel();
		m1.setStr1("vaibhav");
		m1.setX(2);
		
		MyModel m2 = new MyModel();
		m2.setStr1("vaibhav");
		m2.setX(2);
		
		Set<MyModel> set = new HashSet<MyModel>();
		List<MyModel>  list= new ArrayList<MyModel>();
		
		set.add(m1);
		set.add(m2);
		list.add(m1);
		list.add(m2);
		
		System.out.println(set);
		System.out.println(list);
	
	}

}
