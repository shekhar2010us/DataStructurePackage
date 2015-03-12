/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.algo.sorting;

/**
 *
 * @author shekhar2010us
 */
public class InsertionSort {
  
  public static void insertion_sort(int [] arr) {
    
    int len = arr.length;
    
    for ( int i = 1; i < len; ++i ) {
      int j = i;
      while ( j > 0 && arr[j] < arr[j-1] ) {
        int swap = arr[j];
        arr[j] = arr[j-1];
        arr[j-1] = swap;
        j--;
      }
    }
    
    
  }
  
}
