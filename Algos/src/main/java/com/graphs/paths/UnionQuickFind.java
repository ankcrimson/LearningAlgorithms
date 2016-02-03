package com.graphs.paths;

import java.io.BufferedReader;
import java.io.FileReader;

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
    if(x<y) {
      reWrite(x,y);
    }
    else
    {
      reWrite(y,x);
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
    try(FileReader fr=new FileReader("src/main/resources/com.graphs.paths/mediumUF.txt");
        BufferedReader br=new BufferedReader(fr);
        ) {
      int N=Integer.parseInt(br.readLine());
      UnionQuickFind unionFind = new UnionQuickFind(N);
      String line="";
      while((line=br.readLine())!=null) {
        String[] ab=line.split(" ");
        unionFind.union(Integer.parseInt(ab[0]),Integer.parseInt(ab[1]));
      }
      
      for(int i=0;i<unionFind.nodes.length;i++)
        System.out.println(i+" => "+unionFind.nodes[i]);
      System.out.println(unionFind.find(473, 618));//true
      System.out.println(unionFind.find(473, 528));//false
      
    }catch(Exception ex){ex.printStackTrace();}
    
  }

}
