package shekhar.util.algorithms.sort;

import shekhar.util.algorithms.common.utilities;

/**
 *
 * @author shekhar2010us
 */
public class Quick {
  
  public static void main (String [] args) {
    
    int [] arr = {100, 67, 87, 23, 9, -1, -34, 89};
    Sort(arr);
    for (int a : arr) {
      System.out.print(a + "\t");
    }
    System.out.println("");
  }
  
  
  public static void Sort(int[] a) {
    
    sort(a, 0, a.length-1);
  // int j = Quick.partition(a, 0, a.length-1);
    
  }

  private static void sort(int[] a, int lo, int hi) {
    
    if (lo >= hi) return;
    int j = partition(a, lo, hi);
    sort(a, lo, j-1);
    sort(a, j+1 , hi);
    
  }
  
  
  /**
   * Partition step for the quick sort
   * @param a
   * @param pivotIndex
   */
  public static int partition( int[] a , int lo, int hi) {
    
    //int pivot = a[lo];
    
    int i = lo;
    int j = hi+1;
    
    while ( true ) {
      
      while ( a[++i] <= a[lo] )
        if ( i >= hi ) break;
      while ( a[--j] >= a[lo] )
        if ( j <= lo ) break;
      //System.out.println(i + " , " + j);
      
      if (i >= j) break;
      
      // at this point, we have i and j to swap
      utilities.swap(a, i, j);
      //utilities.printarr(a);
      
    }
    // exchange j and pivot here
    utilities.swap(a, j, lo);
    //utilities.printarr(a);
    
    // return index of the item whose correct position is known
    return j;
  }
  
  
}
