package shekhar.util.algo.sorting;

/**
 *
 * @author shekhar2010us
 */
public class BubbleSort {
  
  public static void bubble_sort(int [] arr) {
    int n = arr.length;
    for ( int i = n-1 ; i > 1 ; --i ) {
      for ( int j = 0; j < i; ++j) {
        if ( arr[j] > arr[j+1] ) {
          int swap = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = swap;
        }
      }
    }
  }
  
}
