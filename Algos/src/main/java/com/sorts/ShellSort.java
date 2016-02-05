package com.sorts;

public class ShellSort {
static int swaps=0;
  public boolean less(Comparable a, Comparable b) {
    if(a.compareTo(b)<0)
      return true;
    return false;
  }
  
  public void swap(Comparable[] arr, int i, int j) {
    swaps++;
    Comparable tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
  
  public void sortShell(Comparable[] arr, int k) {
    for(int i=k;i<arr.length;i+=k) {
      int j=i;
      while(j>0&&less(arr[j], arr[j-k])) {
        swap(arr, j, j-k);
        j-=k;
      }
    }
  }
  
  public void sort(Comparable[] arr) {
    int n = arr.length/3;
    n=n*3+1;
    while(n>0) {
      sortShell(arr, n);
      n-=3;
    }
      
    
  }
  
  public static void main(String[] args) {
    ShellSort mergeSort = new ShellSort();
    String[] stringArr="THISISASORTEXAMPLE".split("");
    mergeSort.sort(stringArr);
    for(String s:stringArr)
      System.out.print(s);
    System.out.println();
    System.out.println("Swaps:"+swaps);
  }
}
