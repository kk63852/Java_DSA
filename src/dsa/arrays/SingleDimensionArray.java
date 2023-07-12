package dsa.arrays;

public class SingleDimensionArray {
	int[] arr = null;
	
	public SingleDimensionArray(int sizeOfArray) {
		arr= new int[sizeOfArray];
		for(int i=0; i<arr.length;i++) {
			arr[i]=Integer.MIN_VALUE;
		}
	}
	
	//time complexity for below method is O(1)
	public void insert(int location,int valueToBeInserted ) {
		try {
			if(arr[location]==Integer.MIN_VALUE) {
				arr[location]=valueToBeInserted;
				System.out.println("Successfully Inserted");
			}else {
				System.out.println("This cell is already occupied");
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.printf("Invalid index to access array! %n");
		}
		
	}
	
	//accessing an element of array:  O(1)
	public void getElment(int position) {
		try {
			System.out.println(arr[position]);
		}catch(Exception e){
			System.out.println("No element present at the given position");
		}
		
	}

	//Array Traversal: O(N)
	public void arrayTraversal() {
		try {
			for(int i=0; i<arr.length;i++) {
				System.out.print(arr[i]+" ");
			}
		}catch(Exception e) {
			System.out.println("Array no longer exists");
		}
		
	}
	
	//Searching an element in the given array : O(N). this is linear search.
	public void searchInArray(int valueToSearch) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==valueToSearch) {
				System.out.println("element found at position " + i);
				return; //to exit the loop when if condition is true
			}
		}
		System.out.println(valueToSearch + " is not found");
	}
	
	//deleting an element at given index in the given array : O(1)
	public void deleteValuefromArray(int valueToBeDeletedAtIndex) {
		try {
			arr[valueToBeDeletedAtIndex]=Integer.MIN_VALUE;
			System.out.println("Value at given index successfully deleted");
		}catch(Exception e) {
			System.out.println("Index out of range");
		}
	}

}
