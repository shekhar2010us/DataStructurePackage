package shekhar.test;

import shekhar.util.ds.linkedlist.implementations.NodeLinkedList;
import shekhar.util.ds.linkedlist.interfaces.LinkedList;

/**
 *
 * @author shekhar2010us
 */
public class LinkedListTest {
  
  public static void main(String [] args) {
    
    LinkedList list = new NodeLinkedList();
    
    list.add("A");
    list.add("B");
    list.add("78");
    System.out.println("Size: " + list.size());
    
    list.traverse();
    
    list.remove();
    
    System.out.println("----");
    System.out.println("Size: " + list.size());
    
    list.traverse();
  }
  
}
