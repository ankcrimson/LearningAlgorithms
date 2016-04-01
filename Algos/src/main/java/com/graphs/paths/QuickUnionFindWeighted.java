package com.graphs.paths;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class QuickUnionFindWeighted {

  int[] parents;
  int[] weights;
  
  public QuickUnionFindWeighted(int N) {
    parents = new int[N];
    weights = new int[N];
    for(int i=0;i<N;i++) {
      parents[i]=i;
      weights[i]=1;
    }
  }
  
  public boolean find(int a, int b) {
    while(parents[a]!=a)
      {
      a=parents[a];
      parents[a]=parents[parents[a]];
      }
    while(parents[b]!=b)
      {
      b=parents[b];
      parents[b]=parents[parents[b]];
      }
    return a==b;
  }
  
  public void union(int x ,int y) {
    if(find(x, y))
      return;
    while(parents[x]!=x)
      x=parents[x];
    while(parents[y]!=y)
      y=parents[y];
    if(weights[y]<weights[x]) {
      parents[y]=x;
      weights[x]+=weights[y];
    }
    else {
      parents[x]=y;
      weights[y]+=weights[x];
    }
  }
  
  public static void main(String[] args) throws Exception {
    //try(FileReader fr=new FileReader("src/main/resources/com.graphs.paths/mediumUF.txt");
    try(FileReader fr=new FileReader("src/main/resources/com.graphs.paths/mediumUF.txt");
                    BufferedReader br=new BufferedReader(fr);
        ) {
      int N=Integer.parseInt(br.readLine());
      QuickUnionFindWeighted unionFind = new QuickUnionFindWeighted(N);
      String line="";
      while((line=br.readLine())!=null) {
        String[] ab=line.split(" ");
        unionFind.union(Integer.parseInt(ab[0]),Integer.parseInt(ab[1]));
      }
      
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
