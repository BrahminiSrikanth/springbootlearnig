package com.java8features.functionalinterfaceexamples.function;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
	
	static UnaryOperator<String> unop =(s) -> s.concat("Default");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(unop.apply("Java8 -"));
	}

}
