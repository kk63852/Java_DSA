package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class executor {
	public static void main(String args[]) {
		ExecutorService exec=Executors.newFixedThreadPool(2);
		for (int i=0;i<5;i++) {
			exec.submit(new Process(i));
		}
		exec.shutdown();
		System.out.println("Tasks submitted");
		
		try {
			exec.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Tasks completed");
	}

}

class Process implements Runnable{
	private int id;
	Process(int id){
		this.id=id;
	}
	@Override
	public void run() {
		System.out.println("Starting : "+id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed : "+id);
		
	}
}


