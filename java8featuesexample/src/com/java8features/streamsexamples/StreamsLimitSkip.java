package com.java8features.streamsexamples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> IntegerList= Arrays.asList(1,2,3,4,5,6,7,8,9);
        Optional<Integer> limitstreamdemo= IntegerList.stream()
        		                            .limit(2)
        		                           .reduce((x,y)->(x+y));
        //limit operation
        System.out.println(limitstreamdemo.get());
        
        //skip operation
        Optional<Integer> skipstreamdemo = IntegerList.stream().skip(3).reduce((x,y)->x+y);
        System.out.println("Value using skip operation is"+skipstreamdemo.get());
	} 
	

}
