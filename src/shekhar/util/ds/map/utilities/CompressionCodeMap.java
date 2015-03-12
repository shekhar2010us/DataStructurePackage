/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.ds.map.utilities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 *
 * @author shekhar2010us
 */
public class CompressionCodeMap {
  
  /*
   * h(k) = floor( m(kA mod1) )
   */
  
  private double A = (Math.pow(5, 0.5) -1 )/2;    // irrational multiplier
  //private int m = 317;  // number of slots in the map array
  
  protected int fibonacci_hashing(BigDecimal k, int m) {   // k = output of hashcode
    
    BigDecimal ka = k.multiply( BigDecimal.valueOf(A) );
    BigDecimal mod = ka.remainder(new BigDecimal(1));
    BigDecimal mult = mod.multiply( BigDecimal.valueOf(m) );
    BigDecimal floor = mult.setScale(0, RoundingMode.FLOOR);
    return floor.intValueExact();
    
  }
  
}
