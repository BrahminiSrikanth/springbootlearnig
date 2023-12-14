package com.java8features.streamsexamples.numericStreams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamAggregateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int sum = IntStream.rangeClosed(1, 50).sum();
       System.out.println("Sum is"+sum);
       OptionalInt max = IntStream.rangeClosed(1, 50).max();
       if(max.isPresent()) {
    	   System.out.println("Max value is"+max);
       }
       OptionalLong min =LongStream.rangeClosed(50, 100).min();
       if(min.isPresent()) {
    	   System.out.println("Min Value is"+min);
       }
       //average demo
       OptionalDouble avg=IntStream.rangeClosed(1, 100).average();
       if(avg.isPresent()) {
    	   System.out.println("Average value is"+avg);
       }
       
	}

}
