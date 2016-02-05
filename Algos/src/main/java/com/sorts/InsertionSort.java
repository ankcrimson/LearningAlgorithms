package com.sorts;

public class InsertionSort {
  static int swaps=0;
  public boolean less(Comparable a, Comparable b) {
    swaps++;
    if(a.compareTo(b)<0)
      return true;
    return false;
  }
  
  public void swap(Comparable[] arr, int i, int j) {
    Comparable tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
  
  public void sort(Comparable[] arr) {
    for(int i=1;i<arr.length;i++) {
      int j=i;
      while(j>0&&less(arr[j], arr[j-1])) {
        swap(arr, j, j-1);
        j--;
      }
    }
  }
  
  public static void main(String[] args) {
    InsertionSort insertionSort = new InsertionSort();
    String[] stringArr="THISISASORTEXAMPLE".split("");
    insertionSort.sort(stringArr);
    for(String s:stringArr)
      System.out.print(s);
    System.out.println();
    System.out.println("Swaps:"+swaps);
  }
}
