package com.helpers.models;

public class Activity implements Comparable<Activity> {
	int number;
	int start;
	int end;
	
	public Activity(int number, int start, int end) {
		this.number = number;
		this.start = start;
		this.end = end;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public int compareTo(Activity o) {
		if(this.getEnd()>o.getEnd())
			return 1;
		else if(this.getEnd()<o.getEnd())
			return -1;
		
		return 0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return number+","+start+","+end;
	}
}
