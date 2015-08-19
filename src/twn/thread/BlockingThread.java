package twn.thread;

public class BlockingThread extends Thread {
	public BlockingThread() {
		super();
	}
	
	public BlockingThread(Runnable target, String name) {
		super(target, name);
	}

	public BlockingThread(Runnable target) {
		super(target);
	}

	public BlockingThread(String name) {
		super(name);
	}

	public BlockingThread(ThreadGroup group, Runnable target, String name,
			long stackSize) {
		super(group, target, name, stackSize);
	}

	public BlockingThread(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
	}

	public BlockingThread(ThreadGroup group, Runnable target) {
		super(group, target);
	}

	public BlockingThread(ThreadGroup group, String name) {
		super(group, name);
	}

	public synchronized void blockingStart() throws InterruptedException{
		super.start();
		this.join();
	}
}
