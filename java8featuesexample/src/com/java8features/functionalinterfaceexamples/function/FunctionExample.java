package com.java8features.functionalinterfaceexamples.function;

import java.util.function.Function;

public class FunctionExample {
	static Function<String,String> function = (name) -> name.toUpperCase();
	static Function<String,String> addsomeString = (name) -> name.toLowerCase().concat("default");
	public static void main(String[] args) {
		System.out.println("Result is"+function.apply("Java8"));
		System.out.println("Result of and then is "+function.andThen(addsomeString).apply("Welcome to Java8"));
		System.out.println("Result of compose is "+function.compose(addsomeString).apply("Welcome to Java8"));
	}

}
