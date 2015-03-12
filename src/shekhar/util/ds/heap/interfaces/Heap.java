/*
 * MIN HEAP
 */
package shekhar.util.ds.heap.interfaces;

/**
 *
 * @author shekhar2010us
 */
public interface Heap< T extends Comparable<T> > {
  
  void insert(T element);
  
  void delMin();
  
  T min();
  
  int size();
  
  void levelOrderPrint();
  
}
