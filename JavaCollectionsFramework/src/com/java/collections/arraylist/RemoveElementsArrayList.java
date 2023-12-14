package com.java.collections.arraylist;

import java.util.ArrayList;
import java.util.List;

public class RemoveElementsArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> fruits =new ArrayList<>();
		fruits.add("Banana");
		fruits.add("apple");
		fruits.add("Mango");
		fruits.add("Orange");
		fruits.add("Grapes");
		fruits.add("Pears");
		fruits.add("WaterMelon");
		fruits.add("RockMelon");
		System.out.println("Fruits List is"+fruits);
		//demo of remove using Object o
		fruits.remove("Pears");
		System.out.println("Fruits List after removal of pears is"+fruits);
	//demo of remove using index
		fruits.remove(4);
		System.out.println("Fruits List after removal of index 4 is"+fruits);
		
		//demo of removeall
		List<String> Melonfruits =new ArrayList<>();
		Melonfruits.add("WaterMelon");
		Melonfruits.add("RockMelon");
		fruits.removeAll(Melonfruits);
		System.out.println("Fruits List after removal of MelonFruits is"+fruits);
		
		//demo of clear
		fruits.clear();
		System.out.println("Fruits List after clear()"+fruits);
	}

}
