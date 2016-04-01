package com.greedy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

import com.helpers.models.Activity;

public class ActivitySelection {
	
	public static void main(String[] args) {
		Activity[] activities=null;
		try(
				FileReader fr = new FileReader("src/main/resources/com.greedy/activities.txt");
				BufferedReader br = new BufferedReader(fr);
				){
			int n = Integer.parseInt(br.readLine());
			activities = new Activity[n];
			for(int i=0;i<activities.length;i++) {
				String[] sf = br.readLine().split(",");
				activities[i] = new Activity(i,Integer.parseInt(sf[0]),Integer.parseInt(sf[1]));
			}
			
		}catch(Exception ex){ex.printStackTrace();}
		 Arrays.sort(activities);
		 int currentEnd=0;
		 for(Activity activity: activities) {
			 if(activity.getStart()>=currentEnd) {
				 System.out.println(activity);
				 currentEnd=activity.getEnd();
			 }
		 }
	}

}
