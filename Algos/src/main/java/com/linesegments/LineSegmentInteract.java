package com.linesegments;

import java.awt.Point;

/**
 * To check if two line segments interact
 * @author Ankur Srivastava
 *
 */
public class LineSegmentInteract {

  //Point a,b,c,d;
  public LineSegmentInteract() {
//    a=new Point();
//    b=new Point();
//    c=new Point();
//    d=new Point();
  }
  
  /**
   * baca
   * @param a
   * @param b
   * @param c
   * @return
   */
  public int getOrientation(Point a, Point b, Point c) {
    int orinetation= (b.x-a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x);
    if(orinetation==0) return 0;//collinear
    return (orinetation>0)?1:-1;//counterclockwise/clockwise
  }
  
  /**
   * General Case
   * p1 q1 p2 and p1 q1 q2 should be at different polar angles
   * AND
   * p2 q2 p1 and p2 q2 p2 should be at different polar angles
   * 
   * Special case of onLine
   * p1 q1 p2 has polar angle of 0 and q1 falls on p1 p2 
   * and similar for other points
   * @return boolean
   */
  public boolean checkCondition(Point a, Point b, Point c, Point d) {
    //General Case
    int p=getOrientation(a, b, c);
    int q=getOrientation(a, b, d);
    int r=getOrientation(c, d, a);
    int s=getOrientation(c, d, b);
    if(p!=q&&r!=s) {
      return true;
    }
    if(p==0&&checkOnLine(a, c, b)) return true;
    if(q==0&&checkOnLine(a, d, b)) return true;
    if(r==0&&checkOnLine(c, a, d)) return true;
    if(s==0&&checkOnLine(c, b, d)) return true;
    return false;
  }
  
  public boolean checkOnLine(Point a, Point b, Point c) {
    if( 
        b.x>=Math.min(a.x, c.x)&&b.x<=Math.max(a.x, c.x) &&
        b.y>=Math.min(a.y, c.y)&&b.y<=Math.max(a.y, c.y)
        )
      return true;
     return false;
  }
  
  public boolean find(int ax, int ay, int bx, int by, int cx, int cy, int dx, int dy) {
    Point a = new Point(ax, ay);
    Point b = new Point(bx, by);
    Point c = new Point(cx, cy);
    Point d = new Point(dx, dy);
    return checkCondition(a, b, c, d);
  }
  
  public static void main(String[] args) {
    LineSegmentInteract lineSegmentInteract = new LineSegmentInteract();
    System.out.println(lineSegmentInteract.find(1, 1, 10, 1, 1, 2, 10, 2));
    System.out.println(lineSegmentInteract.find(1, 1, 10, 2, 1, 2, 10, 2));
    System.out.println(lineSegmentInteract.find(1, 1, 10, 2, 1, 1, 10, 2));
    System.out.println(lineSegmentInteract.find(1, 1, 5, 5, 1, 5, 5, 1));
    
  }

}
