package shekhar.util.ds.deque.implementations;

import java.util.logging.Level;
import java.util.logging.Logger;
import shekhar.util.ds.deque.exceptions.DequeEmptyException;
import shekhar.util.ds.deque.interfaces.Deque;
import shekhar.util.ds.linkedlist.exceptions.LinkedListEmptyException;
import shekhar.util.ds.linkedlist.implementations.NodeDoublyLinkedList;
import shekhar.util.ds.linkedlist.implementations.NodeDoublyLinkedList.Node;
import shekhar.util.ds.linkedlist.interfaces.DoublyLinkedList;

/**
 *
 * @author shekhar2010us
 */

public class DoublyListDeque implements Deque {

  private DoublyLinkedList list;
  
  public DoublyListDeque() {
    list = new NodeDoublyLinkedList();
  }
  
  @Override
  public void enqueueFirst(Object element) {
    list.insertFirst(element);
  }

  @Override
  public void dequeueFirst() throws DequeEmptyException {
    
    if ( (list.isEmpty()) )
      throw new DequeEmptyException("Deque is empty..");
    try {
      list.removeFirst();
    } catch (LinkedListEmptyException ex) {
      Logger.getLogger(DoublyListDeque.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  public void enqueueLast(Object element) {
    list.insertLast(element);
  }

  @Override
  public void dequeueLast() throws DequeEmptyException {
    
    if ( (list.isEmpty()) )
      throw new DequeEmptyException("Deque is empty..");
    try {
      list.removeLast();
    } catch (LinkedListEmptyException ex) {
      Logger.getLogger(DoublyListDeque.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  @Override
  public Object front() throws DequeEmptyException {
    Node node = list.getHead();
    if ( (list.isEmpty()) )
      throw new DequeEmptyException("Deque is empty..");
    
    return node.next.getObject();
  }
  
  @Override
  public Object last() throws DequeEmptyException {
    Node node = list.getTail();
    if ( (list.isEmpty()) )
      throw new DequeEmptyException("Deque is empty..");
    
    return node.prev.getObject();
  }

  @Override
  public int size() {
    return list.size();
  }

  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }

  @Override
  public void traverse() throws DequeEmptyException {
    if ( (list.isEmpty()) )
      throw new DequeEmptyException("Deque is empty..");
    
    list.traverse();
    
  }
  
}
