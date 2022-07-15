package io.anthonygraca.princeton.chapter2.KdTree;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.ArrayList;

public class KdTree {
  private static class Node {
    Node(Point2D p, RectHV rect, Node lt, Node rt) {
      p_ = p;
      rect_ = rect;
      lt_ = lt;
      rt_ = rt;
    }
    private Point2D p_ = null;
    private RectHV rect_ = null;
    private Node lt_ = null;
    private Node rt_ = null;
  };

  private class Rectangle {
    public RectHV create() {
      return new RectHV(x_min, y_min, x_max, y_max);
    }
    double x_min = 0.0;
    double x_max = 1.0;
    double y_min = 0.0;
    double y_max = 1.0;
  }

  private Node root_ = null;
  private int size_ = 0;

  public boolean isEmpty() {
    return size_ == 0;
  }

  public int size() {
    return size_;
  }

  public void insert(Point2D p) {
    if (p == null) throw new IllegalArgumentException("input is null");
    if (contains(p)) return;
    Rectangle r = new Rectangle();
    root_ = insert(root_, p, 0, r); 
    size_++;
  }

  private Node insert(Node x, Point2D p, int depth, Rectangle r) {
    if (x == null) {
      return new Node(p, r.create(), null, null);
    }
    int axis = depth % 2;
    if (axis == 0) { // look at x axis
      if (p.x() < x.p_.x()) {
        r.x_max = x.p_.x();
        x.lt_ = insert(x.lt_, p, depth + 1, r);
      }
      else {
        r.x_min = x.p_.x();
        x.rt_ = insert(x.rt_, p, depth + 1, r);
      }
    }
    else { // look at y axis
      if (p.y() < x.p_.y()) {
        r.y_max = x.p_.y();
        x.lt_ = insert(x.lt_, p, depth + 1, r);
      }
      else {
        r.y_min = x.p_.y();
        x.rt_ = insert(x.rt_, p, depth + 1, r);
      }
    }
    return x;
  }

  public boolean contains(Point2D p) {
    if (p == null) throw new IllegalArgumentException("input is null");
    if (root_ == null) return false;
    if (root_.p_ == p) return true;
    Point2D n = get(p);
    return p.equals(n);
  }

  private Point2D get(Point2D p) {
    return get(root_, p, 0);
  }

  private Point2D get(Node x, Point2D key, int depth) {
    if (x == null) return null;
    if (key.equals(x.p_)) return x.p_;
    int axis = depth % 2;
    if (axis == 0) { // look at x axis
      if (key.x() < x.p_.x()) {
        return get(x.lt_, key, depth + 1);
      }
      else {
        return get(x.rt_, key, depth + 1);
      }
    }
    else { // look at y axis
      if (key.y() < x.p_.y()) {
        return get(x.lt_, key, depth + 1);
      }
      else {
        return get(x.rt_, key, depth + 1);
      }
    }
  }
  
  public Point2D nearest(Point2D p) {
    if (p == null) throw new IllegalArgumentException("input is null");
    return nearest(root_, p, 0);
  }

  private Point2D nearest(Node x, Point2D p, int depth) {
    if (x == null) return null;
    Node next = null;
    Node other = null;
    int axis = depth % 2;
    if (axis == 0) { // look at x
      if (p.x() < x.p_.x()) {
        next = x.lt_;
        other = x.rt_;
      }
      else {
        next = x.rt_;
        other = x.lt_;
      }
    }
    else { // look at y
      if (p.y() < x.p_.y()) {
        next = x.lt_;
        other = x.rt_;
      }
      else {
        next = x.rt_;
        other = x.lt_;
      }
    }

    Point2D temp = nearest(next, p, depth + 1);
    Point2D best = closest(p, temp, x.p_);

    double distance = p.distanceSquaredTo(best);

    if (distance >= x.rect_.distanceSquaredTo(p)) {
      temp = nearest(other, p, depth+1);
      best = closest(p, temp, best);
    }
    return best;

  }

  private Point2D closest(Point2D p, Point2D x, Point2D y) {
    if (x == null && y == null) return null;
    else if (x != null && y != null) {
      if (p.distanceSquaredTo(x) < p.distanceSquaredTo(y)) {
        return x;
      }
      else {
        return y;
      }
    }
    else if (x == null && y != null) {
      return y;
    }
    else {
      return x;
    }
  }
                

  public Iterable<Point2D> range(RectHV rect) {
    if (rect == null) throw new IllegalArgumentException("input is null");
    ArrayList<Point2D> list = new ArrayList<Point2D>();
    range(root_, rect, list);
    return list;
  }
  
  private void range(Node x, RectHV rect, ArrayList<Point2D> list) {
    if (x.lt_ != null && rect.intersects(x.lt_.rect_)) range(x.lt_, rect, list);
    if (x.rt_ != null && rect.intersects(x.rt_.rect_)) range(x.rt_, rect, list);
    if (rect.contains(x.p_)) list.add(x.p_);
  }

  public void draw() {}
}
