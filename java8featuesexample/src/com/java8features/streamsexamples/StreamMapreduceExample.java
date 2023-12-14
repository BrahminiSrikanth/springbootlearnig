package com.java8features.streamsexamples;

import com.java8features.functionalinterfaceexamples.predicate.StudentDatabase;
//import com.java8features.functionalinterfaceexamples.data.Student;
public class StreamMapreduceExample {

	private static int noofNoteBooks() {
		return StudentDatabase.getAllStudents().stream()//Stream<Students>
		          .map(Student::getNoteBooks) //stream<Integer>
		           .reduce(0,(a,b)-> a+b);
		//reduce(0,Integer::sum)
		                              
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
