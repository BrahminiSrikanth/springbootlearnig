package com.java8features.terminal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java8features.functionalinterfaceexamples.data.*;
public class JoiningExample {

	public static void main(String[] args) {
	
		System.out.println("Joining Example Demo");
		String studentNameStream = StudentDatabase.getAllStudents().stream().map(s -> s.getName()).collect(Collectors.joining());
        System.out.println("Student Name Stream example is "+studentNameStream);
        System.out.println("Joining Overloaded method with delimeter '-'");
        String studNameStream1 = StudentDatabase.getAllStudents().stream().map(Student::getName).collect(Collectors.joining("-"));
        System.out.println("Student Name1 Stream example is "+studNameStream1);
        String studNameStream2 = StudentDatabase.getAllStudents().stream().map(s -> s.getName()).collect(Collectors.joining("-", "(", ")"));
        System.out.println("Student Name2 Stream example is "+studNameStream);
	}
	

}
