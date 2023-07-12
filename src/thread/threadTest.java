package thread;

public class threadTest {
 public static void main(String args[]) {
	 System.out.print("jhdsc");
	 Runner r=new Runner();
	 r.start();
	 Runner r2=new Runner();
	 r2.start();
 }
}

class Runner extends Thread{
	public void run() {
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
