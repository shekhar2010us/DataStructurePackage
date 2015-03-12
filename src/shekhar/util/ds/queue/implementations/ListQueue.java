/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.ds.queue.implementations;

import shekhar.util.ds.linkedlist.implementations.NodeLinkedList;
import shekhar.util.ds.linkedlist.interfaces.LinkedList;
import shekhar.util.ds.queue.exceptions.QueueEmptyException;
import shekhar.util.ds.queue.exceptions.QueueFullException;
import shekhar.util.ds.queue.interfaces.Queue;

/**
 *
 * @author shekhar2010us
 */
public class ListQueue implements Queue {
  
  private LinkedList list;

  public ListQueue() {
    list = new NodeLinkedList();
  }
  
  @Override
  public void enqueue(Object element) {
    // enqueue at tail
    list.add(element);
  }

  @Override
  public void dequeue() throws QueueEmptyException {
    // dequeue from head
    if ( list.isEmpty() )
      throw new QueueEmptyException("Queue is Empty..");
    
    list.remove();
  }

  @Override
  public Object front() throws QueueEmptyException {
    // show head element
    if ( list.isEmpty() )
      throw new QueueEmptyException("Queue is Empty..");
    
    return list.getHead().getObject();
  }

  @Override
  public int size() {
    // call size method
    return list.size();
  }

  @Override
  public boolean isEmpty() {
    // call isempty method
    return list.isEmpty();
  }
  
}
