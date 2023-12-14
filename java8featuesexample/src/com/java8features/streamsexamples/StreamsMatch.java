package com.java8features.streamsexamples;

public class StreamsMatch {

	public static void main(String[] args) {
		boolean allMatch = StudentDatabase.getAllStudents()
				           .stream().allMatch(s->s.getGpa()>=3.5);
		System.out.println("all match result is"+allMatch);
		boolean anyMatch = StudentDatabase.getAllStudents().stream().anyMatch(s->s.getGpa()>=4.0);
		System.out.println("ANy match result is"+anyMatch);
		boolean noneMatch = StudentDatabase.getAllStudents().stream().noneMatch(s->s.getGpa()>=4.0);
		System.out.println("None Match result is"+noneMatch);

	}

}
