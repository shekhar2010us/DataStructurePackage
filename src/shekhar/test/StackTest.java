package shekhar.test;

import shekhar.util.ds.stack.exceptions.StackEmptyException;
import shekhar.util.ds.stack.implementations.ArrayStack;
import shekhar.util.ds.stack.implementations.DequeStack;
import shekhar.util.ds.stack.interfaces.Stack;

/**
 *
 * @author shekhar2010us
 */
public class StackTest {
  
  public static void main(String [] args) throws StackEmptyException {
    
    array();
    System.out.println("=================");
    deque();
    
  }

  private static void array() throws StackEmptyException {
    Stack s = new ArrayStack();
    
    s.push("A");
    s.push("B");
    s.push(74);
    
    System.out.println( "Size: " + s.size());
    
    for (int i = 0 ; i < 2 ; ++i) {
      System.out.println( "Top: " + s.top() );
      s.pop();
      System.out.println("popped");
    }
    
    System.out.println( "Size: " + s.size());
    System.out.println( "Top: " + s.top());
    
  }

  private static void deque() throws StackEmptyException {
    Stack s = new DequeStack();
    
   
    s.push("A");
    s.push("B");
    s.push(74);
    
    System.out.println( "Size: " + s.size());
    
    for (int i = 0 ; i < 2 ; ++i) {
      Object o = s.top();
      System.out.println( "Top: " + s.top() );
      s.pop();
      System.out.println("popped");
    }
    
    System.out.println( "Size: " + s.size());
    System.out.println( "Top: " + s.top());
    
  }
  
  
}
