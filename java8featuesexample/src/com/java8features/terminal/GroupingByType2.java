package com.java8features.terminal;
import com.java8features.functionalinterfaceexamples.data.StudentDatabase;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.java8features.functionalinterfaceexamples.data.Student;
public class GroupingByType2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Grouping By Example Type2 is");
		Map<Integer,Map<String,List<Student>>> studMap = StudentDatabase.getAllStudents().stream().collect(Collectors.groupingBy(Student::getGradeLevel,Collectors.groupingBy(student -> student.getGpa()>3.5?"OUTSTANDING":"AVERAGE")));
       System.out.println("StudMap is"+studMap);
       System.out.println("Three Argument Group by is");
       LinkedHashMap<String,Set<Student>> stud3Map = StudentDatabase.getAllStudents().stream().collect(Collectors.groupingBy(Student::getName,LinkedHashMap::new,Collectors.toSet()));
       System.out.println("stud3Map is"+stud3Map);
       
       
	}

}
