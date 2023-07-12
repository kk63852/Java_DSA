package dsa.arrays;

public class missingNumber {
	public static void missingNumber(int[] intArray) {
		int sum=55;
		int s=0;
		for(int i=0;i<intArray.length;i++) {
			s+=intArray[i];
		}
		System.out.println(sum-s);
	}
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,8,9,10};
		missingNumber(arr);
	}

}
