package com.stackqueue;

import javax.swing.DebugGraphics;


public class QueueArray {

	int[] arr;
	int start;
	int stop;
	int size;
	
	public QueueArray(int N) {
		arr=new int[N];
		start=stop=-1;
	}
	public QueueArray() {
		this(4);
	}
	
	public void upScale() {
		int[] newArr=new int[arr.length*2];
		for(int i=0;i<size;i++) {
			newArr[i]=arr[start++];
			if(start==arr.length)
				start=0;
		}
		start=0;
		stop=size-1;
		arr=newArr;
	}
	public void downScale() {
		int[] newArr=new int[arr.length/2];
		for(int i=0;i<size;i++) {
			newArr[i]=arr[start++];
			if(start==arr.length)
				start=0;
		}
		start=0;
		stop=size-1;
		arr=newArr;
	}

	private void increment(boolean incStart) {
		if(incStart) {
			if(size<arr.length/4)
				downScale();
			start++;
			if(start==arr.length)
				start=0;
		} else {
			if(size==arr.length) {
				upScale();
			}
			stop++;
			if(stop==arr.length)
				stop=0;
		}
	}

	public void enqueue(int item) {
		if(start==-1) {
			start=stop=0;
			arr[stop]=item;
		} else {
		increment(false);
		arr[stop]=item; 
		}
		size++;
	}
	
	public int dequeue() {
		if(size==0) return -1;
		int val = arr[start];
		arr[start]=-1;
		increment(true);
		size--;
		return val;
	}
	
	public void debug() {
	//	System.out.println();
		for(int a:arr)
			System.out.print(a+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueArray queueLL = new QueueArray();
		queueLL.enqueue(3);
		queueLL.enqueue(8);
		System.out.println(queueLL.dequeue());
		queueLL.enqueue(1);
		//queueLL.debug();
		System.out.println(queueLL.dequeue());
		queueLL.enqueue(2);
		queueLL.enqueue(6);
		//queueLL.debug();
		queueLL.enqueue(7);
		//queueLL.debug();
		queueLL.enqueue(5);
		//queueLL.debug();
		System.out.println(queueLL.dequeue());
		queueLL.enqueue(9);
		//queueLL.debug();
		System.out.println(queueLL.dequeue());
		System.out.println(queueLL.dequeue());
		System.out.println(queueLL.dequeue());
		System.out.println(queueLL.dequeue());
		System.out.println(queueLL.dequeue());
		System.out.println(queueLL.dequeue());
		queueLL.enqueue(2);
		queueLL.enqueue(6);
		queueLL.enqueue(5);
		System.out.println(queueLL.dequeue());
		System.out.println(queueLL.dequeue());
		System.out.println(queueLL.dequeue());
		System.out.println(queueLL.dequeue());
		
	}
}
