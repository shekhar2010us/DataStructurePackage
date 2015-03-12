/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.ds.linkedlist.interfaces;

import shekhar.util.ds.linkedlist.implementations.NodeLinkedList.Node;

/**
 *
 * @author shekhar2010us
 */
public interface LinkedList {
  
  /*
   * Addtion done at the tail of the linkedlist
   * though its easy to add either at head or tail of the linkedlist
   */
  public void add(Object o);
  
  /*
   * Removal done at the head of the linkedlist, because removal at the tail is expensive
   * as we have to traverse the whole list to remove from tail
   */
  public void remove();
  
  
  /*
   * Traverse the linkedlist from head to tail
   */
  public void traverse();
  
  public boolean isEmpty();
  public int size();
  
  public Node getHead();
  public Node getTail();
  
}
