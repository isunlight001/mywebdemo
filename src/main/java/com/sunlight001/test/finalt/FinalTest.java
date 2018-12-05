package com.sunlight001.test.finalt;
/**
 * 测试final修饰的变量是否可以修改  
 * 其实是可以修改的
 * @author sunlight001
 *
 */
public class FinalTest {
	public static void main(String[] args) {
		final Student st =  new Student("1","1","1");
		System.out.println(st.getId());
		st.setId("333");
		System.out.println(st.getId());
		}
}
