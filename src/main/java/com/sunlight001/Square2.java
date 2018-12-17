package com.sunlight001;
/**
 * 求根号2的值
 * @author sunlight001
 * 2018年12月17日
 */
public class Square2 {

	public static void main(String[] args) {
		System.out.println("===="+square(5.0));
	}
	public static Double square(double num) {
		double res = num>1?num:1;
		while(res*res - num >Math.pow(10, -8)) {
			res = 0.5*(res+num/res);
			System.out.println(res);
		}
		return res;
	}

}
