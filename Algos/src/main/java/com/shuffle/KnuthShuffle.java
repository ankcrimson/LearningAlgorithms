package com.shuffle;

public class KnuthShuffle<T> {

  public void swap(T[] cards, int i, int j) {
    T tmp=cards[i];
    cards[i]=cards[j];
    cards[j]=tmp;
  }
  
  public void shuffle(T[] cards) {
    for(int i=1;i<cards.length;i++) {
      int rand=(int)(Math.random()*(i+1));
      swap(cards,i,rand);
    }
  }
  
  public static void main(String[] args) {
    String[] cards={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    KnuthShuffle<String> knuthShuffle = new KnuthShuffle();
    knuthShuffle.shuffle(cards);
    for(String card:cards)
      System.out.print(card+" ");
    System.out.println();
  }

}
