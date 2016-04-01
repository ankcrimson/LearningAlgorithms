package com.graphs;

import java.awt.Point;

import com.stackqueue.StackArray;

public class ConvexHullGrahamScan {

  /**
   * Square of distance between points a and b
   * Square because absolute distance is needed
   * @param a
   * @param b
   * @return
   */
  public int distSquare(Point a, Point b) {
    return (b.y-a.y)*(b.y-a.y)+(b.x-a.x)*(b.x-a.x);
  }
  
  /**
   * 
   * @param Reference
   * @param p
   * @param q
   * @return >0 when p is counter clockwise <0 when clockwise
   */
  public int compare(Point a, Point b, Point c) {
    int retval = (b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x);
    if(retval==0) {
     return (distSquare(a,c)-distSquare(a,b)); 
    }
      return retval;
  }
  
  public void swap(Point[] points, int i, int j) {
    Point tmp=points[i];
    points[i]=points[j];
    points[j]=tmp;
  }
  
  public void sort(Point[] points) {
    int terms=(points.length-2)/3;
    //sort on 3n+1....1 size buckets 
    for(int i=terms;i>=0;i--) {
      int bucket=3*i+1;
      for(int j=1+bucket;j<points.length;j+=bucket) {
        int t=j;//+bucket;
        while(t-bucket>=1&&compare(points[0],points[t-bucket],points[t])<0) {
         swap(points,t,t-bucket);
          t-=bucket;
        }
      }
    }
    
    
  }
  
  public void calculate(Point[] points) {
    //Find min y,x and place it at 0
    int min=0;
    for(int i=1;i<points.length;i++) {
      if(points[i].y<points[min].y || points[i].y==points[min].y&&points[i].x<points[min].x) {
        min=i;
      }
    }
      swap(points,min,0);
      
      //shell sort the points from 1 to length in terms of polar angles keeping 0 as ref start
      sort(points);
      
      // loop through the points and check if they break the rules
      //use stack to check every element for condition of counterclockwise movement
      
      StackArray<Point> hull=new StackArray<>();
      hull.push(points[0]);
      hull.push(points[1]);
      for(int i=2;i<points.length;i++) {
        Point b=hull.pop();
        Point a=hull.pop();
        if(compare(a, b, points[i])<=0) {
          hull.push(a);
          i--;
        } else {
          hull.push(a);
          hull.push(b);
          hull.push(points[i]);
        }
      }
      
      //modify the original array so that it gets the hull vals
      for(int i=0;i<points.length;i++) {
        points[i]=hull.pop();
      }
      
    System.out.println(points);
    
  }
  
  public static void main(String[] args) {
    ConvexHullGrahamScan convexHullGrahamScan = new ConvexHullGrahamScan();
    Point[] points = {new Point(0, 3),new Point(2, 2),new Point(1, 1),new Point(2, 1),new Point(3, 0),new Point(0, 0),
    new Point(4, 2),new Point(3, 3)};
    convexHullGrahamScan.calculate(points);
  }

}
