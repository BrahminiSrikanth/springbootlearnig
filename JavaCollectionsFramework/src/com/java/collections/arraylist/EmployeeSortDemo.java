package com.java.collections.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeSortDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    List<Employee> employees= new ArrayList<>();
    employees.add(new Employee(10,"ramesh",30,400000));
    employees.add(new Employee(20,"santosh",29,350000));
    employees.add(new Employee(30,"sanjay",30,450000));
    employees.add(new Employee(40,"pramod",29,500000));
    employees.add(new Employee(50,"hasini",28,600000));
    System.out.println("Implementing Sorting on Customized objects using comparator");
    employees.sort(new Mysort());
    System.out.println("Implementing Sorting on Customized objects using comparator");
    System.out.println(employees);
    //we can use collections.sort
    Collections.sort(employees, new Mysort());
    System.out.println("Implementing Sorting on Customized objects using collections");
    System.out.println(employees);
    //using lamda expressions
    System.out.println("Using anonymous implementation");
    Collections.sort(employees, new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return (int) (o2.getSalary()-o1.getSalary());
		}
    	
    });
    System.out.println(employees);
	}
}
	class Mysort implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			
			return (int) (o1.getSalary()-o2.getSalary());
		}
		
	}

