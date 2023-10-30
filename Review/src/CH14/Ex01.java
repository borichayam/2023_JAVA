package CH14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Ex01 {

	public static void main(String[] args) {
		List<String> listOfNames = Arrays.asList(new String[] 
				{"Apple", "Banana", "Cherry"});
		List<String> newList = new ArrayList<String>();
		
		Function <String, String> toL = (n) -> n.toLowerCase();
		for (String a:listOfNames) {
			newList.add(toL.apply(a));
		}
		
		System.out.println(listOfNames);
		System.out.println(newList);
	}

}
