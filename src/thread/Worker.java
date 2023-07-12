package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
	private Random random = new Random();
	private Object lock1 = new Object();
	private Object lock2 = new Object();

	private List<Integer> l1 = new ArrayList<>();
	private List<Integer> l2 = new ArrayList<>();

	public void main() {
		System.out.println("Starting ...");
		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				process();
			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				process();
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

		long end = System.currentTimeMillis();
		System.out.println("Time : " + (end - start));
		System.out.println("L1: " + l1.size() + " " + "L2: " + l2.size());
	}

	public void stageOne() {
		
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			l1.add(random.nextInt(100));
		}
	}

	public void stageTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			l2.add(random.nextInt(100));
		}
	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}
}
