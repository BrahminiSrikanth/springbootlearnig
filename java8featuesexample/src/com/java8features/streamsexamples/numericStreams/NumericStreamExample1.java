package com.java8features.streamsexamples.numericStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8);
		int sum_n = integerList.stream().reduce(0,(x,y)->x+y);//performs unboxing operation to convert integer to int
		System.out.println("Sum of n numbers using reduce op is"+sum_n);
		int sum_i = IntStream.rangeClosed(1, 8).sum();
		System.out.println("Sum of n numbers using Intstream is "+sum_i);

	}

}
