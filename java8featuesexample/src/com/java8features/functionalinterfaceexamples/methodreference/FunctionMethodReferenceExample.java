package com.java8features.functionalinterfaceexamples.methodreference;

import java.util.function.Function;

public class FunctionMethodReferenceExample {

	static Function<String,String> lambdref = (s) -> s.toUpperCase();
	static Function<String,String> methodRef = String::toUpperCase;
	public static void main(String[] args) {
     System.out.println("Using Lambda Ref"+lambdref.apply("lambda expression"));
     System.out.println("Using Method Ref is"+methodRef.apply("using Method Reference"));

	}

}
