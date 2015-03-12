package shekhar.test;

import shekhar.util.algorithms.common.utilities;
import shekhar.util.algorithms.sort.*;

/**
 *
 * @author shekhar2010us
 */

public class SortTest {
  
  public static void main(String [] args) {
    
    int [] a = utilities.randomgen(20);
   // int [] a = { 43, 44, 84, 80, 2, 35, 75, 99, 77, 26, 28, 78, 39, 73, 26};	
    //int [] a = {80, 100, 88, 66, 22, 83, 93, 3, 68, 74, 27, 64, 68, 90, 86};
    
//    int [] aux1 = copyArr(a);
//    TestInsertion(aux1);
//    
//    int [] aux2 = copyArr(a);
//    TestSelection(aux2);
//    
//    int [] aux3 = copyArr(a);
//    TestShell(aux3);
//    
//    int [] aux4 = copyArr(a);
//    TestMerge(aux4);
//    
//    int [] aux5 = copyArr(a);
//    TestQuick(aux5);
    
    int [] aux6 = copyArr(a);
    TestHeap(aux6);
    
  }
  
  private static int[] copyArr(int [] a) {
    int [] aux = new int[a.length];
    for (int i = 0 ; i < a.length ; ++i) {
      aux[i] = a[i];
    }
    return aux;
  }
  
  private static void TestInsertion(int [] a) {
    long start = System.currentTimeMillis();
    System.out.println("Insertion Sort..");
    System.out.println("original array");
    utilities.printarr(a);
    
    Insertion.Sort(a);
    long end = System.currentTimeMillis();
    utilities.printarr(a);
    System.out.println("Time: " + (end-start) + " ms.");
    System.out.println("\n\n");
  }
  
  private static void TestSelection(int [] a) {
    long start = System.currentTimeMillis();
    System.out.println("Selection Sort..");
    System.out.println("original array");
    utilities.printarr(a);
    
    Selection.Sort(a);
    long end = System.currentTimeMillis();
    utilities.printarr(a);
    System.out.println("Time: " + (end-start) + " ms.");
    System.out.println("\n\n");
  }
  
  private static void TestShell(int [] a) {
    long start = System.currentTimeMillis();
    System.out.println("Shell Sort..");
    System.out.println("original array");
    utilities.printarr(a);
    
    Shell.Sort(a);
    long end = System.currentTimeMillis();
    utilities.printarr(a);
    System.out.println("Time: " + (end-start) + " ms.");
    System.out.println("\n\n");
  }
  
  private static void TestMerge(int[] a) {
    long start = System.currentTimeMillis();
    System.out.println("Merge Sort..");
    System.out.println("original array");
    utilities.printarr(a);
    
    Merge.Sort(a);
    long end = System.currentTimeMillis();
    utilities.printarr(a);
    System.out.println("Time: " + (end-start) + " ms.");
    System.out.println("\n\n");
  }
  
  private static void TestQuick(int[] a) {
    long start = System.currentTimeMillis();
    System.out.println("Quick Sort..");
    System.out.println("original array");
    utilities.printarr(a);
    
    Quick.Sort(a);
    long end = System.currentTimeMillis();
    utilities.printarr(a);
    System.out.println("Time: " + (end-start) + " ms.");
    System.out.println("\n\n");
  }

  private static void TestHeap(int[] a) {
    long start = System.currentTimeMillis();
    System.out.println("Heap Sort..");
    System.out.println("original array");
    for ( int i = 0 ; i < a.length ; ++i ) {
      System.out.print(i + "\t");
    }
    System.out.println("");
    utilities.printarr(a);
    
    Heap.Sort(a);
    long end = System.currentTimeMillis();
    utilities.printarr(a);
    System.out.println("Time: " + (end-start) + " ms.");
    System.out.println("\n\n");
  }
  
}
