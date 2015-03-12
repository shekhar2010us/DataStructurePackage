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
public class HashFunction {
  
  HashCodeMap hashcodemap;
  CompressionCodeMap compressioncodemap;
  CommonUtils commonutils;
  
  private int hashcode;
  
  private int getHashCode() {
    return this.hashcode;
  }
  
  public HashFunction() {
    hashcodemap = new HashCodeMap();
    compressioncodemap = new CompressionCodeMap();
    commonutils = new CommonUtils();
  }
  
  public int hash_function(String string, int m) {
   BigDecimal k = hashcodemap.polynomial_accumulation(string);
   this.hashcode = compressioncodemap.fibonacci_hashing(k, m);
   return getHashCode();
  }
  
  public int hash_function(Integer number, int m) {
    //HashFunction h = new HashFunction();
    BigDecimal k = hashcodemap.polynomial_accumulation(number);
    this.hashcode = compressioncodemap.fibonacci_hashing(k, m);
    return getHashCode();
  }
  
  public int double_hash_function(String string, int m) {
   BigDecimal k = hashcodemap.polynomial_accumulation(string);
   int mod = ( k.remainder(new BigDecimal(m)) ).intValueExact();
   int double_hash = commonutils.calcPrimeNearTo(mod);
   if ( double_hash == m) {
     double_hash = commonutils.calcPrimeNearToLess(mod);
   }
   return double_hash;
  }
  
}
