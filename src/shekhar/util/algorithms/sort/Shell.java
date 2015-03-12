/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.algorithms.sort;

import shekhar.util.algorithms.common.utilities;

/**
 *
 * @author shekhar2010us
 */
public class Shell {
  
  public static void Sort(int[] a) {
    // (3x + 1) model
    // compute the knuth h-shell sequence largest number
    
    int N = a.length;
    int h = 1;
    while ( h < N/3 )
      h = 3*h+1;
    
    while (h >= 1) {
      // this is the h for which we need to do insertion sort
      
      for ( int i = h ; i < a.length; ++i ) {
        for ( int j = i ; (j >= h && a[j] < a[j-h]) ; j=j-h ) {
          utilities.swap(a, j, j-1);
        }
      }
      //      System.out.println("Sorting after " + h + " shell sort.");
      //      utilities.printarr(a);
      h = h/3;
    }
    
  }
  
}
