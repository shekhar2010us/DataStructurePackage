/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.algorithms.recursion;

/**
 *
 * @author shekhar2010us
 */
public class exponents {
  
  /*
   * Find b^n by recursion
   * 
   */
  
  public static void main(String [] args) {
    System.out.println( exp(2,3) );
  }
  
  private static int exp(int b, int n) {
    
    if (n == 0)
      return 1;
    
    else {
      return ( b * exp(b, (n-1) ) );
      
    }
    
  }
  
}
