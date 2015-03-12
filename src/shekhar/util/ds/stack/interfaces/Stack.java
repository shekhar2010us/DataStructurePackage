package shekhar.util.ds.stack.interfaces;

import shekhar.util.ds.stack.exceptions.StackEmptyException;

/**
 *
 * @author shekhar2010us
 */

public interface Stack {
  
  // access methods
  public int size();
  public boolean isEmpty();
  public Object top() throws StackEmptyException;
  
  // update methods
  public void push(Object element);
  public Object pop() throws StackEmptyException;
  
}