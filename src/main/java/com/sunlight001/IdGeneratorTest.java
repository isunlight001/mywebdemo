package com.sunlight001;

import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorTest {
	private final AtomicLong sequenceNumber = new AtomicLong(0);

    public long next() {
        return sequenceNumber.getAndIncrement(); 
    }
    public static void main(String[] args) {
    	
	}
}
