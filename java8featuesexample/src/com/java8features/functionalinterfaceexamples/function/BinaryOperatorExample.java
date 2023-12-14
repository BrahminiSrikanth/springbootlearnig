package com.java8features.functionalinterfaceexamples.function;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

	static Comparator<Integer> comparator = (a,b) -> a.compareTo(b);
	public static void main(String[] args) {
		BinaryOperator<Integer> bop =(a,b) -> a*b;
		System.out.println(bop.apply(20, 30));

		//maxby demo
		BinaryOperator<Integer> maxby = BinaryOperator.maxBy(comparator);
		System.out.println("Result of maxby is"+maxby.apply(20, 30));
		//minBy demo
		BinaryOperator<Integer> minby = BinaryOperator.minBy(comparator);
		System.out.println("Result of minby is"+minby.apply(20, 30));
	}

}
