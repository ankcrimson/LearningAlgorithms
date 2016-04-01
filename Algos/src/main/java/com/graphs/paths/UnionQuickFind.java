package com.graphs.paths;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class UnionQuickFind {

  int[] nodes;
  
  public UnionQuickFind(int N) {
    nodes=new int[N];
    for(int i=0;i<N;i++) {
      nodes[i]=i;
    }
  }
  
  public boolean find(int a, int b) {
    if(nodes[a]==nodes[b])
      return true;
    else return false;
  }
  
  public void union(int x ,int y) {
    if(!find(x,y)) {
      reWrite(x,y);
    }
  }
  
  public void reWrite(int a, int b) {
    for(int i=0;i<nodes.length;i++)
    {
      if(nodes[i]==nodes[a])
        nodes[i]=nodes[b];
    }
  }
  
  public static void main(String[] args) throws Exception {
    //try(FileReader fr=new FileReader("src/main/resources/com.graphs.paths/mediumUF.txt");
    try(FileReader fr=new FileReader("src/main/resources/com.graphs.paths/tinyUF.txt");
           BufferedReader br=new BufferedReader(fr);
        ) {
      int N=Integer.parseInt(br.readLine());
      UnionQuickFind unionFind = new UnionQuickFind(N);
      String line="";
      while((line=br.readLine())!=null) {
        String[] ab=line.split(" ");
        unionFind.union(Integer.parseInt(ab[0]),Integer.parseInt(ab[1]));
      }
      
      Set set = new HashSet<>();
      for(int i:unionFind.nodes)
        set.add(i);
      System.out.println(set.size());
    }catch(Exception ex){ex.printStackTrace();}
    
  }

}
