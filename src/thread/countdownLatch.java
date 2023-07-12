package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class countdownLatch {
public static void main(String args[]) {
	
	/*thread safe. a countdown that lets you countdown from a number specified*/
	CountDownLatch cl= new CountDownLatch(3);
	
	ExecutorService ex=Executors.newFixedThreadPool(3);
	
	for(int i=0;i<3;i++) {
		ex.submit(new Proc(cl));
	}
	
	try {
		cl.await();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Completed");
}
}


class Proc implements Runnable{
	private CountDownLatch latch;
	Proc(CountDownLatch latch){
		this.latch=latch;
	}
	public void run() {
		System.out.println("Started");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
	}
}