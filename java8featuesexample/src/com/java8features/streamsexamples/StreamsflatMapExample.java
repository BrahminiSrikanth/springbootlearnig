package com.java8features.streamsexamples;

import java.util.List;
import java.util.stream.Collectors;

import com.java8features.functionalinterfaceexamples.data.*;


public class StreamsflatMapExample {
	public static List<String> printStudentactivities(){
		
		List<String> studentActivities=StudentDatabase.getAllStudents()
				                       .stream()//Stream<Student>
				                       .map(Student::getActivities)//Stream<List<String>>
				                       .flatMap(List::stream)//Stream<String>
				                       .distinct()
				                       .sorted()
				                       .collect(Collectors.toList());
		
		return studentActivities;
			
	}
	
public static Long getStudentactivitiesCount(){
		
		long noofstudentActivities=StudentDatabase.getAllStudents()
				                       .stream()//Stream<Student>
				                       .map(Student::getActivities)//Stream<List<String>>
				                       .flatMap(List::stream)//Stream<String>
				                       .distinct()
				                       .count();
		
		return noofstudentActivities;
			
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println("Student Activities are:"+printStudentactivities());
       System.out.println("Student Activities count are:"+getStudentactivitiesCount());
	}

}
