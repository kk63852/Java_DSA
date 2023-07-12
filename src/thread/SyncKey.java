package thread;

public class SyncKey {
	private int count = 0;
	/*two separate threads are trying to change the value of count
	 * because of this sometimes the desired the value is given as one thread might 
	 * be working on older value of count. Hence we use synchronized
	 * Every object in java has intrinsic lock or monitor lock and if we call an synchronized method of that object
	 * then only one thread can acquire the intrinsic lock at a time and runs the sync method and 
	 * at the same time other thread tries to acquire the intrinsic lock to call the method, it 
	 * will have to wait for the first thread to release the intrinsic lock.
	 * A method marked synchronized can only be called by acquiring the intrinsic lock*/
	public synchronized void increment() {
		count++;
	}

	public static void main(String args[]) {
		SyncKey sy = new SyncKey();
		sy.doWork();
	}

	public void doWork() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}

		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}

		});

		t1.start();
		t2.start();
		try {
			t1.join();// wait for the thread to complete execution
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Count is: " + count);
	}
}
