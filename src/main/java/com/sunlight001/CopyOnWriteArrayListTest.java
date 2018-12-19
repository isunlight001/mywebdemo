package com.sunlight001;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author sunlight001
 * 2018年12月5日
 */
class AddThread implements Runnable {
	private List<Double> list;

	public AddThread(List<Double> list) {
		this.list = list;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000000; ++i) {
			list.add(Math.random());
			System.out.println(this.getClass().getName()+":"+i);
		}
	}
}

public class CopyOnWriteArrayListTest {
    private static final int THREAD_POOL_SIZE = 5;

    /**
     * 2018年12月5日@param args
     */
    public static void main(String[] args) {
        List<Double> list = new CopyOnWriteArrayList<>();
//        List<Double> list = new ArrayList<>();
        ExecutorService es = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        es.execute(new AddThread(list));
        es.execute(new AddThread(list));
        es.execute(new AddThread(list));
        es.execute(new AddThread(list));
        es.execute(new AddThread(list));
        es.shutdown();
    }
}
