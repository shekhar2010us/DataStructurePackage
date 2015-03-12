/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.ds.tree.interfaces;

import java.util.List;
import shekhar.util.ds.tree.implementations.Node;

/**
 * 
 * @author shekhar2010us
 * @param <Key> 
 */
public interface Tree< Key extends Comparable<Key> > {
  
  /**
   * Add a key to the binary search tree iteratively
   * @param k
   */
  void add(Key k);
  
  /**
   * Add a key to the binary search tree recursively
   * @param k
   */
  void addR(Key k);
  
  
  /**
   * Search the key in the binary search tree iteratively
   * @param k
   * @return Node(found key) or null
   */
  Node search(Key k);
  
  /**
   * Search the key in the binary search tree recursively
   * @param k
   * @return Node(found key) or null
   */
  Node searchR(Key k);
  
  
  /**
   * Find predecessor (just smaller) of a key in the binary search tree iteratively
   * @param k
   * @return Node(predecessor) or null(if key not present or key is the smallest in the tree)
   */
  Node predecessor(Key k);
  
  /**
   * Find successor (just larger) of a key in the binary search tree iteratively
   * @param k
   * @return Node(successor) or null(if key not present or key is the largest in the tree)
   */
  Node successor(Key k);
  
  /**
   * Find minimum in the binary search tree
   * @return minimum
   */
  Key minimum();
  
  /**
   * Find maximum in the binary search tree
   * @return maximum
   */
  Key maximum();
  
  
  /**
   * Delete a key from binary search tree
   * @param k
   */
  void delete(Key k);
  
  
  /**
   * Find the inorder (depth first) traversal of the binary search tree iteratively
   * @return List<Key>
   */
  List<Key> inorder();
  
  /**
   * Find the inorder (depth first) traversal of the binary search tree recursively
   * @return List<Key>
   */
  List<Key> inorderR();
  
  
  
  /**
   * Find the preorder (depth first) traversal of the binary search tree iteratively
   * @return List<Key>
   */
  List<Key> preorder();
  
  /**
   * Find the preorder (depth first) traversal of the binary search tree recursively
   * @return List<Key>
   */
  List<Key> preorderR();
  
  
  
  /**
   * Find the postorder (depth first) traversal of the binary search tree iteratively
   * @return List<Key>
   */
  List<Key> postorder();
  
  /**
   * Find the postorder (depth first) traversal of the binary search tree recursively
   * @return List<Key>
   */
  List<Key> postorderR();
  
  
  
  /**
   * Find the levelorder (breadth first) traversal of the binary search tree iteratively
   * @return List<Key>
   */
  List<Key> levelorder();
  
  /**
   * pretty printing
   */
  void levelorderprinting();
  
  
  /**
   * Find the height of the tree iteratively
   * @return int
   */
  int height();
  
  /**
   * Find the height of the tree recursively
   * @return int
   */
  int heightR();
  
  
  /**
   * Find the depth of the given key iteratively
   * @param k
   * @return int
   */
  int depth(Key k);
  
  /**
   * Find all the ancestors of the given key in binary search tree
   * @param k
   * @return List<Key>
   */
  List<Key> ancestors(Key k);
  
  
  
  /**
   * Find the leaves of the binary search tree
   * @return List<Key>
   */
  List<Key> leaves();
  
  
  /**
   * Find all nodes at the given level
   * @param level
   * @return List<Key>
   */
  List<Key> elementsAtLevel(int level);
  
  
  
  /**
   * Find pre_order from the given in_order and post_order of a binary search tree
   * @param inorder
   * @param postorder
   * @return List<Key>
   */
  List<Key> createpreorder(List<Key> inorder, List<Key> postorder);
  
  
  /**
   * Find post_order from the given in_order and pre_order of a binary search tree
   * @param inorder
   * @param preorder
   * @return List<Key>
   */
  List<Key> createpostorder(List<Key> inorder, List<Key> preorder);
  
}
