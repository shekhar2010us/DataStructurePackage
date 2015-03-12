package shekhar.util.algorithms.sort;

import shekhar.util.algorithms.common.utilities;

/**
 *
 * @author shekhar2010us
 */
public class Insertion {
  
  public static void Sort(int[] a) {
    
    if ( a != null && a.length > 0 ) {
      for ( int i = 1 ; i < a.length; ++i ) {
        for ( int j = i ; j > 0 ; --j ) {
          if (a[j] < a[j-1] ) {
            utilities.swap(a, j, j-1);
          }
        }
      }
    }
  }
  
}
