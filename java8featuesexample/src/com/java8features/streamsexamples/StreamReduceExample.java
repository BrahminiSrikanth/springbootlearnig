package com.java8features.streamsexamples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.java8features.functionalinterfaceexamples.data.Student;
import com.java8features.functionalinterfaceexamples.data.StudentDatabase;

public class StreamReduceExample {
	
public static Optional<Student> getHighestGpaStudent(){
	return StudentDatabase.getAllStudents().stream().reduce((s1,s2)->s1.getGpa()>s2.getGpa()?s1:s2);
}
public static int performMultiply(List<Integer> integerList) {
	return integerList.stream().reduce(1, (a,b)->a*b);
}
	public static void main(String[] args) {
		List<Integer> inputList = Arrays.asList(1,2,3,4,5);
		System.out.println("Multiplication Resul is"+ performMultiply(inputList));
        Optional<Student> s1= getHighestGpaStudent();
        if(s1.isPresent()) {
        	System.out.println("Highest Gpa of student is"+s1.get().getGpa());
        }
	}

}
