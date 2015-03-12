/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.ds.queue.interfaces;

import shekhar.util.ds.queue.exceptions.QueueEmptyException;
import shekhar.util.ds.queue.exceptions.QueueFullException;

/**
 *
 * @author shekhar2010us
 */

public interface Queue {
  
  public void enqueue(Object element) throws QueueFullException;
  public void dequeue() throws QueueEmptyException;
  
  public Object front() throws QueueEmptyException;
  
  public int size();
  
  public boolean isEmpty();
  
}
