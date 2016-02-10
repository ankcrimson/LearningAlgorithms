package com.sorts;

/**
 * Class to perform quicksort
 * @author asriv5
 *
 */
public class QuickSort {

  public void swap(Comparable[] arr, int i, int j) {
    Comparable tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
  
  public void shuffle(Comparable[] arr) {
    for(int i=1;i<arr.length;i++) {
      int rand=(int)(Math.random()*(i+1));
      swap(arr, rand, i);
    }
  }
  
  public boolean less(Comparable a, Comparable b) {
    return a.compareTo(b)<0;
  }
  
  public int partition(Comparable[] arr, int l, int r) {
    int i=l-1;
    int pivot=r;
    for(int j=l;j<r;j++)
      if(less(arr[j],arr[pivot])) {
        i++;
        swap(arr,i,j);
        
      }
  
  i++;
  swap(arr,i,pivot);
  return i;
  }
  
  public void sort(Comparable[] arr, int l, int r) {
     if(l<r) {
       int pivot=partition(arr, l, r);
       sort(arr, l, pivot-1);
       sort(arr,pivot+1,r);
     }
  }
  
  public void sort(Comparable[] arr) {
    shuffle(arr);
    sort(arr, 0, arr.length-1);
  }
  
  public void print(Comparable[] arr, int l, int r) {
    for(int i=l;i<=r;i++) {
      System.out.print(arr[i]+" ");
    }
  //  System.out.println();
  }
  
  public static void main(String[] args) {
    QuickSort quickSort = new QuickSort();
    String[] stringArr="AQUICKBROWNFOXJUMPSOVERTHELAZYDOG".split("");
    quickSort.sort(stringArr);
    quickSort.print(stringArr,0,stringArr.length-1);
  }

}
