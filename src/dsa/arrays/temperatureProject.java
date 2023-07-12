package dsa.arrays;

import java.util.Scanner;

public class temperatureProject {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("How many days temperature? ");
		int numberOfDays = sc.nextInt();
		int[] arr= new int[numberOfDays];
		int sum=0;
		for(int i=0;i<numberOfDays;i++) {
			System.out.print("Day "+i+ "'s high temp:");
			arr[i]=sc.nextInt();
			sum+=arr[i];
		}
		double avg= sum/numberOfDays;
		
		int above=0;
		for(int i=0;i<numberOfDays;i++) {
			if(arr[i]>avg) {
				above++;
			}
		}
		System.out.println("Average temp : "+ avg);
		System.out.println();
		
		System.out.println(above+" days above average");
	}

}
