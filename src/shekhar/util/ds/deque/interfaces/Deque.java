/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.ds.deque.interfaces;

import shekhar.util.ds.deque.exceptions.DequeEmptyException;

public interface Deque {
  
  public void enqueueFirst(Object element);
  public void dequeueFirst() throws DequeEmptyException;
  
  public void enqueueLast(Object element);
  public void dequeueLast() throws DequeEmptyException ;
  
  public Object front() throws DequeEmptyException;
  public Object last() throws DequeEmptyException;
  
  public int size();
  
  public boolean isEmpty();

  public void traverse() throws DequeEmptyException ;
  
}
