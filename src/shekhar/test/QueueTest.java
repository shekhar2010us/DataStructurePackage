package shekhar.test;

import shekhar.util.ds.queue.exceptions.QueueEmptyException;
import shekhar.util.ds.queue.exceptions.QueueFullException;
import shekhar.util.ds.queue.implementations.ArrayQueue;
import shekhar.util.ds.queue.implementations.DequeQueue;
import shekhar.util.ds.queue.implementations.ListQueue;
import shekhar.util.ds.queue.interfaces.Queue;

/**
 *
 * @author shekhar2010us
 */

public class QueueTest {
  
  public static void main(String[] args) throws QueueFullException, QueueEmptyException {
    arrayQ();
    System.out.println("****************************");
    linkedlistQ();
    System.out.println("****************************");
    dequeQ();
  }
  
  public static void arrayQ() throws QueueEmptyException, QueueFullException {
    Queue q = new ArrayQueue();
    
    for (int i = 0 ; i < 5; ++i) {
      System.out.println(i + " enqueued");
      q.enqueue(i);
    }
    
    for (int i = 0 ; i < 5; ++i) {
      System.out.println(q.front() + " dequeued");
      q.dequeue();
    }
    
  }
  
  public static void linkedlistQ() throws QueueEmptyException, QueueFullException {
    Queue q = new ListQueue();
    
    for (int i = 0 ; i < 5; ++i) {
      System.out.println(i + " enqueued");
      q.enqueue(i);
    }
    
    for (int i = 0 ; i < 5; ++i) {
      System.out.println(q.front() + " dequeued");
      q.dequeue();
    }
    
    
//    System.out.println(q.front() + " dequeued");
//    q.dequeue();
    
  }

  private static void dequeQ() throws QueueFullException, QueueEmptyException {
    Queue q = new DequeQueue();
    
    for (int i = 0 ; i < 5; ++i) {
      System.out.println(i + " enqueued");
      q.enqueue(i);
      //System.out.println("Size: " + q.size());
    }
    
    for (int i = 0 ; i < 5; ++i) {
      System.out.println(q.front() + " dequeued");
      //System.out.println("Size: " + q.size());
      q.dequeue();
    }
    
    
    //System.out.println(q.front() + " dequeued");
    //q.dequeue();
    
  }
  
}
