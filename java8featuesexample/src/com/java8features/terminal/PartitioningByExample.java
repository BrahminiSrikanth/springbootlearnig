package com.java8features.terminal;
import com.java8features.functionalinterfaceexamples.data.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java8features.functionalinterfaceexamples.data.Student;
public class PartitioningByExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Boolean,List<Student>> studMap =StudentDatabase.getAllStudents().stream().collect(Collectors.partitioningBy(S->S.getGpa()>=3.5));
        System.out.println("studMap is"+studMap);
        System.out.println("Partitioning by example 2 is");
        Map<Boolean,List<Student>> studMap_2 =StudentDatabase.getAllStudents().stream().collect(Collectors.partitioningBy(S->S.getGpa()>=3.5,Collectors.toList()));
        System.out.println("Partitioning by example 2 is"+studMap_2);
	}

}
