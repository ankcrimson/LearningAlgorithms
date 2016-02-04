package com.stackqueue;

public class StackArray<T> {

	T[] vals;
	int top;
	
	public StackArray(){
		this(4);
	}
	
	public StackArray(int N) {
		vals = (T[])new Object[N];
		top=-1;
	}
	
	private void upSize(){
		int newLen = vals.length*2;
		T[] resizedArr =(T[]) new Object[newLen];
		for(int i=0;i<vals.length;i++)
			resizedArr[i]=vals[i];
		vals=resizedArr;
		System.out.println("Upsized to "+newLen);
	}
	
	private void downSize(){
		int newLen = vals.length/2;
		T[] resizedArr =(T[]) new Object[newLen];
		for(int i=0;i<=top;i++)
			resizedArr[i]=vals[i];
		vals=resizedArr;		
		System.out.println("Downsized to "+newLen);
	}
	
	public void push(T i) {
		top++;
		if(top==vals.length) {
			upSize();
		}
		vals[top]=i;
	}
	
	public T pop() {
		if(top==-1) return null;
		if(top<vals.length/4)
			downSize();
		T val=vals[top];
		vals[top]=null;
		top--;
		return val;
	}
	
	public static void main(String[] args) {
		StackArray stackArray = new StackArray();
		stackArray.push(3);
		stackArray.push(5);
		stackArray.push(1);
		stackArray.push(2);
		stackArray.push(7);
		stackArray.push(8);
		System.out.println(stackArray.pop());
		System.out.println(stackArray.pop());
		System.out.println(stackArray.pop());
		System.out.println(stackArray.pop());
		System.out.println(stackArray.pop());
		System.out.println(stackArray.pop());
		System.out.println(stackArray.pop());
	}

}
