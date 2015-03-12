/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.algorithms.sort;

/**
 *
 * @author shekhar2010us
 */
public class Merge {
  
  
  
  public static void Sort(int[] a) {
    
    int[] acopy = new int[a.length];
    sort(a, acopy, 0, a.length-1);
    
  }
  
  /**
   * merge a[lo]-a[mid] and a[mid+1]-a[hi]
   * @param a
   * @param lo
   * @param mid
   * @param hi
   */
  private static void merge(int[] a, int[] acopy, int lo, int mid, int hi) {
    
    for ( int i = 0 ; i < a.length; ++i )   // copy the array a
      acopy[i] = a[i];
    
    int i = lo, j = mid+1;
    for ( int k = lo ; k <= hi ; ++k ) {
      if ( i > mid )
        a[k] = acopy[j++];
      else if (j > hi)
        a[k] = acopy[i++];
      else if (acopy[j] < acopy[i])
        a[k] = acopy[j++];
      else
        a[k] = acopy[i++];
    }
    
  }
  
  /**
   * recursively divide and sort the array for merge sort
   * @param a
   * @param acopy
   * @param i
   * @param i0
   */
  private static void sort(int[] a, int[] acopy, int lo, int hi) {
    
    if (hi <= lo) return;
    int mid = lo + (hi-lo)/2;
    sort(a, acopy, lo, mid);
    sort(a, acopy, mid+1, hi);
    merge(a, acopy, lo, mid, hi);
    
  }
  
}
