package shekhar.util.algorithms.common;

import java.util.Random;

/**
 *
 * @author shekhar2010us
 */
public class utilities {
  
  public static void printarr(int[] a) {
    for (int i : a)
      System.out.print(i + "\t");
    System.out.print("\n");
  }
  
  public static void swap(int[] a, int i, int index) {
    int x = a[i];
    a[i] = a[index];
    a[index] = x;
  }
  
  public static int[] randomgen(int size) {
    
    int [] a = new int[size];
    int max = 100;
    int min = -100;
    
    Random rng = new Random();
    for (int i = 0 ; i < size; ++i) {
      Integer next = rng.nextInt(max) + 1;
      a[i] = next;
    }
    
    return a;
  }
  
  
}
