/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.ds.tree.implementations;

/**
 *
 * @author shekhar2010us
 * @param <T> 
 */
public class Node<T> {
  
  /**
   * Key stored in a node
   */
  public T element;
  
  /**
   * leftchild of the node
   */
  public Node leftChild;
  
  /**
   * rightchild of the nodes
   */
  public Node rightChild;
  //public Node parent;
  
  /**
   * Default Constructor of node
   */
  public Node() {}
  
  /**
   * Constructor for which 
   * @param o 
   */
  public Node(T o) {
    this();
    element = o;
  }
  
}


