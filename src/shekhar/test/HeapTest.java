/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.test;

import shekhar.util.ds.heap.implementations.ArrayHeap;
import shekhar.util.ds.heap.implementations.TreeHeap;
import shekhar.util.ds.heap.interfaces.Heap;

/**
 *
 * @author shekhar2010us
 */
public class HeapTest {
  
  public static void main(String [] args) {
    Arrayheap();
    
  }
  
  private static void Arrayheap() {
    
    Heap h = new ArrayHeap();
    int [] nums = {3, 6, 1, 9, 10, 2, 13, 20, 23, 0, 8, 5};
    for ( int i : nums ) {
      System.out.println("Insert: " + i );
      h.insert(i);
      System.out.print("heap:\t");
      h.levelOrderPrint();
    }
    
    System.out.println("Size: " + h.size()+ "\n\n");
    
    int i = 0;
    while ( i < h.size() ) {
      System.out.println("Deleting: " + h.min());
      h.delMin();
      System.out.print("heap:\t");
      h.levelOrderPrint();
    }
    System.out.println("\nSize: " + h.size() + "\n\n");
  }
  
  private static void Treeheap() {
    Heap h = new TreeHeap();
    int [] nums = {3, 6, 1, 9, 10, 2, 13, 20, 23, 0, 8, 5};
    for ( int i : nums ) {
      System.out.println("Inserting: " + i );
      h.insert(i);
      System.out.print("heap:\t");
      h.levelOrderPrint();
    }
    
    System.out.println("Size: " + h.size()+ "\n\n");
    
    int i = 0;
    while ( i < h.size() ) {
      System.out.println("Deleting: " + h.min());
      h.delMin();
      System.out.print("heap:\t");
      h.levelOrderPrint();
    }
    System.out.println("\nSize: " + h.size() + "\n\n");
  }
  
}
