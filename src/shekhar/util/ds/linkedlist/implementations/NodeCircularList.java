/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.ds.linkedlist.implementations;

import shekhar.util.ds.linkedlist.interfaces.CircularList;

/**
 *
 * @author shekhar2010us
 */
public class NodeCircularList implements CircularList {

  @Override
  public void removeLast() {
    throw new UnsupportedOperationException("Deprecated."); //To change body of generated methods, choose Tools | Templates.
  }
  
  public class Node {
    Object object;
    Node next;
    
    Node() {}
    
    Node(Object o) {
      this();
      object = o;
    }
    
    public Object getObject() {
      return object;
    }
    
    public void setObject(Object o) {
      this.object = o;
    }
    
  }
  
  private static Node head;
  
  public NodeCircularList() {
    Node node = new Node();
    head = node;
  }
  
  @Override
  public Node getHead() {
    return head;
  }
  
  @Override
  public void addFirst(Object o) {
    Node newNode = new Node(o);
    
    if ( isEmpty() ) {
      head.next = newNode;
      newNode.next = newNode;
    } else {
      Node node = head.next;
      newNode.setObject(node.getObject());
      newNode.next = head.next.next;
      node.next = newNode;
      node.setObject(o);
    }
    
  }
  
  @Override
  public void addLast(Object o) {
    /*
     * same as addFirst
     */
    Node newNode = new Node(o);
    
    if ( isEmpty() ) {
      head.next = newNode;
      newNode.next = newNode;
    } else {
      Node node = head.next;
      newNode.setObject(node.getObject());
      newNode.next = head.next.next;
      node.next = newNode;
      node.setObject(o);
    }
    
  }
  
  @Override
  public void removeFirst() {
    Node node = head.next;
    
    if (node.next == head.next) {
      head = new Node();
    } else {
      node.setObject(node.next.getObject());
      node.next = node.next.next;
    }
  }
  
  @Override
  public void traverse() {
    Node node = head.next;
    
    System.out.print("head -> ");
    if ( isEmpty() ) {
      System.out.println("null");
    } else if (node.next == head.next) {
      System.out.println(node.getObject() + " -> back to (" + head.next.getObject()  + ")");
    } else {
      while ( node.next != head.next  ) {
        System.out.print( node.getObject() + " -> " );
        node = node.next;
      }
      System.out.println(node.getObject() + " -> back to (" + head.next.getObject()  + ")");
    }
    
  }
  
  @Override
  public boolean isEmpty() {
    
    if (head.next == null)
      return true;
    else
      return false;
  }
  
  @Override
  public int size() {
    int size = 0;
    Node node = head.next;
    
    if ( !(isEmpty()) ) {
      
      if (head.next == node.next) {
        return 1;
      } else {
        while ( node.next != head.next) {
          size++;
          node = node.next;
        }
        size++;
      }
    }
    return size;
  }
  
}
