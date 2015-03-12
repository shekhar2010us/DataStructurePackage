/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.test;

import java.util.List;
import shekhar.util.ds.tree.implementations.AVLTree;
import shekhar.util.ds.tree.implementations.Node;

/**
 *
 * @author shekhar2010us
 */
public class AVLTreeTest {

  public static void main(String[] args) {

    AVLTree<Integer> tree = new AVLTree<Integer>();
    
    int[] ints = {10, 7, 15, 4, 20, 12, 1, 18, 10, 1, 9, 5, 6};
    for ( Integer i : ints ) {
      tree.insert(i);
      System.out.println("Is AVL Tree: " +  tree.isAVLTree());
    }
    
//    tree.insert(10);
//    tree.insert(7);
//    tree.insert(15);
//    tree.insert(4);
//    tree.insert(20);
//    tree.insert(12);
//    tree.insert(1);
//    tree.insert(18);
//    tree.insert(10);
//    tree.insert(1);
//    tree.insert(9);
//    tree.insert(5);
//    tree.insert(6);

//    System.out.print("\nLevel Order:  \n");
//    tree.height(10);
    
    System.out.print("\nInorder:  ");
    List<Integer> keys = tree.inorder();
    System.out.print(keys + "\n\n");

    for (Integer i : keys) {
      System.out.print("h(" + i + "): " + tree.height(i) + "    ");
      boolean bal = tree.isKeyHeightBalanced(i);
      if (bal)
        System.out.println("balanced");
      else 
        System.out.println("not balanced");
      
      Node n = tree.firstAncestorWhereUnBalance(i);
      if (n == null)
        System.out.println("\tFirst Ancestor where balance violated: null");
      else 
        System.out.println("\tFirst Ancestor where balance violated: " + n.element);
      
    }
    
    System.out.println("Is AVL Tree: " +  tree.isAVLTree());
    
  }
}
