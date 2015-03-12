package shekhar.util.ds.map.utilities;

/**
 *
 * @author shekhar2010us
 */
public class CommonUtils {
  
  public int calcPrimeNearTo( int number ) {
    
    int result = number;
    
    while( true ) {
      result++;
      if ( checkPrime(result) ) {
        return result;
      }
    }
  }
  
  public int calcPrimeNearToLess( int number ) {
    
    int result = number;
    
    while( true ) {
      result--;
      if ( checkPrime(result) ) {
        return result;
      }
    }
  }
  
  private boolean checkPrime(int number) {
    for (int i = 2; i < number; ++i) {
        if ( number % i == 0 ) {
          // not prime
          return false;
        }
      }
    return true;
  }
  
  
}
