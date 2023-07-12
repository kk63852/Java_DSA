package thread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Worker4 {
	private Account acc1=new Account();
	private Account acc2=new Account();
	private Lock lock1=new ReentrantLock();
	private Lock lock2=new ReentrantLock();
	private void acquireLocks(Lock firstLock,Lock secondLock)throws InterruptedException{
		while(true) {
			//Acquire Locks
			boolean gotFirstLock=false;
			boolean gotSecondLock=false;
			try {
				gotFirstLock=firstLock.tryLock();/*to prevent deadlocks in case of multiple locks
				 									trylock is used to try which lock is free*/
				gotSecondLock=secondLock.tryLock();
			}finally {
				if(gotFirstLock && gotSecondLock) {
					return;
				}
				if(gotFirstLock) {
					firstLock.unlock();
				}
				if(gotSecondLock) {
					secondLock.unlock();
				}
			}
		}
	}
	
	public void firstThread()throws InterruptedException{
		Random rand=new Random();
		for(int i=0;i<1000;i++) {
			acquireLocks(lock1,lock2);
			try {
			Account.transfer(acc1,acc2,rand.nextInt(100));
		}finally {
			lock1.unlock();
			lock2.unlock();}
		}
	}
	public void secondThread() throws InterruptedException{
		Random rand=new Random();
		for(int i=0;i<1000;i++) {
			acquireLocks(lock1,lock2);
			try {
			Account.transfer(acc2,acc1,rand.nextInt(100));
		}finally {
			lock1.unlock();
			lock2.unlock();}
		}
	}
	public void finished() {
		System.out.println("Account 1: "+acc1.getBalance());
		System.out.println("Account 2: "+acc2.getBalance());
		System.out.println("Total: "+(acc1.getBalance()+acc2.getBalance()));
	}
}
