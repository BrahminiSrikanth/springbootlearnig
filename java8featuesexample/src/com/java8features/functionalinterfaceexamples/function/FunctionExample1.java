package com.java8features.functionalinterfaceexamples.function;

public class FunctionExample1 {
	public static String performConcat(String str) {
		return FunctionExample.addsomeString.apply("Hello Function");
		
	}

	public static void main(String[] args) {
		String result =performConcat("Hello");
		System.out.println("result is  "+result);

	}

}
