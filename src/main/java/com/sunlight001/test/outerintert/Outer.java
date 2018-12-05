package com.sunlight001.test.outerintert;

public class Outer {
	class Inner {}

    public static void foo() { 
    	//new Inner(); 
    	}
    

    public void bar() { new Inner(); }

    public static void main(String[] args) {
//        new Inner();
    }

}
