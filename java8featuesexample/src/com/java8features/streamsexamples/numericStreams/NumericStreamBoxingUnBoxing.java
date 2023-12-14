package com.java8features.streamsexamples.numericStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamBoxingUnBoxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //converting int to Integer Boxing Demo
		List<Integer> IntegerList=IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
	    System.out.println("IntegerList is"+IntegerList);
	    //UnBoxing Demo :wrapper to primitive
	    List<Integer> IntegerList1= Arrays.asList(1,2,3,4,5,6,7,8);
	    int sum=IntegerList1.stream().mapToInt(Integer::intValue).sum();
	    System.out.println("Sum is"+sum);
	    
	    //map to Obj demo
	    System.out.println("Map to Obj demo is");
	    List<Integer> maptoobj = IntStream.rangeClosed(1, 10).mapToObj(i-> new Integer(i)).collect(Collectors.toList());
	    //map to long stream demo
	    System.out.println("Map to Long STream demo is");
	    ////convert intstream to long stream
	    long maptolongdemo = IntStream.rangeClosed(1, 4)
	    		.mapToLong(i->i).sum(); //similar loogic applies for double
	    System.out.println("Map to long demo is"+maptolongdemo);
	    
	}

}
