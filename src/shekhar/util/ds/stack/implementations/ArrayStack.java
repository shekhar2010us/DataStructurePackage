package shekhar.util.ds.stack.implementations;

import shekhar.util.ds.stack.exceptions.StackEmptyException;
import shekhar.util.ds.stack.interfaces.Stack;

/**
 *
 * @author shekhar2010us
 */
public class ArrayStack implements Stack {
  
  public static final int CAPACITY = 64;  // default capacity of the stack
  private int N;                            // maximum capacity of the stack
  private Object stack[];                   // S holds the elements of the stack
  private int top = -1;                     // top element of the stack
  
  public ArrayStack() {
    N = CAPACITY;
    stack = new Object[N];
  };
  
  public ArrayStack( int capacity ) {
    N = capacity;
    stack = new Object[N];
  }
  
  
  @Override
  public int size() {
    return (top + 1);
  }
  
  @Override
  public boolean isEmpty() {
      return (top < 0);
  }

  @Override
  public Object top() throws StackEmptyException {
    if ( isEmpty() )
      throw new StackEmptyException("Empty Stack");
    return stack[top];
  }
  
  @Override
  public void push(Object element) {
    if ( size() == N ) {
      growArray();
    }
    stack[++top] = element;
  }

  @Override
  public Object pop() throws StackEmptyException {
    
    if ( isEmpty() )
      throw new StackEmptyException("Empty Stack");
    Object elem = stack[top];
    stack[top--] = null;
    return elem;
  }

  private void growArray() {
    N *= 2;
    //System.out.println("New Capacity: " + N);
    Object[] newStack = new Object[N];
    for ( int i = 0 ; i < stack.length; ++i ) {
      newStack[i] = stack[i];
    }
    stack = newStack;
  }
  
}






















