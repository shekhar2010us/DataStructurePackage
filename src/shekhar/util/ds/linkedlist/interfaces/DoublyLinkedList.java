package shekhar.util.ds.linkedlist.interfaces;

import shekhar.util.ds.linkedlist.exceptions.LinkedListEmptyException;
import shekhar.util.ds.linkedlist.implementations.NodeDoublyLinkedList.Node;

/**
 *
 * @author shekhar2010us
 */
public interface DoublyLinkedList {
  
  public void insertFirst(Object o);
  public void insertLast(Object o);
  
  public void removeFirst() throws LinkedListEmptyException;
  public void removeLast() throws LinkedListEmptyException;
  
  public boolean isEmpty();
  public int size();
  
  public Node getHead();
  public Node getTail();
  
  public void traverse();
  
}
