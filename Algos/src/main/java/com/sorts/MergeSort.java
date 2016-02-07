package com.sorts;

public class MergeSort {

  public boolean less(Comparable a, Comparable b) {
    return a.compareTo(b)<0;
  }
  
  private void merge(Comparable[] arr, int l, int m, int r) {
    int n1=m-l+1;
    Comparable[] leftArr=new Comparable[n1];
    int n2=r-m;
    Comparable[] rightArr=new Comparable[n2];
    int il=0,ir=0;
    for(int i=l;i<=r;i++) {
      if(i<=m) {
        leftArr[il++]=arr[i];
      } else {
        rightArr[ir++]=arr[i];
      }  
    }
    int jl=0,jr=0;
    for(int i=l;i<=r;i++) {
      Comparable val=null;
      if(jl==il) 
        val=rightArr[jr++];
      else if(jr==ir)
        val=leftArr[jl++];
      else {
        if(less(leftArr[jl], rightArr[jr])) {
          val=leftArr[jl++];
        }
        else {
          val=rightArr[jr++];
        }
      }
      arr[i]=val;
    }
    
  }
  
  //recursive function to break and call merge 
  private void sort(Comparable[] arr, int l, int r) {
    if(l<r) {
      int m=(l+r)/2;
      sort(arr, l, m);
      sort(arr, m+1, r);
      merge(arr, l, m, r);
    }
  }
  
  public void sort(Comparable[] arr) {
    sort(arr, 0, arr.length-1);
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    MergeSort mergeSort = new MergeSort();
    String[] stringArr="THISISASORTEXAMPLE".split("");
    mergeSort.sort(stringArr);
    for(String s:stringArr)
      System.out.print(s);
    System.out.println();
    //System.out.println("Swaps:"+swaps);
  }

}
