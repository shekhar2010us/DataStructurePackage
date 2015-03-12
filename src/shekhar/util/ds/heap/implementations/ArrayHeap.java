/*
 * MIN HEAP
 */
package shekhar.util.ds.heap.implementations;

import java.util.Comparator;
import shekhar.util.ds.heap.interfaces.Heap;

/**
 *
 * @author shekhar2010us
 */
public class ArrayHeap<T extends Comparable<T> > implements Heap {
  
  private Comparator< ? super T> comparator;
  
  final int compare(Object k1, Object k2) {
    
    if ( comparator==null ) {
      return ((Comparable<? super T>) k1).compareTo((T)k2);
    } else {
      return comparator.compare((T) k1, (T) k2);
    }
    
  }
  
  private int compare2(Object x, Object y) {
    return ((T) x).compareTo((T) y);
  }
  
  private Object[] heap;
  private int size = 0;
  private int default_capacity = 101;
  //  private static int minimum_capacity = 101;
  
  public ArrayHeap() {
    init();
  }
  
  public ArrayHeap(int capacity) {
    default_capacity = capacity;
    init();
  }
  
  private void init() {
    heap = new Object[default_capacity];
  }
  
  //  private static void resize() {
  //    if ( size >= 0.75*default_capacity) {
  //      upsize();
  //      default_capacity *= 2;
  //    } else if (size < minimum_capacity) {
  //      downsize();
  //    }
  //  }
  
  //  private static void downsize() {
  //
  //  }
  //
  //  private static void upsize() {
  //
  //  }
  
  @Override
  public void insert(Comparable element) {
    
    heap[++size] = element;
    upheapify(size);
    
  }
  
  @Override
  public void delMin() {
    
    if (size == 0) {
      System.out.println("No More Elements in the heap..");
      System.exit(-1);
    } else {
      swap(1, size--);
      heap[size+1] = null;
      //size--;
      
      downheapify(1);
    }
  }
  
  @Override
  public Comparable min() {
    return (Comparable) heap[1];
  }
  
  @Override
  public void levelOrderPrint() {
    for (int i = 0 ; i <= size; ++i) {
      System.out.print(heap[i] + "\t");
    }
    System.out.println("");
  }
  
  @Override
  public int size() {
    return size;
  }
  
  
  /**
   * Heap property is violated at index 'k'
   * climb it to appropriate position
   * @param k
   */
  private void upheapify(int k) {
    
    while ( k > 1 ) {
      if ( less(heap[k], heap[k/2]) ) {  // heap[k] is less than heap[k/2], swap them
        swap(k, k/2);
      }
      k = k/2;
    }
    
  }
  
  private void downheapify(int k) {
    // compare k with 2k and 2k+1
    // if heap[k] is larger than heap[2k] and/or heap[2k+1]
    // replace k with (smallest of 2k and 2k+1)
    while ( 2*k <= size ) {
      
      int j = 2*k;      // j is the left child of k
      
          // if 2k+1 exists
      // heap[2k] is less than heap[2k+1], take 2k
      if (j+1 <= size)
        if ( !less(heap[j], heap[j+1]) )
          j++;
      
          // if 2k+1 does not exist
      // <== do somethings ==>
      
      // now compare j and k ==> j represents the smaller child here
      if ( less(heap[j], heap[k]) ) {
        swap(j, k);
        k = j;
      } else 
        break;
    }
    
  }
  
  
  
  private boolean less(Object c1, Object c2) {
    if  ( compare(c1, c2) < 0 )
      return true;
    return false;
  }
  
  private void swap(int k1, int k2) {
    Object tmp = heap[k1];
    heap[k1] = heap[k2];
    heap[k2] = tmp;
  }
  
}
