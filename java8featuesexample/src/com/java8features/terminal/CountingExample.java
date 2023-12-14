package com.java8features.terminal;

import com.java8features.functionalinterfaceexamples.data.StudentDatabase;

public class CountingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long studcount = StudentDatabase.getAllStudents().stream().count();
		System.out.println("StudCount is"+studcount);
		long studcountex = StudentDatabase.getAllStudents().stream().filter(s->s.getGpa()>3.9).count();
		System.out.println("StudCount EXample is"+studcountex);

	}

}
