package shekhar.util.algorithms;

/**
 *
 * @author shekhar2010us
 */
public class KMP {
  
  public static void main(String [] args) {
    String text = "ABC ABCDAE ABCDABCDABCDAB";
    String pattern = "ABCDAB";
    
    int[] func = prefixFunction(pattern);
    
    printFunc(text, pattern, func);
    
    kmp(text, pattern, func);
    
  }
  
  private static int[] prefixFunction(String pattern) {
    
    int[] func = new int[pattern.length()];
    
    int index = 0;
    while ( index < func.length ) {
      if (index == 0) {
        func[index] = 0;
      } else {
        String newP = pattern.substring(0, index+1);
        int tablevalue = longestSamePrefixSuffix(newP);
        func[index] = tablevalue;
      }
      index++;
    }
    
    return func;
  }
  
  private static int longestSamePrefixSuffix(String s) {
    
    int len = s.length();
    if (len > 1) {
      for (int i = 1; i < len ; ++i) {
        String prefix = s.substring(0, (len-i) );
        String suffix = s.substring(i, len );
        if (prefix.equals(suffix)) {
          return prefix.length();
        }
      }
    }
    
    return 0;
    
  }
  
  private static void kmp(String text, String pattern, int[] func) {
    char[] textArr = text.toCharArray();
    char[] patternArr = pattern.toCharArray();
    
    int m = 0;    // textIndex
    int i = 0;    // matchIndex
    
    while(m < textArr.length  && (textArr.length - m >= patternArr.length)  ) {
      
      if ( textArr[m + i] == patternArr[i] ) {
        // if match found, increase the indices and continue
        i++;
        // check if full pattern has been matched
        if (i == patternArr.length) {   // total match found
          System.out.println("Total Match Found at:" + m);
          //break;
          m++;
          i=0;
        }
      }
      else if (i > 0) {     // if match not found, check if already partial check has happened
        if ( func[i-1] > 1 ) {   // check of the func[match_len -1] > 1
          // if yes, find skip index
          int skip = i - func[i-1];
          m += skip;
          i = 0;
        }
        else {  // if no, +1 the textIndex
          m++;
          i = 0;
        }
      }
      else {
        // no match found at the first place
        m++;
        i = 0;
      }
    }
    
    
  }

  private static void printFunc(String text, String pattern, int[] func) {
    System.out.print("m:  ");
    for (int j = 0; j < text.length(); ++j) {
      System.out.print(j%10 + " ");
    }
    System.out.print("\nt:  ");
    for (char j : text.toCharArray()) {
      System.out.print(j + " ");
    }
    
    System.out.print("\n\ni:  ");
    for (int j = 0; j < pattern.length(); ++j) {
      System.out.print(j%10 + " ");
    }
    System.out.print("\np:  ");
    for (char j : pattern.toCharArray()) {
      System.out.print(j + " ");
    }
    
    System.out.print("\nf:  ");
    for (int j  : func) {
      System.out.print(j+ " ");
    }
    System.out.print("\n\n");
  }
  
}
