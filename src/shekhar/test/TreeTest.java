/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.test;

import shekhar.util.ds.tree.implementations.BinarySearchTree;
import shekhar.util.ds.tree.implementations.Node;
import shekhar.util.ds.tree.interfaces.Tree;

/**
 *
 * @author shekhar2010us
 */
public class TreeTest {

  public static void main(String[] args) {
    
    Tree<Integer> t = new BinarySearchTree<Integer>();
    t.add(5);
    t.add(10);
    t.add(3);
    t.add(4);
    t.add(20);
    t.add(15);
    t.add(16);
    t.add(6);
    t.add(12);
    
    Node node = t.predecessor(20);
    System.out.print("predecessor of 20: ");
    if (node != null) {
      System.out.println(node.element);
    } else {
      System.out.println("null");
    }
    
    node = t.predecessor(4);
    System.out.print("predecessor of 4: ");
    if (node != null) {
      System.out.println(node.element);
    } else {
      System.out.println("null");
    }
    
    node = t.predecessor(3);
    System.out.print("predecessor of 3: ");
    if (node != null) {
      System.out.println(node.element);
    } else {
      System.out.println("null");
    }
    
    
    
    node = t.successor(20);
    System.out.print("successor of 20: ");
    if (node != null) {
      System.out.println(node.element);
    } else {
      System.out.println("null");
    }
    
    node = t.successor(10);
    System.out.print("successor of 10: ");
    if (node != null) {
      System.out.println(node.element);
    } else {
      System.out.println("null");
    }
    
    node = t.successor(15);
    System.out.print("successor of 15: ");
    if (node != null) {
      System.out.println(node.element);
    } else {
      System.out.println("null");
    }
    
    System.out.println("\nMin: " + t.minimum());
    System.out.println("Max: " + t.maximum());
    
    //t.delete(20);
    System.out.println("\npre order recurive: " + t.preorderR());
    System.out.println("pre order iteratve: " + t.preorder());
    
    System.out.println("in order recurive: " + t.inorderR());
    System.out.println("in order iteratve: " + t.inorder());
    
    System.out.println("post order recurive: " + t.postorderR());
    System.out.println("post order iteratve: " + t.postorder());
    
    System.out.println("level order iteratve: " + t.levelorder() + "\n");
    t.levelorderprinting();
    
    System.out.println("\nheight R: " + t.heightR());
    System.out.println("height: " + t.height());
    
    System.out.println("\ndepth of 10: " + t.depth(10));
    System.out.println("depth of 15: " + t.depth(15));
    System.out.println("depth of 12: " + t.depth(12));
    System.out.println("depth of 25: " + t.depth(25));
    System.out.println("depth of 5: " + t.depth(5));
    
    
    System.out.println("\nAncestors 4: " + t.ancestors(4));
    System.out.println("6: " + t.ancestors(6));
    System.out.println("24: " + t.ancestors(24));
    System.out.println("10: " + t.ancestors(10));
    
    System.out.println("\nleaves: " + t.leaves());
    
    System.out.println("\nlevel 0: " + t.elementsAtLevel(0));
    System.out.println("level 1: " + t.elementsAtLevel(1));
    System.out.println("level 2: " + t.elementsAtLevel(2));
    System.out.println("level 3: " + t.elementsAtLevel(3));
    System.out.println("level 4: " + t.elementsAtLevel(4));
    System.out.println("level 5: " + t.elementsAtLevel(5));
    
    System.out.println("preorder (created): "+  t.createpreorder(t.inorder() , t.postorder()) );
    System.out.println("preorder (direct):  " + t.preorder());
    
    
    System.out.println("\npostorder created: " + t.createpostorder(t.inorder() , t.preorder()) );
    System.out.println("postorder direct:  "+t.postorder());
    
  }

}
