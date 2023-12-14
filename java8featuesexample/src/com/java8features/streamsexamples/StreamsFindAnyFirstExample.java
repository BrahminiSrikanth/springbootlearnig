package com.java8features.streamsexamples;

import java.util.Optional;

public class StreamsFindAnyFirstExample {

	public static void main(String[] args) {
		Optional<Student> findAnyex = StudentDatabase.getAllStudents()
				                      .stream().filter(s->s.getGpa()>=3.9).findAny();
		if(findAnyex.isPresent()) {
			System.out.println("Find Any Eample Result"+findAnyex.get());
		}
		
		Optional<Student> findFirstEx = StudentDatabase.getAllStudents().stream().filter(s->s.getGpa()>=3.9).findFirst();
        if(findFirstEx.isPresent()) {
        	System.out.println("FInd First Example Result"+findFirstEx.get());
        }
	}

}
