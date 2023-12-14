package com.java8features.streamsexamples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> integerList = Arrays.asList(6,7,8,9,10);
		int maxvalue = integerList.stream().reduce(0, (x,y)->x>y?x:y);
		System.out.println("max value is"+maxvalue);
		Optional<Integer> maxvalueOptional = integerList.stream().reduce((x,y)->x>y?x:y);
		if(maxvalueOptional.isPresent()) {
			System.out.println(maxvalueOptional.get());
		}
	}

}
