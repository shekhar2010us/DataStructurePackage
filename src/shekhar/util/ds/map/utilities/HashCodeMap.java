/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.ds.map.utilities;

import java.math.BigDecimal;

/**
 *
 * @author shekhar2010us
 */
public class HashCodeMap {
  
  /*
   * X = 37 is experimentally proved and gives least number of collision
   * Other values could be 33, 37, 39, 41
   */
  private double X = 39.0;
  
  protected BigDecimal polynomial_accumulation(String string) {
    BigDecimal sum = new BigDecimal(0);
    for ( int i = 0 ; i < string.length(); ++i ) {
      int a = string.charAt(i);
      BigDecimal aa = new BigDecimal(a);
      BigDecimal pow = BigDecimal.valueOf(Math.pow(X, i));
      sum = sum.add(aa.multiply(pow));
    }
    return sum;
  }
  
  protected BigDecimal polynomial_accumulation(int number) {
    return polynomial_accumulation( (number+"") );
  }
  
}
