import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Rotates between three threads to print numbers 1 to 10 in sequence
// Thread 1 prints 1, Thread 2 prints 2, Thread 3 prints 3, Thread 1 prints 4, ... Thread 3 prints 9, Thread 1 prints 10 

public class ThreadingDemo {

	public static void main(String[] args) {
		Count count = new Count();
		ReentrantLock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		Thread t1 = new Thread(new Counter(1, count, lock, condition));
		Thread t2 = new Thread(new Counter(2, count, lock, condition));
		Thread t3 = new Thread(new Counter(3, count, lock, condition));
		t1.start();
		t2.start();
		t3.start();
	}
}

class Counter implements Runnable {
	private int id;
	private Count count;
	private ReentrantLock lock;
	private Condition condition;
	
	Counter(int id, Count count, ReentrantLock lock, Condition condition) {
		this.id = id;
		this.count = count;
		this.lock = lock;
		this.condition = condition;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public void run() {
		while (count.getCount() <= 10) {
			this.count.countToTen(this, lock, condition);
		}
	}
}

class Count {
	private int count;
	private int currentCounter;
	
	Count() {
		currentCounter = 1;
	}
	
	public void countToTen(Counter c, ReentrantLock lock, Condition condition) {		
		lock.lock();
		try {
			while (currentCounter != c.getId()) {
				condition.await();
			}
			
			if (count >= 10) {
				condition.signalAll();
				return;
			}
			
			System.out.println("Counter " + c.getId() + " is counting: " + ++count);
			currentCounter = (currentCounter % 3) + 1;
			condition.signalAll();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} finally {
			lock.unlock();
		}
	}
	
	public int getCount() {
		return count;
	}
}