package com.sunlight001.test.autoboxt;
/**
 * 
 * @author sunlight001
 * 2019年1月3日
 */
public class AutoUnboxingTest {
	public static void main(String[] args) {
		Integer a = new Integer(3);
		Integer b = 3;
		int c = 3;
		System.out.println( a == b );
		System.out.println( a == c );
		
		Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

        System.out.println(f1 == f2);
        System.out.println(f3 == f4);

	}
}
