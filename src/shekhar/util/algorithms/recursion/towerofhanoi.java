/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.algorithms.recursion;

/**
 *
 * @author shekhar2010us
 */
public class towerofhanoi {
  
  /*
   * Base case: when there is just one disc, move it from source to target
   * When there are two, i.e.(n=2); move 1 disc from source to spare and then the other from source to target.
   * General notion:
   * move (n-1) disc from source to spare, move 1 disc from source to target, move (n-1) disc from spare to target
   * handle (n-1) recursively
   * 
   * At every +1 disc, the iter taken is { (previous_iter * 2) + 1 }
   */
  
  private static int count = 0;
  
  public static void main(String [] args) {
    
    for ( int i = 1 ; i < 15; ++i ) {
      hanoi( i, "1" , "2" , "3" );
      System.out.println("For " + i + " disc, iter = " + count);
      count = 0;
    }
    
  }
  
  private static void hanoi(int n , String source, String target, String spare) {
    
    if (n == 1) {
      //System.out.println("Move from " + source + " to " + target);
      count++;
    }
    else {
      hanoi(n-1, source , spare , target);
      hanoi(1 , source, target, spare);
      hanoi(n-1, spare, target, source);
    }
  }
  
}
