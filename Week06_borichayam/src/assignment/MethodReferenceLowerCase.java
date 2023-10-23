package assignment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReferenceLowerCase {
	public static void main(String[] args) {
		List<String> listOfNames = Arrays.asList(new String[]
				{"Apple", "Banana", "Cherry"});
		
		List<String> small = listOfNames.stream()
				.map(s -> s.toLowerCase())
				.sorted()
				.collect(Collectors.toList());
		
		System.out.println(small);
	}
}
