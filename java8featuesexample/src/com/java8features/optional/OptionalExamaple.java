package com.java8features.optional;

import java.util.Optional;

public class OptionalExamaple {
	public static void main(String[] args) {
		
		/*System.out.println("Of Nullable Demo");
		Optional<String> ex= Optional.ofNullable("Hello");
		System.out.println("OfNullable demo is"+ex);
		if(ex.isPresent()) {
		System.out.println("OfNullable demo with get() is "+ex.get());
		}
		Optional<String> ex1= Optional.ofNullable(null);
		System.out.println("OfNullable with null demo is"+ex1);
		if(ex1.isPresent()) {
		System.out.println("OfNullable demo with null of get() is "+ex1.get());
		}*/
		System.out.println("---------------OF DEMO---------------------------");
		Optional<String> ofdemo = Optional.of("Srikanth");
		if(ofdemo.isPresent()) {
		System.out.println("of variable is"+ofdemo.get());
		}
		System.out.println("---------------OF NULL DEMO---------------------------");
		Optional<String> ofnulldemo = Optional.of(null);
		if( ofnulldemo.isPresent()) {
		System.out.println("of variable is"+ ofnulldemo.get());
		}		
		
		
}
}
