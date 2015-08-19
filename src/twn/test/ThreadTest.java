package twn.test;

import static org.junit.Assert.*;

import org.junit.Test;

import twn.thread.BlockingThread;

public class ThreadTest {
	static String testString = "Init";
	static final int sleeptime = 100;
	@Test
	public void testBlockingStart() throws InterruptedException {
		Thread unblockingThread = new Thread(new ExecCode(), "unblockingThread");
		BlockingThread blockingThread1 = new BlockingThread(new ExecCode(), "blockingThread1");
		BlockingThread blockingThread2 = new BlockingThread(new ExecCode(), "blockingThread2");
		
		testString = "Init";
		unblockingThread.start();
		synchronized (testString) {
			testString += "AfterCode";
		}
		unblockingThread.join();
		assertEquals("UnblockingTest.start(): ", "InitAfterCodeThreadCode", testString);
		
		testString = "Init";
		blockingThread1.start();
		synchronized (testString) {
			testString += "AfterCode";
		}
		blockingThread1.join();
		assertEquals("BlockingTest.start(): ", "InitAfterCodeThreadCode", testString);
		
		testString = "Init";
		blockingThread2.blockingStart();
		synchronized (testString) {
			testString += "AfterCode";
		}
		blockingThread2.join();
		assertEquals("BlockingTest.blockingStart(): ", "InitThreadCodeAfterCode", testString);
	}
	
	public static class ExecCode implements Runnable {
		@Override
		public void run() {
			try {
				Thread.sleep(sleeptime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			synchronized (testString) {
				ThreadTest.testString += "ThreadCode"; 
			}
		}
	}

}
