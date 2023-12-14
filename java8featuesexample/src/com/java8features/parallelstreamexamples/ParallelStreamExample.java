package com.java8features.parallelstreamexamples;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample {
public static long checkPerformanceResult(Supplier<Integer> supplier,int numberOfTimes) {
	long startTime = System.currentTimeMillis();
 for(int i =0;i<numberOfTimes;i++) {
	 supplier.get();
 }
 long endTime = System.currentTimeMillis();;
 return endTime-startTime;
}
	public static int sum_sequentialStream() {
		return IntStream.rangeClosed(1, 100000).sum();
	}
	
	public static int sum_parallelStream() {
		return IntStream.rangeClosed(1, 100000).parallel().sum();
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Sequential Stream is "+sum_sequentialStream());
		//System.out.println("Parallel Stream is "+sum_parallelStream());
		System.out.println("No of processesors available"+Runtime.getRuntime().availableProcessors());
		System.out.println("Parallel Stream result is"+checkPerformanceResult(ParallelStreamExample::sum_parallelStream,20));
		System.out.println("Sequential Stream Result is"+checkPerformanceResult(ParallelStreamExample::sum_sequentialStream,20));
		

	}

}
