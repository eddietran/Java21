// This demo implements Comparable and Comparator using generics.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class GenericComparator<T> implements Comparator<T> {

	// Compare two generic objects using hash code (inherited from Object class)
	@Override
	public int compare(T o1, T o2) {
		return o1.hashCode() - o2.hashCode();
	}
	
}

// Create wrapper object GenericComparable<T> to implement Comparable using generics
class GenericComparable<T> implements Comparable<GenericComparable<T>> {

	private T data;
	
	public GenericComparable(T data) {
		this.data = data;
	}
	
	@Override
	public int compareTo(GenericComparable<T> o) {
		return this.hashCode() - o.hashCode();
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}

public class GenericComparableComparatorDemo {

	public static void main(String[] args) {
		List<GenericComparable<String>> phrases = Arrays.asList(new GenericComparable<>("Hello"), new GenericComparable<>("Goodbye"), new GenericComparable<>("Greetings"), new GenericComparable<>("See you later"));
		
		List<GenericComparable<String>> list1 = new ArrayList<>(phrases);
		Collections.sort(list1, new GenericComparator<GenericComparable<String>>());
		System.out.println(list1);
		
		List<GenericComparable<String>> list2 = new ArrayList<>(phrases);
		Collections.sort(list2);
		System.out.println(list2);
		
		// Equivalent output from same list whether you sort using Comparator or Comparable
	}
}
