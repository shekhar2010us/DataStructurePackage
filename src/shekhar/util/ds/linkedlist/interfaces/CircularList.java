package shekhar.util.ds.linkedlist.interfaces;

import shekhar.util.ds.linkedlist.implementations.NodeCircularList.Node;

/**
 *
 * @author shekhar2010us
 */
public interface CircularList {
  
  /*
   * Addtion done at the tail of the linkedlist
   * though its easy to add either at head or tail of the linkedlist
   */
  public void addFirst(Object o);
  
  public void addLast(Object o);
  /*
   * Removal done at the head of the linkedlist, because removal at the tail is expensive
   * as we have to traverse the whole list to remove from tail
   */
  public void removeFirst();
  
  
  /**
   * @deprecated
   * removeLast()
   * useless, have to traverse entire list to remove from last
   */
  public void removeLast();
  
  /*
   * Traverse the linkedlist from head to tail
   */
  public void traverse();
  
  public boolean isEmpty();
  public int size();
  
  public Node getHead();
  
}
