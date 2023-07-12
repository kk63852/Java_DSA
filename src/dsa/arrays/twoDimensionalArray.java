package dsa.arrays;

import java.util.Arrays;

public class twoDimensionalArray {
	int[][] arr;

	public twoDimensionalArray(int numberOfRows, int numberOfColumns) {
		this.arr = new int[numberOfRows][numberOfColumns];
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				arr[row][col] = Integer.MIN_VALUE;
			}
		}
	}

	public twoDimensionalArray() {
		// TODO Auto-generated constructor stub
	}

	// initialising the 2D array with values: O(mn)
	public void initialising() {
		arr = new int[2][2];

		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[1][0] = 3;
		arr[1][1] = 4;
		System.out.println(Arrays.deepToString(arr));
		int arr2[][] = { { 1, 2 }, { 5, 7 } };
		System.out.println(Arrays.deepToString(arr2));

	}

	// inserting a value in 2D array : O(1)
	public void insertValueInTheArray(int row, int col, int value) {
		try {
			if (arr[row][col] == Integer.MIN_VALUE) {
				arr[row][col] = value;
				System.out.println("Value Inserted Successfully");
			} else {
				System.out.println("Cell is already occupied");
			}
		} catch (Exception e) {
			System.out.println("Invalid Index");

		}
	}

	// accesing a cell value in 2D array : O(1)
	public void accessCell(int row, int col) {
		try {
			System.out.println("Cell value is : " + arr[row][col]);
		} catch (Exception e) {
			System.out.println("Invalid index");
		}
	}

	// Traverse 2D array : O(MN)
	public void traverse2DArray() {
		// in case 2D array length function return the size of row
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Searching an element (Linear Search) : O(MN)
	public void searchValue(int valueToBeSearch) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == valueToBeSearch) {
					System.out.println("Value found at index : " + i + " " + j);
				}
			}
		}
		System.out.println("Value not found");
	}

	// Deleting an element from 2D array : O(1)
	public void deletingValueFromIndex(int row, int col) {
		try {
			arr[row][col]=Integer.MIN_VALUE;
			System.out.println("Deltetion Successfull");
		}catch(Exception e) {
			System.out.println("Invalid Index");
		}
	}
}
