/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.ds.queue.implementations;

import java.util.logging.Level;
import java.util.logging.Logger;
import shekhar.util.ds.deque.exceptions.DequeEmptyException;
import shekhar.util.ds.deque.implementations.DoublyListDeque;
import shekhar.util.ds.deque.interfaces.Deque;
import shekhar.util.ds.queue.exceptions.QueueEmptyException;
import shekhar.util.ds.queue.exceptions.QueueFullException;
import shekhar.util.ds.queue.interfaces.Queue;
import shekhar.util.ds.stack.exceptions.StackEmptyException;
import shekhar.util.ds.stack.interfaces.Stack;

/**
 *
 * @author shekhar2010us
 */

public class DequeQueue  implements Queue {

  Deque deque = new DoublyListDeque();
  
  @Override
  public int size() {
    return deque.size();
  }

  @Override
  public boolean isEmpty() {
    return deque.isEmpty();
  }
  
  @Override
  public void enqueue(Object element) {
    deque.enqueueFirst(element);
  }
  
  @Override
  public Object front() throws QueueEmptyException {
    if (deque.isEmpty())
      throw new QueueEmptyException("Empty Queue");
    else
      try {
      return deque.last();
    } catch (DequeEmptyException ex) {
      Logger.getLogger(DequeQueue.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  @Override
  public void dequeue() throws QueueEmptyException {
    if (deque.isEmpty())
      throw new QueueEmptyException("Empty Queue");
    else
      try {
      deque.dequeueLast();
    } catch (DequeEmptyException ex) {
      Logger.getLogger(DequeQueue.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  
  
}
