/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.test;

import shekhar.util.ds.linkedlist.implementations.NodeCircularList;
import shekhar.util.ds.linkedlist.interfaces.CircularList;

/**
 *
 * @author shekhar2010us
 */
public class CircularListTest {
  
  
  public static void main(String [] args) {
    
    CircularList list = new NodeCircularList();
    
    //System.out.println("Size: " + list.size());
    list.traverse();
    
    
    list.addFirst("A");
    //System.out.println("Size: " + list.size());
    list.traverse();
    
    list.addFirst("B");
    //System.out.println("Size: " + list.size());
    list.traverse();
    
    list.addLast("C");
    //System.out.println("Size: " + list.size());
    list.traverse();
    
    
    list.removeFirst();
    //System.out.println("Size: " + list.size());
    list.traverse();
    
    list.removeFirst();
    //System.out.println("Size: " + list.size());
    list.traverse();
    
    list.removeFirst();
    //System.out.println("Size: " + list.size());
    list.traverse();
    
  }
}
