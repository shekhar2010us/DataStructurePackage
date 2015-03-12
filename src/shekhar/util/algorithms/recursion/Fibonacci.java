/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.algorithms.recursion;

/**
 *
 * @author shekhar2010us
 */
public class Fibonacci {
  
  public static void main(String [] args) {
    int n = 6;
    int [] fibarr = new int[10];
    fibarr[0] = 0;
    fibarr[1] = 1;
    fibarr[2] = 1;
    
    int m = fib(n);
    System.out.println("Fib: " + m + "\n\n\n");
    
    fib2(n, fibarr);
    for (int i : fibarr) {
      System.out.print(i + "  ");
    }
  }
  
  public static int fib(int n) {
    System.out.println(n);
    if (n ==1 || n == 2) {
      return 1;
    } else {
      return ( fib(n-1) + fib(n-2) );
    }
    
  }
  
  public static int fib2(int n, int[] fibarr) {
    System.out.println(n);
    if (fibarr[n] == 0)
      fibarr[n] = fib2(n-1, fibarr) + fib2(n-2, fibarr);
    return fibarr[n];
  }
  
  
  private static int fibRecursion(int n) {
    
    if ( n == 1 || n == 2) {
      return 1;
    } else {
      return ( fibRecursion(n-1) + fibRecursion(n-2) );
    }
    
  }
  
  private static long fibIter(int n) {
    
    if (n == 1) {
      return 1L;
    } if ( n == 2) {
      return 1L;
    }
    
    long a = 0;
    long b = 1;
    long c = -1;
    for ( int i = 2 ; i <= n; ++i ) {
      c = a + b;
      a = b;
      b = c;
    }
    return c;
  }
  
}
