package com.java8features.functionalinterfaceexamples;
import java.util.List;
import java.util.function.Consumer;
public class ConsumerExample {
	static Consumer<Student> c1=(Student s) -> System.out.println(s.getName());
	static Consumer<Student> c2=(Student s) -> System.out.println(s.getActivities());
	//static Consumer<Student> c3=(Student s) -> System.out.println(s.getGradeLevel()>=3);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Consumer<String> cons = (s) -> System.out.println(s.toUpperCase());
    cons.accept("java8");
    printName();
    printNameAndActivities();
    printNameAndActivitiesusingGradeLevel();
    
	}
    public static void printName() {
    	List<Student> studentlist= StudentDatabase.getAllStudents();
    	//Consumer<Student> c1=(Student s) -> System.out.println(s.getName());
    	studentlist.forEach(c1);
    }
    
    public static void printNameAndActivities() {
    	System.out.println("Print Name And Activities Of Student");
    	List<Student> studentlist= StudentDatabase.getAllStudents();
    	studentlist.forEach(c1.andThen(c2));
    }
    public static void printNameAndActivitiesusingGradeLevel() {
    	System.out.println("Print Name And Activities Of Student based on GradeLevel filtering");
    	List<Student> studentlist= StudentDatabase.getAllStudents();
    	studentlist.forEach(s -> {if(s.getGradeLevel() >= 3) {
    		c1.andThen(c2).accept(s);
    	}
    });
    
    } 
}
