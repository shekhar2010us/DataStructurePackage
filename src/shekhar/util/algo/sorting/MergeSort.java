/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.algo.sorting;

/**
 *
 * @author shekhar2010us
 */
public class MergeSort {
  
  
  public static int[] mergesort(int [] list) {
    
    if (list.length <= 1)
      return list;
    
    int middle = list.length / 2;
    int[] left = formArr(list, 0, middle);
    int[] right = formArr(list, middle, list.length);
    
    right = mergesort(right);
    left = mergesort(left);
    int[] result = merge(left, right);
    
    return result;
    
  }
  
  // merge from a single array
  private static void merge(int[] A, int p, int q, int r) {
    // A : the bigger array
    // p to q : first array
    // q+1 to r : second array
    int pClone = p;
    int len1 = q-p+1;
    int len2 = r-(q+1)+1;
    int total = len1+len2;
    
    int[] temp = new int[total];
    
    int a1Index = p , a2Index = q+1;
    while ( total > 0 ) {
      
      if ( A[a1Index] <= A[a2Index] ) {
        temp[len1+len2-total] = A[a1Index];
        a1Index++;
      } else {
        temp[len1+len2-total] = A[a2Index];
        a2Index++;
      }
      
      total--;
      
      if (a1Index == (len1+p) )  {    // a1 finished
        // get reamining a2Index
        while(total > 0) {
          temp[len1+len2-total] = A[a2Index];
          a2Index++;
          total--;
        }
        break;
      }
      
      if (a2Index == (len2+q+1) ) {    // a1 finished
        // get reminaing a1Index
        while(total > 0) {
          temp[len1+len2-total] = A[a1Index];
          a1Index++;
          total--;
        }
        break;
      }
      
    }
    
    for (int i : temp) {
      A[pClone] = i;
      pClone++;
    }
    
  }
  
  // merge from two arrays
  private static int[] merge(int[] a1, int[] a2) {
    int len1 = a1.length;
    int len2 = a2.length;
    int total = len1+len2;
    
    int[] a3 = new int[total];
    
    int a1Index = 0 , a2Index = 0;
    while ( total > 0 ) {
      
      if ( a1[a1Index] <= a2[a2Index] ) {
        a3[len1+len2-total] = a1[a1Index];
        a1Index++;
      } else {
        a3[len1+len2-total] = a2[a2Index];
        a2Index++;
      }
      
      total--;
      
      if (a1Index == len1) {    // a1 finished
        // get reamining a2Index
        while(total > 0) {
          a3[len1+len2-total] = a2[a2Index];
          a2Index++;
          total--;
        }
        break;
      }
      
      if (a2Index == len2) {    // a1 finished
        // get reminaing a1Index
        while(total > 0) {
          a3[len1+len2-total] = a1[a1Index];
          a1Index++;
          total--;
        }
        break;
      }
      
    }
    
    return a3;
  }
  
  // form array with indices
  private static int[] formArr(int [] A, int lo, int hi) {
    // including lo, excluding hi
    int[] arr = new int[(hi-lo)];
    int index = 0 ;
    for ( int i = lo; i < hi ; ++i ) {
      arr[index] = A[i];
      index++;
    }
    return arr;
  }
  
  private static void print(int[] arr) {
    for (int i : arr) {
      System.out.print(i + "  ");
    }
    System.out.println("");
  }
  
}
