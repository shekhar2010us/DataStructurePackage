package shekhar.util.algorithms.recursion;

/**
 *
 * @author shekhar2010us
 */
public class LongestCommonSubsequence {
  
private static String [] arr1 = { "He" , "sells" , "sea" , "shells" , "on" , "the" , "sea" , "shore" , "."  };
private static String [] arr2 = { "Is"  , "she" , "is" , "selling" , "sea" , "shells" , "above" , "the" , "shore" , "?"  };

//  private static String[] arr1 = { "a", "b", "a", "c", "e", "b" };
//  private static String[] arr2 = { "a", "d", "b", "a", "v", "c", "e", "b" };
//  
  public static void main(String[] args) {
    if (arr1.length > 0 && arr2.length > 0) {
      int [][] lcs = LCS();
      printMatrix(lcs);
      
      findMatch(lcs);
      
    }
    else
      System.out.println("XXXX... Provide better input");
  }
  
  public static int [][] LCS() {
    int m = arr1.length;    // 6
    int n = arr2.length;    // 8
    
    int [][] lcs = new int[m + 1][n + 1];
    
    for ( int i = 0 ; i <= m ; ++i ) {
      lcs[i][0] = 0;
    }
    for ( int j = 0 ; j <= n ; ++j ) {
      lcs[0][j] = 0;
    }
    
    for (int i = 1 ; i <= m; ++i) {
      for (int j = 1 ; j <= n; ++j) {
        if (arr1[i-1].equals(arr2[j-1])) {
          lcs[i][j] = 1 + lcs[i-1][j-1];
        } else {
          lcs[i][j] = max( lcs[i][j-1] , lcs[i-1][j] );
        }
      }
    }
    
    return lcs;
  }
  
  private static void printMatrix(int[][] matrix) {
    int m = matrix.length;
    for (int i = 0 ; i < m ; ++i) {
      int[] temp = matrix[i];
      for (int j = 0 ; j < temp.length; ++j) {
        System.out.print(matrix[i][j] + "\t");
      }
      System.out.print("\n");
    }
  }

  private static int max(int i, int j) {
    if (i > j)
      return i;
    else 
      return j;
  }

  private static void findMatch(int[][] matrix) {
    int check = 0;
    int m = matrix.length;
    for (int i = 0 ; i < m ; ++i) {
      int[] temp = matrix[i];
      for (int j = 0 ; j < temp.length; ++j) {
       if (matrix[i][j] > check) {
         System.out.println( (i-1) + " and " + (j-1));
         check = matrix[i][j];
       }
      }
    }
    
  }
  
  
}
