/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.ds.stack.implementations;

import java.util.logging.Level;
import java.util.logging.Logger;
import shekhar.util.ds.deque.exceptions.DequeEmptyException;
import shekhar.util.ds.deque.implementations.DoublyListDeque;
import shekhar.util.ds.deque.interfaces.Deque;
import shekhar.util.ds.stack.exceptions.StackEmptyException;
import shekhar.util.ds.stack.interfaces.Stack;

/**
 *
 * @author shekhar2010us
 */

public class DequeStack  implements Stack {

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
  public Object top() throws StackEmptyException {
    if (deque.isEmpty())
      throw new StackEmptyException("Empty Stack");
    else
      try {
      return deque.last();
    } catch (DequeEmptyException ex) {
      Logger.getLogger(DequeStack.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  @Override
  public void push(Object element) {
    deque.enqueueLast(element);
  }

  @Override
  public Object pop() throws StackEmptyException {
    if (deque.isEmpty())
      throw new StackEmptyException("Empty Stack");
    else
      try {
      deque.dequeueLast();
    } catch (DequeEmptyException ex) {
      Logger.getLogger(DequeStack.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  
  
  
}
