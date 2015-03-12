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
public class Selection {
  
  public static void Sort(int[] a) {
    
    if ( a != null && a.length > 0 ) {
      
      for (int i = 0 ; i < a.length-1; ++i) {
        int min = a[i];
        int index = i;
        for (int j = i+1 ; j < a.length; ++j) {
          if (a[j] < min ) {
            min = a[j];
            index = j;
          }
        }
        if (i != index)
          utilities.swap(a, i, index);
      }
      
    }
    
  }
  
}
