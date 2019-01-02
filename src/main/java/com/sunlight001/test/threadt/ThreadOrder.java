package com.sunlight001.test.threadt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 可以通过thread的join方法和 Executor的newFixedThreadPool来实现
 * @author sunlight001
 * 2019年1月2日
 */
public class ThreadOrder {
	static Thread t1 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			System.out.println("t1 Thread!");
			
		}
	});
	static Thread t2 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			System.out.println("t2 Thread!");
			
		}
	});
	static Thread t3 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			System.out.println("t3 Thread!");
			
		}
	});
	
	static ExecutorService es =Executors.newFixedThreadPool(1) ;
		
		

	public static void main(String[] args) throws InterruptedException {
//		method1();
		method2();
	}
	/**
	 * 使用join方法
	 * 父线程等待子线程结束后才能继续运行
	 * 2019年1月2日@throws InterruptedException
	 */
	static void method1() throws InterruptedException {
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
	}
	/**
	 * ExecutorService
	 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
	 */
	static void method2() {
		es.execute(t1);
		es.execute(t2);
		es.execute(t3);
		es.shutdown();
	}
	
	

}
