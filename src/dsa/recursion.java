package dsa;

public class recursion {
	public static void main(String args[]) {
		
		System.out.println(factorial(-4));
		System.out.println(fibonacci(4));
		System.out.println(sum(7345));
		System.out.println(power(2,4));
		System.out.println(gcd(4,16));
		System.out.println(binary(10));
		
	}
	//finding factorial of a number using recursion
	public static int factorial(int n) {
		if(n<0)
			return -1;
		if (n==0 || n==1)
			return 1;
		
		return n*factorial(n-1);
		
	}
	//finding fibonacci of a number using recursion
	public static int fibonacci(int n) {
		if(n<0) return -1;
		
		if(n==0 || n==1) return n;
		
		return fibonacci(n-1)+ fibonacci(n-2);
	}
	//finding sum of digits of a positive integer using recursion
	public static int sum(int n) {
		if (n<0) return 0;
		if(n==0) return 0;
		
		return n%10 + sum(n/10);
	}
	//finding power of a number
	public static int power(int base, int exp) {
		if(exp<0) return -1;
		if(exp==0) return 1;
		return base * power(base, exp-1);
	}
	//finding GCD of two numbers
	//implementing Euclidean Algorithm
	//gcd(a,0)=a
	//gcd(a,b)=gcd(b,a mod b)
	static int gcd(int a, int b) {
		if(a<0 || b<0) return -1;
		if(b==0) return a;
		return gcd(b,a%b);
	}
	//convert a number from decimal to binary
	//recursive soln : f(n) = n mod 2 + 10* f(n/2)
	static int binary(int n) {
		if(n==0) return 0;
		return n%2 + 10*binary(n/2);
	}
}
