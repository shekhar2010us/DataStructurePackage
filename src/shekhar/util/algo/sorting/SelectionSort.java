/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.algo.sorting;

/**
 *
 * @author shekhar2010us
 */
public class SelectionSort {
  
  public static void selection_sort(int [] arr) {
    
    int len = arr.length;
    
    for ( int i = 0; i < len; ++i  ) {
      int min = i;
      for ( int j = i+1; j < len; ++j  ) {
       if ( arr[j] < arr[min]  ) {
         min = j;
       }
      }
      int swap = arr[i];
      arr[i] = arr[min];
      arr[min] = swap;
    }
    
  }
  
}
