package com.graphs;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Start with leftmost and keep wrapping the most counterclockwise point
 * @author asriv5
 *
 */
public class ConvexHullJarvisAlgo {

  public boolean findPolarAngle(Point a, Point b, Point c) {
    int polarAngle = (b.x-a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x);
    if(polarAngle<0) return true;
    return false;
  }
  public List<Point> findHull(List<Point> graph) {
    List<Point> hull = new ArrayList<>();
    //find left most
    Point curr=graph.get(0);
    for(int i=0;i<graph.size();i++) {
      if(graph.get(i).x<curr.x) {
       curr=graph.get(i);
     }
    }
   
    do {
      hull.add(curr);
      Point ref=graph.get((graph.indexOf(curr)+1)%graph.size());
      for(Point p:graph) {
        if(findPolarAngle(curr, ref, p))
          ref=p;
      }
      
      curr=ref;
      
    }while(curr!=hull.get(0));
    
    return hull;
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ConvexHullJarvisAlgo convexHullJarvisAlgo = new ConvexHullJarvisAlgo();
    List<Point> points = new ArrayList<>();
    points.add(new Point(0, 3));
    points.add(new Point(2, 2));
    points.add(new Point(1, 1));
    points.add(new Point(2, 1));
    points.add(new Point(3, 0));
    points.add(new Point(0, 0));
    points.add(new Point(4, 2));
    points.add(new Point(3, 3));
    System.out.println(convexHullJarvisAlgo.findHull(points));
  }

}
