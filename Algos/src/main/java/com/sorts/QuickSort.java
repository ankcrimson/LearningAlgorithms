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
    int i=l, j=r;
    int pivot=(l+r)/2;
    while(i<=j) {
      while(less(arr[i],arr[pivot]))
        i++;
      while(less(arr[pivot],arr[j]))
        j--;
      if(i<=j) {
        swap(arr,i,j);
        i++;
        j--;
      }
    }
    return i;
  }
  
  public void sort(Comparable[] arr, int l, int r) {
     int ind=partition(arr, l, r);
     if(l<ind-1)
       sort(arr, l, ind-1);
     if(ind<r)
       sort(arr,ind,r);
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
