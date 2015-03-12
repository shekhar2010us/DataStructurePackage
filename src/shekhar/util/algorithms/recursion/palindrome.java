/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.algorithms.recursion;

/**
 *
 * @author shekhar2010us
 */
public class palindrome {
  
  /*
   * Check first and last character, if they are same, snatch them out and check for the remaining string,
   * until we have either 1 or 0 characters left in the string
   * so, the base case is len(string) == 0 or 1
   */
  
  public static void main(String [] args) {
    System.out.println(isPalin("feabcdcbaef"));
  }
  
  private static boolean isPalin(String s) {
    
    int len = s.length();
    
    if (len == 0 || len == 1)
      return true;
    else
      return ( s.charAt(0) == s.charAt(len-1) ) && ( isPalin( s.substring(1, (len-1) )) );
  }
  
}
