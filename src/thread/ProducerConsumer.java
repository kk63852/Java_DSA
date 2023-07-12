package thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;//thread safe
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);//FIFO data structure
	
	public static void main(String args[]) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				producer();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				consumer();
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


private static void producer() {
	Random rand=new Random();
	while(true) {
		try {
			queue.put(rand.nextInt(100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

private static void consumer() {
	Random rand=new Random();
	while(true) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rand.nextInt(10)==0) {
			Integer value=0;
			try {
				value = queue.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Taken: "+value+" "+"Queue size: "+queue.size());
		}
	}
}
}

