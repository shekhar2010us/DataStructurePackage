/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.algo.sorting;

/**
 *
 * @author shekhar2010us
 */
public class QuickSort {
  
  public static void quicksort(int [] list) {
    if (list.length <= 1) {
      return;
    }
    // call sort method with "low" and "high" indices of the list
    sort(list, 0, list.length-1);
    
  }
  
  private static void sort(int[] list, int lo, int hi) {
    // lo: subarray with low index
    // hi: subarray with high index
    if ( (hi-lo) <= 0 ) {   // if fewer than two items, break
      return;
    }
    int splitPoint = split(list, lo, hi);   // calculate the splitpoint
    sort(list, lo, splitPoint-1);   // left subarray recursion
    sort(list, splitPoint+1, hi);   // right subarray recursion
    
    
  }
  
  private static int split(int[] list, int lo, int hi) {
    
    int splitPoint = 0;
    
    int left = lo+1;
    int right = hi;
    int pivot = list[lo];
    
    while (true) {
      
      while ( left <= right ) {
        if ( list[left] < pivot )
          left++;
        else
          break;
      }
      
      while ( right > left ) {
        if ( list[right] > pivot )
          right--;
        else
          break;
      }
      
      
      // if left and right crossed each other, then we need to stop
      if ( left >= right ) {
        break;
      }
      
      // if left and right did not cross each other, we have items at left and right indices, which need to be swapped
      int temp = list[left];
      list[left] = list[right];
      list[right] = temp;
      
      left++;
      right--;
      
      
    }
    
    splitPoint = left-1;    // splitPoint is (left-1) position
    
    // pivot need to be moved to splitPoint position
    list[lo] = list[splitPoint];
    list[splitPoint] = pivot;
    
    return splitPoint;      // return splitPoint as (lo-1)
  }
  
  
}
