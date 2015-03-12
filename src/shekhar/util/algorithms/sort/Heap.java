package shekhar.util.algorithms.sort;

import shekhar.util.algorithms.common.utilities;

/**
 *
 * @author shekhar2010us
 */
public class Heap {
  
  // left child of k: 2k+1
  // right child of k: 2k+2
  // parent of k is: (k-1)/2
  
  
  /**
   * 
   * @param a 
   */
  public static void Sort(int[] a) {
    
    // create heap array from arbitrary array 'a'
    createHeapArray(a);
    utilities.printarr(a);
    
    // delete min and put at the end
    deleteMinInPlace(a);
    //utilities.printarr(a);
    
  }
  
  /**
   * 
   * @param a 
   */
  private static void createHeapArray(int[] a) {
    
    int N = a.length-1;
    for ( int i = (N-1)/2 ; i >=0 ; --i ) {
      downheapify(i, a, 0, N);
      //utilities.printarr(a);
    }
    
  }
  
  /**
   * downheapify 'a' for node 'k' taking array from index lo to hi
   * @param k
   * @param a
   * @param lo
   * @param hi 
   */
  private static void downheapify(int k, int[] a, int lo, int hi) {
    
    // check lesser of left and right child
    // check lesser of parent and lesser of right and left child
    // replace with the parent
    
    int size = (hi-lo);
    while ( k < size/2 ) {
      int j = 2*k+1;
      
      if ( (j+1) <= size )
        if ( a[j+1] < a[j] )
          j++;
      
      if ( a[j] <= a[k] ) {
        utilities.swap(a, j, k);
        //k = j;
      }
      k=j;
    }
    
  }

  /**
   * 
   * @param a 
   */
  private static void deleteMinInPlace(int[] a) {
    
    int N = a.length-1;
    while ( N >= 0 ) {
      // put min elem at last, reduce size by 1, downheapify for current size
      utilities.swap(a, 0, N--);
      //N--;
      downheapify(0, a, 0, N);
      //utilities.printarr(a);
    }
    
    // replace a[0] and a[1]
    if (a.length >= 2) {
      utilities.swap(a, 0, 1);
    }
    
    
  }
  
  
  
}
