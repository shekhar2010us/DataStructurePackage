/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.test;

import shekhar.util.ds.deque.exceptions.DequeEmptyException;
import shekhar.util.ds.deque.implementations.DoublyListDeque;
import shekhar.util.ds.deque.interfaces.Deque;

/**
 *
 * @author shekhar2010us
 */
public class DequeTest {
  
  public static void main(String[] args) throws DequeEmptyException {
    
    Deque deque = new DoublyListDeque();
    
    deque.enqueueFirst("A");
    deque.enqueueFirst("B");
    deque.enqueueFirst(74);
    
    int size = deque.size();
    System.out.println("Size: " + size);
    deque.traverse();
    
    deque.dequeueFirst();
    
    System.out.println("--- First removed ---");
    System.out.println("Size: " + deque.size());
    deque.traverse();
    
    deque.enqueueLast("SH");
    deque.enqueueLast("SU");
    System.out.println("Size: " + deque.size());
    deque.traverse();
    
    
  }
  
}
