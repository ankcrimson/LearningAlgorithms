package com.graphs.paths;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class QuickUnionFind {

  int[] parents;
  
  public QuickUnionFind(int N) {
    parents=new int[N];
    for(int i=0;i<N;i++) {
      parents[i]=i;
    }
  }
  
  public boolean find(int a, int b) {
    while(parents[a]!=a)
      a=parents[a];
    while(parents[b]!=b)
      b=parents[b];
    return a==b;
  }
  
  public void union(int x ,int y) {
    while(parents[x]!=x)
      x=parents[x];
    while(parents[y]!=y)
      y=parents[y];
    parents[y]=x;
  }
  
  public static void main(String[] args) throws Exception {
    //try(FileReader fr=new FileReader("src/main/resources/com.graphs.paths/mediumUF.txt");
    try(FileReader fr=new FileReader("src/main/resources/com.graphs.paths/mediumUF.txt");
                BufferedReader br=new BufferedReader(fr);
        ) {
      int N=Integer.parseInt(br.readLine());
      QuickUnionFind unionFind = new QuickUnionFind(N);
      String line="";
      while((line=br.readLine())!=null) {
        String[] ab=line.split(" ");
        unionFind.union(Integer.parseInt(ab[0]),Integer.parseInt(ab[1]));
      }
      
      for(int i=0;i<unionFind.parents.length;i++)
        System.out.println(i+" => "+unionFind.parents[i]);
      
      
      System.out.println(unionFind.find(5, 3));//f      
      System.out.println(unionFind.find(0, 3));//f      
      System.out.println(unionFind.find(3, 0));//f      
      System.out.println(unionFind.find(7, 8));//f      
      System.out.println(unionFind.find(6, 0));//true      
      System.out.println(unionFind.find(2, 6));//true      
      System.out.println(unionFind.find(2, 4));//f      
      System.out.println(unionFind.find(2, 3));//f      
      
      System.out.println(unionFind.find(473, 618));//true
      System.out.println(unionFind.find(473, 528));//true
      
      Set set = new HashSet<>();
      for(int i=0;i<unionFind.parents.length;i++) {
        int x=unionFind.parents[i];
        while(x!=unionFind.parents[x]) {
          x=unionFind.parents[x];
        }
        set.add(x);
      }
        
      System.out.println(set.size());
      
    }catch(Exception ex){ex.printStackTrace();}
    
  }

}
