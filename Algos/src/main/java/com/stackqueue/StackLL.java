package com.stackqueue;

public class StackLL {
	
	Node top;
	
	private static class Node {
		Node next;
		int value;
	}
	
	public void push(int i) {
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
	
	public int pop() {
		if(top==null) return -1;
		Node curr=top;
		top=top.next;
		return curr.value;
	}

	public static void main(String[] args) {

		StackLL stackLL = new StackLL();
		stackLL.push(4);
		stackLL.push(10);
		System.out.println(stackLL.pop());
		System.out.println(stackLL.pop());
		System.out.println(stackLL.pop());

	}

}
