package com.java8features.functionalinterfaceexamples.predicate;

import java.util.function.Predicate;

public class PredicateDemo {

	public static Predicate<Integer> p1 = (i) -> i%2==0;
	public static Predicate<Integer> p2 = (i) -> i%5==0;
	public static void main(String[] args) {
		System.out.println(p1.test(10));
		System.out.println(p2.test(25));
		testAndPredicate(100);
		testOrPredicate(4);
		testnegatePredicate(20);
		

	}
	public static void testAndPredicate(Integer i) {
		//p1.and(p2).test(i);
		System.out.println("Testing And Predicate is"+p1.and(p2).test(i));
	}
	public static void testOrPredicate(Integer i) {
		System.out.println("Testing Or Predicate is"+p1.or(p2).test(i));
	}
	public static void testnegatePredicate(Integer i) {
		System.out.println("Testing Negate Predicate is"+p1.and(p2).negate().test(i));
	}
	

}
