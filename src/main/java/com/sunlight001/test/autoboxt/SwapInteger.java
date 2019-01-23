package com.sunlight001.test.autoboxt;

import java.lang.reflect.Field;

public class SwapInteger {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Integer a =1,b=2;
		System.out.println("a = "+a+" ,b = "+b);
		swap2(a,b);
		System.out.println("a = "+a+" ,b = "+b);
	}
	/**
	 * 坑0 引用传递
	 * 2019年1月2日@param a
	 * 2019年1月2日@param b
	 */
	private static void swap(Integer a, Integer b) {
		Integer tmp =a;
		a = b;
		b = tmp;
	}
	/**
	 * 坑1 缓存
	 * 2019年1月2日@param a
	 * 2019年1月2日@param b
	 * 2019年1月2日@throws NoSuchFieldException
	 * 2019年1月2日@throws SecurityException
	 * 2019年1月2日@throws IllegalArgumentException
	 * 2019年1月2日@throws IllegalAccessException
	 */
	private static void swap1(Integer a, Integer b) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = Integer.class.getDeclaredField("value");
		field.setAccessible(true);
		int tmp =a.intValue();
		field.set(a, b.intValue());
		field.set(b, tmp);;
	}
	private static void swap2(Integer a, Integer b) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = Integer.class.getDeclaredField("value");
		field.setAccessible(true);
		Integer tmp = new Integer(a.intValue());
		field.set(a, b.intValue());
		field.set(b, tmp);
	}

}
