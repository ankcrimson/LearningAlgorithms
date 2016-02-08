package com.sorts;

public class MergeSortBottumUp {

  public boolean less(Comparable a, Comparable b) {
    return a.compareTo(b)<0;
  }
  
  public void merge(Comparable[] arr, int l, int m, int r) {
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

  
  //non-recursive function to break and call merge 
  private void sort(Comparable[] arr, int l, int r) {
    int i=0;
    for(i=2;i<=r;i*=2) { //bucket size loop
     for(int j=0;j<=r;j+=i) {
       int right=Math.min(j+i-1, r);
       int m=(j+right)/2;
       //System.out.println("i:"+i+", j:"+j+", m:"+((j+right)/2)+", r:"+right);
       //print(arr, j, right);
       merge(arr, j, m, right);
       //print(arr, j, right);
       //System.out.println();
       
     }
    }
    merge(arr, 0, i/2-1, r);
  }
  
  public void print(Comparable[] arr,int  i, int j) {
    for(int k=i;k<=j;k++)
      System.out.print(">>"+arr[k]+"<<");
    System.out.println();
  }
  public void sort(Comparable[] arr) {
    sort(arr, 0, arr.length-1);
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    MergeSortBottumUp mergeSort = new MergeSortBottumUp();
    String[] stringArr="THISISASORTEXAMPLE".split("");
    mergeSort.sort(stringArr);
    for(String s:stringArr)
      System.out.print(s);
    System.out.println();
    //System.out.println("Swaps:"+swaps);
  }

}
