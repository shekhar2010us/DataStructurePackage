package shekhar.util.ds.linkedlist.implementations;

import shekhar.util.ds.linkedlist.interfaces.LinkedList;

/**
 *
 * @author shekhar2010us
 */
public class NodeLinkedList implements LinkedList {
  
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
    
  }
  
  private static Node head;
  private static Node tail;
  
  @Override
  public Node getHead() {
    return head;
  }
  
  @Override
  public Node getTail() {
    return tail;
  }
  
  public NodeLinkedList() {
    head = null;
  }
  
  /*
   * Addtion done at the tail of the linkedlist
   * though its easy to add either at head or tail of the linkedlist
   */
  @Override
  public void add(Object element) {
    Node node = new Node(element);
    node.next = null;
    
    if (head == null) {
      head = node;
      tail = head;
    } else {
      tail.next = node;
      tail = node;
    }
    //System.out.println(element + " inserted");
  }
  
  /*
   * Removal done at the head of the linkedlist, because removal at the tail is expensive
   * as we have to traverse the whole list to remove from tail
   */
  @Override
  public void remove() {
    //System.out.println(head.object + " removed");
    head = head.next;
  }
  
  /*
   * Traverse the linkedlist from head to tail
   */
  @Override
  public void traverse() {
    Node node = head;
    
    while ( node.next != null ) {
      System.out.print(node.object + " -> ");
      node = node.next;
    }
    System.out.println(node.object);
    
  }
  
  @Override
  public boolean isEmpty() {
    return (head == null);
  }
  
  @Override
  public int size() {
    int size = 0;
    
    Node node = head;
    while ( node.next != null) {
      node = node.next;
      size++;
    }
    size++;
    return size;
  }
  
}
