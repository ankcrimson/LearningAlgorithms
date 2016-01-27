package com.graphs.paths;

import java.io.BufferedReader;
import java.io.FileReader;

/*
 * Dijkstra's Algorithm Version to calculate the shortest path from a node to any node
 * in a weighted graph
 * Assumption: input is sorted in terms of node number
 * */
public class DijkstraWithPath {
	public static final int numberofnodes=6;
public static void main(String[] args) {
	try{
		FileReader fr=new FileReader("src/main/resources/com.graphs.paths/dijkstra.in");
		BufferedReader br=new BufferedReader(fr);
		int[] wts=new int[numberofnodes];
		String[] pths=new String[numberofnodes];
		//wts[0]=0 in java by default
		pths[0]="1";
		for(int i=1;i<numberofnodes;i++)
		{
			wts[i]=Integer.MAX_VALUE;
			pths[i]=""+(i+1);
		}
		String line=null;
		while((line=br.readLine())!=null)
		{
			String[] vals=line.split(" ");
			int frm=Integer.parseInt(vals[0])-1;
			int to=Integer.parseInt(vals[1])-1;
			int wt=Integer.parseInt(vals[2]);
			if(wts[to]>(wts[frm])+wt)
				{
				wts[to]=(wts[frm])+wt;
				pths[to]=pths[frm]+" -> "+(to+1);
				}
		}
		for(int i=0;i<numberofnodes;i++)
		{
			System.out.println("Weight till "+(i+1)+" is "+wts[i]);
			System.out.println("Path: "+pths[i]+"\n");
		}
	}catch(Exception ex){ex.printStackTrace();}
}
}
