package dsa.arrays;

import java.util.Arrays;

public class arrayExercise {
	public static void main(String args[]) {
		SingleDimensionArray sda = new SingleDimensionArray(10);

		twoDimensionalArray tda = new twoDimensionalArray(3, 2);
		tda.insertValueInTheArray(0, 0, 9);
		tda.insertValueInTheArray(0, 1, 78);
		tda.insertValueInTheArray(2, 1, 90);
		tda.deletingValueFromIndex(2, 1);
		tda.searchValue(90);
		tda.traverse2DArray();
		tda.accessCell(2, 1);
		System.out.println(Arrays.deepToString(tda.arr));
		// tda.initialising();
//		sda.insert(0, 0);
//		sda.insert(1, 10);
//		sda.insert(2, 20);
//		sda.insert(12, 3);
//		sda.insert(2, 4);

//		sda.getElment(11);
//		sda.arrayTraversal();
//		sda.searchInArray(101);
//		sda.deleteValuefromArray(1);
//		sda.getElment(1);
	}
}
