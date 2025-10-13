// create custom integer array list which dynamically expands without providing user-specified size

public class CustomArrayList {

	private Integer[] array;
	private int size;
	
	public CustomArrayList(int size) {
		array = new Integer[size];
	}
	
	public void add(Integer data) {
		if (size == array.length) {
			Integer[] newArray = new Integer[size*2];
			for (int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
		}
		array[size++] = data;
	}
	
	public Integer get(int index) {
		if (index < 0 || index >= size) return null;
		
		return array[index];
	}
	
	public void set(int index, int value) {
		if (index < 0 || index >= size) return;
		
		array[index] = value;
	}
	
	public void remove(int index) {
		if (index < 0 || index >= size) return;		
		
		// Shift elements to left
		for (int i = index+1; i < size; i++) {
			array[i-1] = array[i];
		}
		
		// Clear last element
		array[--size] = null;
	}
}
