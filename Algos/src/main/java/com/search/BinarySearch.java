package com.search;

public class BinarySearch {

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
  
  public static void main(String[] args) {
    BinarySearch binarySearch = new BinarySearch();
    
    int[] arr=new int[10];
    for(int i=0;i<10;i++) {
      arr[i]=i*5;
    }
    
    System.out.println(binarySearch.find(arr, 15));
    System.out.println(binarySearch.find(arr, 16));
  }

}
