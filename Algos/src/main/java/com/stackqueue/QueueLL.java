package com.stackqueue;


public class QueueLL<T> {

	Node start;
	Node stop;
	
	private static class Node<T> {
		Node next;
		T value;
	}
	
	public void enqueue(T item) {
		Node<T> node = new Node<T>();
		node.value = item;
		if(start==null) {
			start=node;
			stop=node;
			return;
		}
		stop.next = node;
		stop=node;
	}
	
	public T dequeue() {
		if(start==null) return null;
		Node<T> popped=start;
		start=start.next;
		return popped.value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueLL<Integer> queueLL = new QueueLL<>();
		queueLL.enqueue(3);
		queueLL.enqueue(8);
		System.out.println(queueLL.dequeue());
		System.out.println(queueLL.dequeue());
		System.out.println(queueLL.dequeue());
	}

}
