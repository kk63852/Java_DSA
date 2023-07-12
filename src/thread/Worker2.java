package thread;

import java.util.Scanner;

public class Worker2 {
public void produce()throws InterruptedException{
	synchronized(this) {
		System.out.println("Producer thread running..");
		wait();//can only be called from a synchronized block.gives up the intrinsic lock
		System.out.println("Resumed.");
	}
}
public void consume()throws InterruptedException{
	Scanner sc=new Scanner(System.in);
	Thread.sleep(2000);
	synchronized(this) {
		System.out.println("Waiting for Return Key.");
		sc.nextLine();
		System.out.println("Return Key Pressed.");
		notify();/*can only be called from a synchronized block. 
		 			*notify the thread on this lock that the lock is free now
		 			*wont give up the lock*/
	}
}
}
