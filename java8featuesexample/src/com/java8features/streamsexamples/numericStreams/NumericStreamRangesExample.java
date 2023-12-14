package com.java8features.streamsexamples.numericStreams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamRangesExample {

	public static void main(String[] args) {
		IntStream intStream = IntStream.range(1, 50);
		System.out.println("Range count is "+intStream.count());
		//intStream.forEach(System.out::println);
		IntStream.range(1, 50).forEach(System.out::println);
        System.out.println("Using Range Closed is");
		IntStream.rangeClosed(1, 50).forEach(System.out::println);
		System.out.println("RangeClosed count is"+IntStream.rangeClosed(1, 50).count());
		//the same logic applie sfor LongStream
		LongStream.range(1, 100).forEach(System.out::println);
		System.out.println("Long Stream Range Count is"+LongStream.range(1, 100).count());
		//LongStream range Closed
		LongStream.rangeClosed(1, 100).forEach(System.out::println);
		System.out.println("Long STream range closed count is "+LongStream.rangeClosed(1, 100).count());
		//Double Stream demo
	     IntStream.range(1, 25).asDoubleStream().forEach(System.out::println);
	     IntStream.rangeClosed(1, 25).asDoubleStream().forEach(System.out::println);

	}

}
