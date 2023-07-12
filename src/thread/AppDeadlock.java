package thread;

public class AppDeadlock {
	public static void main(String args[]) {
		final Worker4 worker=new Worker4();
		Thread t1=new Thread(new Runnable() {
			public void run() {
				try {
					worker.firstThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			public void run() {
				try {
					worker.secondThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		worker.finished();
	}
}
