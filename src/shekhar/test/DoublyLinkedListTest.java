/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.test;

import shekhar.util.ds.linkedlist.exceptions.LinkedListEmptyException;
import shekhar.util.ds.linkedlist.implementations.NodeDoublyLinkedList;
import shekhar.util.ds.linkedlist.interfaces.DoublyLinkedList;

/**
 *
 * @author shekhar2010us
 */
public class DoublyLinkedListTest {
  
  
  public static void main(String [] args) throws LinkedListEmptyException {
    
    DoublyLinkedList list = new NodeDoublyLinkedList();
    
    list.insertFirst("A");
    list.insertFirst("B");
    list.insertFirst(74);
    int size = list.size();
    System.out.println("Size: " + size);
    
    list.traverse();
    
    list.removeFirst();
    
    System.out.println("--- First removed ---");
    System.out.println("Size: " + list.size());
    
    list.traverse();
    
    
    list.insertLast("SH");
    list.insertLast("SU");
    System.out.println("Size: " + list.size());
    
    list.traverse();
  }
  
}
