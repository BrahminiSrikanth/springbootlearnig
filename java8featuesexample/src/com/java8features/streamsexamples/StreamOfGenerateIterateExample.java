package com.java8features.streamsexamples;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfGenerateIterateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stream<String> stringStream = Stream.of("adam","dan","july");
		stringStream.forEach(System.out::println);
		
		Stream.iterate(1,x->x*2).limit(20).forEach(System.out::println);
		
		Supplier<Integer> integerSupplier=new Random()::nextInt;
		Stream.generate(integerSupplier).limit(30).forEach(System.out::println);
		

	}

}
