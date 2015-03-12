/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.algo.sorting;

/**
 *
 * @author shekhar2010us
 */
public class RadixSort {
  
  private static int modC = 10;
  private static int divideC = 1;
  
  private static Node[] nodeArr =  new Node[19];    // node array of size 19 // cater (-) numbers also
  
  public static class Node {
    int key;
    Node next;
    
    Node(int e) {
      key = e;
      next = null;
    }
    
  }
  
  public static int[] radix_sort(int [] arr) {
    
    int maxbits = 0;
    for (int i : arr) {
      int y = (int)(Math.log10(i)+1);
      if (y > maxbits)
        maxbits = y;
    }
    
    // '5' is the most number of sifnificant bits, which will be changed by bit manipulation later
    // right now, it is constant
    for ( int k = 0 ; k < maxbits ; ++k ) {
      
      // add all elements to the node array at their respective positions
      for (int num : arr) {
        int pos = calcPos(num);   // value of pos is in between 0 to 9
        add(num, pos);
      }
      
      // get all the elements from the node array in the integer array again
      int tmp = 0;
      for (int i = 0 ; i < nodeArr.length; ++i) {
        Node n = nodeArr[i];
        while ( n != null ) {
          arr[tmp] = n.key;
          n = n.next;
          tmp++;
        }
      }
      nodeArr =  new Node[19];
      
      System.out.println("After Iteration: " + k);
      for (int i : arr)
        System.out.print(i + "  ");
      System.out.println("");
      
      modC = modC*10;
      divideC = divideC*10;
    }
    
    return arr;
  }
  
  private static int calcPos(int num) {
    // return value is in between 0 to 9
    return ( num % modC ) / divideC;
  }
  
  private static void add(int num, int pos) {
    pos = pos+9;
    // add num at the position pos of the nodeArr
    // Element i of nodeArr is a list
    Node tmp = new Node(num);
    
    //Node n = nodeArr[pos];
    if (nodeArr[pos] == null) {
      nodeArr[pos] = tmp;
    } else {
      Node n = nodeArr[pos];
      while(n.next != null) {
        n = n.next;
      }
      
      n.next = tmp;
    }
    
  }
  
}
