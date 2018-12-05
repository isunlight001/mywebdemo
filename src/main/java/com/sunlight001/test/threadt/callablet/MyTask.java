package com.sunlight001.test.threadt.callablet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyTask implements Callable<Integer> {
	    private int upperBounds;

	    public MyTask(int upperBounds) {
	        this.upperBounds = upperBounds;
	    }

	    @Override
	    public Integer call() throws Exception {
	        int sum = 0; 
	        for(int i = 1; i <= upperBounds; i++) {
	            sum += i;
	        }
	        return sum;
	    }


	    public static void main(String[] args) throws Exception {
	        List<Future<Integer>> list = new ArrayList<>();
	        ExecutorService service = Executors.newFixedThreadPool(10);
	        for(int i = 0; i < 10; i++) {
	            list.add(service.submit(new MyTask((int) (Math.random() * 100))));
	        }

	        int sum = 0;
	        for(Future<Integer> future : list) {
	            // while(!future.isDone()) ;
	            sum += future.get();
	        }

	        System.out.println(sum);
	    }
	}

