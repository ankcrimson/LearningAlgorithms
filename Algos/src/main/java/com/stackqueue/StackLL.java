package com.stackqueue;

public class StackLL<T> {
	
	Node top;
	
	private static class Node<T> {
		Node next;
		T value;
	}
	
	public void push(T i) {
		Node node = new Node();
		node.value=i;
		
		if(top==null)
		{
			top=node;
		} else {
			node.next=top;
			top=node;
		}
	}
	
	public T pop() {
		if(top==null) return null;
		Node curr=top;
		top=top.next;
		return (T)curr.value;
	}

	public static void main(String[] args) {

		StackLL<Integer> stackLL = new StackLL<Integer>();
		stackLL.push(4);
		stackLL.push(10);
		System.out.println(stackLL.pop());
		System.out.println(stackLL.pop());
		System.out.println(stackLL.pop());

	}

}
