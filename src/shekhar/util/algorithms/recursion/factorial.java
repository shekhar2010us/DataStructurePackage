/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.algorithms.recursion;

/**
 *
 * @author shekhar2010us
 */
public class factorial {
  
  public static void main(String [] args) {
    System.out.println(fact(5));
  }
  
  private static int fact(int n) {
    if (n==1 || n == 0)
      return 1;
    else
      return ( n * fact(n-1) );
  }
}
