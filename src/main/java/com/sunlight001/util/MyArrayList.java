package com.sunlight001.util;
/**
 * 简单实现arraylist
 * @author sunlight001
 * 2019年1月3日
 */
public class MyArrayList {
	
	private int size = 0;
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	Object[] objs = new Object[4];
	
	public void add(Object obj) {
		if(size==objs.length) {
			Object[] newobjs = new Object[objs.length*2];
			for(int i = 0;i< objs.length;i++) {
				newobjs[i] = objs[i];
			}
			objs = newobjs;
		}
		objs[size] = obj;
		size++;
	}
	public void remove(int index) throws Exception {
		if(index <0 || index >=size) {
			throw new Exception("数组越界!");
		}
		for(int i = index;i<getSize();i++) {
			objs[i]=objs[i+1];
		}
		size--;
	}
	public void set(int index,Object value) throws Exception {
		if(index <0 || index >=size) {
			throw new Exception("数组越界!");
		}
		objs[index] = value;
	}
	public void clear() {
		size =0;
		objs = new Object[4];
	}
	public Object get(int index) throws Exception {
		if(index <0 || index >=size) {
			throw new Exception("数组越界!");
		}
		return objs[index];
	}

	public static void main(String[] args) throws Exception {
		MyArrayList my = new MyArrayList();
		my.add(11);
		my.add(12);
		my.add(13);
		my.add(14);
		my.add(15);
		
//		my.remove(0);
		my.set(0, 33);
		for(int i = 0;i<my.getSize();i++) {
			System.out.println(my.get(i));
		}
	}

}
