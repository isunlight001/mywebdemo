package com.sunlight001.util;

public class MyLinkedList {
	
	int size = 0;
	Node head = null;
	public void add(Object value) {
		Node tmp = head;
		if(head == null) {
			head = new Node(value);
		}else {
			while(tmp.next!=null) {
				tmp = tmp.next;
			}
			tmp.next=new Node(value);
		}
		size++;
	}
	public void delete(int index) throws Exception {
		if(index<0 || index>=size) {
			throw new Exception("越界!");
		}
		Node tmp = head;
		for(int i = 0;i<index ;i++) {
			tmp = tmp.next;
		}
		
		
	}
	public static void main(String[] args) {

	}

}






class Node{
	 Object value;
	 Node next;
	 public Node(Object value) {
		 this.value= value;
	 }
	 public void setNext(Object value) {
		 this.next = new Node(value);
	 }
}