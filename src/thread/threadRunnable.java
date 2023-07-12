package thread;

class Runn implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			System.out.println("hello "+i);
			try {
				Thread.sleep(10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
}
public class threadRunnable {
	 public static void main(String args[]) {
	Thread t1 =new Thread(new Runn());
	Thread t2 =new Thread(new Runn());
	
	t1.start();
	t2.start();
	 }
}
