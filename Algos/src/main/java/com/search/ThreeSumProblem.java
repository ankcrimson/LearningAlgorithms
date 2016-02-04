package com.search;

/*
 * Application of binary search, find the possible triples in an array that sum to 0
 */

public class ThreeSumProblem {

  /**
   * Binary Search Function
   * @param sorted
   * @param val
   * @return
   */
  public int find(int[] sorted,int val) {
    int a=0,b=sorted.length-1;
    int mid=(a+b)/2;
    while(a<=b) {
      if(sorted[mid]==val)
        return mid;
      if(sorted[mid]<val)
        a=mid+1;
      else
        b=mid-1;
      mid=(a+b)/2;
    }
    return -1;
  }
  
  
  public void findThreeSums(int[] sorted) {
    for(int i=0;i<sorted.length;i++) {
      for(int j=i+1; j<sorted.length; j++) {
        int val=-(sorted[i]+sorted[j]);
        if(find(sorted, val)>-1) {
          System.out.println(sorted[i]+", "+sorted[j]+", "+val);
        }
      }
    }
    
  }
  
  public static void main(String[] args) {
    ThreeSumProblem threeSumProblem = new ThreeSumProblem();
    int[] arr=new int[5];
    arr[0]=-40;
    arr[1]=-10;
    arr[2]=10;
    arr[3]=20;
    arr[4]=30;
    
    threeSumProblem.findThreeSums(arr);
  }

}
