package shekhar.util.ds.linkedlist.implementations;

import shekhar.util.ds.linkedlist.exceptions.LinkedListEmptyException;
import shekhar.util.ds.linkedlist.interfaces.DoublyLinkedList;

/**
 *
 * @author shekhar2010us
 */
public class NodeDoublyLinkedList implements DoublyLinkedList {
  
  private static Node head;
  private static Node tail;
  
  public class Node {
    public Object object;
    public Node next;
    public Node prev;
    
    Node() {}
    
    Node(Object o) {
      this();
      object = o;
    }
    
    public Object getObject() {
      return object;
    }
    
  }
  
  @Override
  public Node getHead() {
    return head;
  }
  
  @Override
  public Node getTail() {
    return tail;
  }
  
  public NodeDoublyLinkedList() {
    head = new Node();
    tail = new Node();
    
    head.next = tail;
    tail.prev = head;
  }
  
  @Override
  public void insertFirst(Object o) {
    Node node = new Node(o);
    
    if ( isEmpty() ) {    // if first element
      node.prev = head;
      node.next = tail;
      head.next = node;
      tail.prev = node;
    } else {                      // if not first element
      Node node2 = head.next;
      node.next = node2;
      node.prev = head;
      head.next = node;
      node2.prev = node;
    }
    
  }

  @Override
  public void insertLast(Object o) {
    Node node = new Node(o);
    
    if ( isEmpty() ) {    // if first element
      node.prev = head;
      node.next = tail;
      head.next = node;
      tail.prev = node;
    } else {                      // if not first element
      Node node2 = tail.prev;
      node.next = tail;
      node.prev = node2;
      tail.prev = node;
      node2.next = node;
    }
  }

  @Override
  public void removeFirst() throws LinkedListEmptyException {
    // remove the one closest to head
    
    if ( isEmpty() ) {
      throw new LinkedListEmptyException("Doubly Linked List is Empty.. ");
    } else {
      Node node = head.next.next;
      head.next = node;
      node.prev = head;
    }
    
  }

  @Override
  public void removeLast() throws LinkedListEmptyException {
    // the one closest to tail
    if ( isEmpty() ) {
      throw new LinkedListEmptyException("Doubly Linked List is Empty.. ");
    } else {
      Node node = tail.prev.prev;
      tail.prev = node;
      node.next = tail;
    }
  }
  
  @Override
  public boolean isEmpty() {
    return (head.next == tail);
  }
  
  @Override
  public int size() {
    int size = 0;
    
    Node node = head.next;
    
    while (node.next != null) {
      node = node.next;
      size++;
    }
    
    return size;
  }
  
  /*
   * Traverse the linkedlist from head to tail
   */
  @Override
  public void traverse() {
    Node node = head.next;
    
    System.out.print("Head -> ");
    
    while ( node.next != null ) {
      System.out.print(node.object + " -> ");
      node = node.next;
    }
    System.out.println("Tail");
    
  }
  
}
