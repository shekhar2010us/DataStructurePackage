package shekhar.util.ds.queue.implementations;

import shekhar.util.ds.queue.exceptions.QueueEmptyException;
import shekhar.util.ds.queue.exceptions.QueueFullException;
import shekhar.util.ds.queue.interfaces.Queue;

/**
 *
 * @author shekhar2010us
 */
public class ArrayQueue implements Queue {
  
  private static int CAPACITY = 64;    // initial capacity
  private int N;                      // maximum capacity
  private Object[] queue;             // queue array
  private int front = 0;             // front element
  private int rear = 0;               // rear element index
  
  public ArrayQueue() {
    N = CAPACITY;
    queue = new Object[N];          // create queue of size N+1, and when size = N, declare it full
  }
  
  public ArrayQueue(int capacity) {
    N = capacity;
    queue = new Object[N];          // create queue of size N+1, and when size = N, declare it full
  }
  
  @Override
  public void enqueue(Object element) throws QueueFullException {
    
    if ( size() == (N-1) )
      throw new QueueFullException("Full Queue..");
    
    queue[rear] = element;
    rear = (rear+1) % N;
    
  }

  @Override
  public void dequeue() throws QueueEmptyException {
    
    if ( isEmpty() )
      throw new QueueEmptyException("Empty Queue..");
    
    queue[front] = null;
    front = (front+1) % N;
    
  }

  @Override
  public Object front() throws QueueEmptyException {
    if ( isEmpty() )
      throw new QueueEmptyException("Empty Queue..");
    return queue[front];
  }

  @Override
  public int size() {
    return ( N - front + rear ) % N;      // due to wrap around, otherwise it would have been simply (r-f)
  }

  @Override
  public boolean isEmpty() {
    return (front == rear);
  }
  
}
