/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.test;

import static shekhar.util.algo.sorting.BubbleSort.bubble_sort;
import static shekhar.util.algo.sorting.InsertionSort.insertion_sort;
import static shekhar.util.algo.sorting.SelectionSort.selection_sort;
import static shekhar.util.algo.sorting.QuickSort.quicksort;
import static shekhar.util.algo.sorting.MergeSort.mergesort;
import static shekhar.util.algo.sorting.RadixSort.radix_sort;

/**
 *
 * @author shekhar2010us
 */
public class sorting {
  
  public static void main(String [] args) {
    
    int [] arr = { -73, 12345, 83, -34, 29, 10, 20, 29, 26, 234, 345, -108, 444, 3, 8, 234987, 2, 7, 5, 1, 6, 10, 9087453, 4, 9 };
    
    //bubble(arr);
    
    //insertion(arr);
    
    //selection(arr);
//    Scanner sc = new Scanner(System.in);
//    System.out.println("Enter numbers: ");
//    String listsrc = sc.next();
//    String [] list = listsrc.split(",");
//    int[] integerList = new int[list.length];
//    for ( int i = 0 ; i < integerList.length; ++i ) {
//      integerList[i] = Integer.parseInt(list[i]);
//    }
//    
//    quick(integerList);
    
    //merge(arr);
    
    
    //radix(arr);
    
    quick(arr);
    
  }
  
  private static void bubble(int[] arr) {
    bubble_sort(arr);
    for (int i : arr)
      System.out.println(i);
    
  }

  private static void insertion(int[] arr) {
    insertion_sort(arr);
    for (int i : arr)
      System.out.println(i);
  }

  private static void selection(int[] arr) {
    selection_sort(arr);
    for (int i : arr)
      System.out.println(i);
  }

  private static void quick(int[] arr) {
    
    quicksort(arr);
    for (int i : arr)
      System.out.println(i);
  }
  
  private static void merge(int [] arr) {
    for (int i : arr)
      System.out.print(i + "  ");
    System.out.println("");
    
    int [] A = mergesort(arr);
    for (int i : A)
      System.out.print(i + "  ");
    System.out.println("");
    
  }
  
  private static void radix(int [] arr) {
    for (int i : arr)
      System.out.print(i + "  ");
    System.out.println("");
    
    int [] A = radix_sort(arr);
    System.out.println("\nSorted: ");
    for (int i : A)
      System.out.print(i + "  ");
    System.out.println("");
  }
  
  
}
