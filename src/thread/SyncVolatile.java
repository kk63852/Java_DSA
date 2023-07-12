package thread;

import java.util.Scanner;

public class SyncVolatile {
	 public static void main(String args[]) {
		 Processor pr= new Processor();
		 pr.start();
		 System.out.println("Enter to stop...");
		 Scanner sc=new Scanner(System.in);
		 sc.nextLine();
		 
		 pr.shutdown();
	 }
}

class Processor extends Thread{
	/* this thread might decide to cache the running variable at
	 * some point as java tries to optimize the code, so it may not see 
	 * the running variable value changed as it is being changed from the main thread.
	 * so to rectify we use volatile keyword
	 * volatile prevents threads from caching the value when they are not changed from
	 * within the same thread */
	private volatile boolean running=true;

	public void run() {
		while (running) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		running=false;
	}
}
