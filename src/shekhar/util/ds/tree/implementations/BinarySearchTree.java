/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.ds.tree.implementations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import shekhar.util.ds.tree.interfaces.Tree;

/**
 *
 * @author shekhar2010us
 * @param <Key>
 */
public class BinarySearchTree< Key extends Comparable<Key> > implements Tree {
  
  private Comparator< ? super Key> comparator;
  
  final int compare(Object k1, Object k2) {
    
    if ( comparator==null ) {
      return ((Comparable<? super Key>) k1).compareTo((Key)k2);
    } else {
      return comparator.compare((Key) k1, (Key) k2);
    }
    
  }
  
  private Node root;
  
  /**
   * Return the root of the binary search tree
   * @return Root node
   */
  public Node getRoot() { return root ; }
  
  
  @Override
  public void add(Comparable k) {
    
    Node node = new Node(k);
    if (root == null) {
      root = node;
    } else {
      
      Node current = root;
      Node parent;
      while (true) {
        parent = current;
        int compared = compare(k, current.element);
        if ( compared < 0 ) {                // go to left subtree
          current = current.leftChild;
          if (current == null) {
            parent.leftChild = node;
            return;
          }
        } else if ( compared > 0 ) {         // go to right subtree
          current = current.rightChild;
          if (current == null) {
            parent.rightChild = node;
            return;
          }
        } else {                            // equal keys, dont do anything
          return;
        }
        
      }
      
    }
    
  }
  
  @Override
  public void addR(Comparable k) {
    addR(root, root, k, true);
  }
  
  private void addR(Node current, Node parent, Comparable k, boolean leftEntry) {
    
    if (parent == null) {
      root = new Node(k);
      return;
    }
    else if ( current == null ) {
      current = new Node(k);
      if (leftEntry)
        parent.leftChild = current;
      else
        parent.rightChild = current;
      return;
    } else {
      int compared = compare(k, current.element);
      if (compared < 0) {
        addR(current.leftChild , current, k, true);   // recurse call left subtree
      } else if (compared > 0) {
        addR(current.rightChild , current, k, false); // recurse call right subtree
      } else {
        return;                                       // equal keys, return
      }
      
    }
    
  }
  
  
  @Override
  public Node search(Comparable k) {
    Node current = root;
    
    while (current != null) {
      int compared = compare(k, current.element);
      if (compared < 0) {
        current = current.leftChild;
      } else if (compared > 0) {
        current = current.rightChild;
      } else {
        return current;
      }
    }
    
    return null;
  }
  
  @Override
  public Node searchR(Comparable k) {
    return searchR(root, k);
  }
  
  private Node searchR(Node current, Comparable k) {
    
    if (current == null)
      return null;
    
    int compared = compare(k, current.element);
    
    if ( compared == 0 )
      return current;
    else
      return (compared < 0) ? searchR(current.leftChild, k) : searchR(current.rightChild, k);
    
  }
  
  
  @Override
  public Node predecessor(Comparable k) {
    Node current = root;
    Node parent = null;
    
    while (current != null) {
      int compared = compare(k, current.element);     // -1 if k is less, +1 if k is more
      if (compared < 0) {             // go to left subtree
        current = current.leftChild;
      } else if (compared > 0) {      // go to right subtree
        parent = current;             // track parent only when it goes to right subtree
        current = current.rightChild;
      } else {
        // here current is the right subtree of the "parent", thus if key has no left child, parent is its predecessor
        // now check if current has left subtree, if yes use it, otherwise use parent
        if (current.leftChild == null) {
          return parent;
        } else {
          current = current.leftChild;
          while( current.rightChild != null ) {
            current = current.rightChild;
          }
          return current;
        }
      }
    }
    
    return null;
  }
  
  @Override
  public Node successor(Comparable k) {
    Node current = root;
    Node parent = null;
    
    while (current != null) {
      int compared = compare(k, current.element);     // -1 if k is less, +1 if k is more
      if (compared < 0) {             // go to left subtree
        parent = current;             // track parent only when it goes to left subtree
        current = current.leftChild;
      } else if (compared > 0) {      // go to right subtree
        current = current.rightChild;
      } else {
        // here current is the left subtree of the "parent", thus if key has no right child, parent is its successor
        // now check if current has right subtree, if yes use it, otherwise use parent
        if (current.rightChild == null) {
          return parent;
        } else {
          current = current.rightChild;
          while(current.leftChild != null) {
            current = current.leftChild;
          }
          return current;
        }
      }
    }
    
    return null;
  }
  
  
  @Override
  public Key minimum() {
    Node current = root;
    
    if (current != null) {
      while (current.leftChild != null) {
        current = current.leftChild;
      }
      return (Key) current.element;
    } else return null;
  }
  
  @Override
  public Key maximum() {
    Node current = root;
    if (current != null) {
      while(current.rightChild != null) {
        current = current.rightChild;
      }
      return (Key) current.element;
    } else
      return null;
    
  }
  
  
  @Override
  public void delete(Comparable k) {
    
    Node current = root;
    Node parent = null;
    
    while (current != null) {
      int compared = compare(k, current.element);
      if (compared < 0) {         // key less than current, go to left subtree
        parent = current;
        current = current.leftChild;
      } else if (compared > 0) {  // key more than current, go to right subtree
        parent = current;
        current = current.rightChild;
      } else {                    // key found, delete... three approaches
        
        // both child null
        if ( current.leftChild == null && current.rightChild == null )
        {
          if ( compare( current.element, parent.element ) > 0)
            parent.rightChild = null;
          else
            parent.leftChild = null;
          return;
        }
        
        // one child null
        else if ( current.leftChild == null && current.rightChild != null)
        {
          if ( compare( current.element, parent.element ) > 0)
            parent.rightChild = current.rightChild;
          else
            parent.leftChild = current.rightChild;
          return;
        }
        
        else if (current.rightChild == null && current.leftChild != null)
        {
          if ( compare( current.element, parent.element ) > 0)
            parent.rightChild = current.leftChild;
          else
            parent.leftChild = current.leftChild;
          return;
        }
        
        // both child null
        
        else
        {
          // find successor
          Node successor = current.rightChild;
          Node successorParent = current;
          while ( successor.leftChild != null ) {
            successorParent = successor;
            successor = successor.leftChild;
          }
          // replace current with successor
          current.element = successor.element;
          
          // delete successor, two cases:
          
          // successor has no right child
          if (successor.rightChild == null)
          {
            if ( compare( successor.element, successorParent.element ) > 0)
              successorParent.rightChild = null;
            else
              successorParent.leftChild = null;
          }
          // successor has right child
          else
          {
            if ( compare( successor.element, successorParent.element ) > 0)
              successorParent.rightChild = successor.rightChild;
            else
              successorParent.leftChild = successor.rightChild;
          }
          return;
        }
        
      }
      
    }
    
  }
  
  
  
  @Override
  public List inorder() {
    List<Key> keys = new ArrayList<Key>();
    Stack<Node> s = new Stack<Node>();
    
    Node current = root;
    pushlefttostack(current, s);
    
    while ( !(s.isEmpty()) ) {
      Node node = s.pop();
      keys.add((Key) node.element);
      node = node.rightChild;
      pushlefttostack(node, s);
    }
    return keys;
  }
  private void pushlefttostack(Node node, Stack stack) {
    while( node != null ) {
      stack.push(node);
      node = node.leftChild;
    }
  }
  
  
  
  @Override
  public List inorderR() {
    List<Key> keys = new ArrayList<Key>();
    inorderR(root, keys);
    return keys;
  }
  private void inorderR(Node node, List<Key> keys) {
    if (node == null) return;
    inorderR(node.leftChild, keys);
    keys.add((Key) node.element);
    inorderR(node.rightChild, keys);
  }
  
  
  @Override
  public List preorder() {
    List<Key> keys = new ArrayList<Key>();
    
    Stack<Node> s = new Stack<Node>();      // new Stack containing nodes
    if (root != null)
      s.push(root);
    while (!(s.empty())) {
      Node node = s.pop();
      keys.add( (Key) node.element);        // pop an item and print
      if ( node.rightChild != null )
        s.push(node.rightChild);              // push rightchild of the popped item
      if ( node.leftChild != null )
        s.push(node.leftChild);               // push leftchild of the popped item
    }
    return keys;
  }
  
  @Override
  public List preorderR() {
    List<Key> keys = new ArrayList<Key>();
    preorderR(root, keys);
    return keys;
  }
  private void preorderR(Node node, List<Key> keys) {
    if (node == null) return;
    keys.add((Key) node.element);
    preorderR(node.leftChild, keys);
    preorderR(node.rightChild, keys);
  }
  
  
  
  @Override
  public List postorder() {
    List<Key> keys = new ArrayList<Key>();
    Stack<Node> stack1 = new Stack<Node>();
    Stack<Node> stack2 = new Stack<Node>();
    
    if (root != null)
      stack1.push(root);
    
    while ( !(stack1.isEmpty()) ) {
      Node node = stack1.pop();
      
      if (node.leftChild != null)
        stack1.push(node.leftChild);
      
      if (node.rightChild != null)
        stack1.push(node.rightChild);
      
      stack2.push(node);
    }
    while( !(stack2.isEmpty()) )
      keys.add( (Key) stack2.pop().element);
    return keys;
  }
  
  @Override
  public List postorderR() {
    List<Key> keys = new ArrayList<Key>();
    postorderR(root, keys);
    return keys;
  }
  private void postorderR(Node node, List<Key> keys) {
    if (node == null) return;
    postorderR(node.leftChild, keys);
    postorderR(node.rightChild, keys);
    keys.add((Key) node.element);
  }
  
  
  
  @Override
  public List levelorder() {
    List<Key> keys = new ArrayList<Key>();
    Queue<Node> q1 = new LinkedList<Node>();
    
    if (root != null)
      q1.add(root);
    
    while( !(q1.isEmpty()) ) {
      Node node = q1.remove();
      
      if (node.leftChild != null)
        q1.add(node.leftChild);
      if (node.rightChild != null)
        q1.add(node.rightChild);
      
      keys.add((Key) node.element);
    }
    return keys;
  }
  /*
   * pretty printing
   */
  @Override
  public void levelorderprinting() {
    Queue<Node> q1 = new LinkedList<Node>();
    Queue<Node> q2 = new LinkedList<Node>();
    
    if (root != null)
      q1.add(root);
    
    while(true) {
      while( !(q1.isEmpty()) ) {
        Node node = q1.peek();
        
        if (node.leftChild != null)
          q2.add(node.leftChild);
        if (node.rightChild != null)
          q2.add(node.rightChild);
        
        System.out.print(q1.remove().element + "  ");
        
      }
      System.out.println("");
      Queue<Node> tmp = q1;
      q1 = q2;
      q2 = tmp;
      if (q1.size() == 0)
        break;
    }
  }
  
  @Override
  public int height() {
    int height = -1;
    // use 2  queue
    Queue<Node> q1 = new LinkedList<Node>();
    Queue<Node> q2 = new LinkedList<Node>();
    if (root != null)
      q1.add(root);
    
    while( true ) {
      while( !(q1.isEmpty()) ) {
        Node node = q1.remove();
        if (node.leftChild != null)
          q2.add( node.leftChild );
        if (node.rightChild != null)
          q2.add( node.rightChild );
      }
      height++;
      Queue<Node> tmp = q1;
      q1 = q2;
      q2 = tmp;
      if (q1.size() == 0) {
        break;
      }
    }
    
    return height;
  }
  
  @Override
  public int heightR() {
    return heightR(root);
  }
  private int heightR(Node node) {
    /*
     * consider height of the tree starting from 'leaf' at height 0, rather than 'root' at height 0
     */
    if (node == null) {
      return -1;           // node below leaf is at height -1
    } else {
      return Math.max( heightR(node.leftChild), heightR(node.rightChild) ) + 1;
    }
  }
  
  
  
  @Override
  public int depth(Comparable k) {
    int depth = 0;
    Node current = root;
    
    while(current != null) {
      int compared = compare(k, current.element);
      if (compared < 0) {
        current = current.leftChild;
        depth++;
      } else if (compared > 0) {
        current = current.rightChild;
        depth++;
      } else {
        return depth;
      }
    }
    return -1;
  }
  
  
  
  @Override
  public List ancestors(Comparable k) {
    List<Key> ancestors = new ArrayList<Key>();
    
    Node current = root;
    while(current != null) {
      int compared = compare(k, current.element);
      if (compared < 0) {             // key is less than current
        ancestors.add((Key) current.element);
        current = current.leftChild;
      } else if (compared > 0) {      // key is more than current
        ancestors.add((Key) current.element);
        current = current.rightChild;
      } else {
        return ancestors;
      }
    }
    
    return null;
  }
  
  @Override
  public List leaves() {
    List<Key> leaves = new ArrayList<Key>();
    
    Stack<Node> stack = new Stack<Node>();
    
    if (root != null)
      stack.push(root);
    
    while ( !(stack.isEmpty()) ) {
      
      Node node = stack.pop();
      if (node.rightChild != null)
        stack.push(node.rightChild);
      if (node.leftChild != null)
        stack.push(node.leftChild);
      if (node.leftChild == null && node.rightChild == null)
        leaves.add((Key) node.element);
    }
    
    
    return leaves;
  }
  
  
  
  @Override
  public List elementsAtLevel(int level) {
    List<Key> keys = new LinkedList<Key>();
    int currentLevel = -1;
    
    Queue<Node> q1 = new LinkedList<Node>();
    Queue<Node> q2 = new LinkedList<Node>();
    
    if (root != null)
      q1.add(root);
    
    upper:
    while(true) {
      currentLevel++;
      if (currentLevel == level) {
        while( !(q1.isEmpty()) ) {
          keys.add((Key) q1.remove().element);
        }
        break upper;
      }
      
      while( !(q1.isEmpty()) ) {
        
        Node node = q1.remove();
        
        if (node.leftChild != null)
          q2.add(node.leftChild);
        if (node.rightChild != null)
          q2.add(node.rightChild);
        
      }
      
      Queue<Node> tmp = q1;
      q1 = q2;
      q2 = tmp;
      if ( q1.size() == 0 )
        break;
    }
    
    return keys;
  }
  
  
  
  @Override
  public List createpreorder(List inorder, List postorder) {
    List<Key> keys = new ArrayList<Key>();
    createpreorderImpl(inorder, postorder, keys);
    return keys;
  }
  private void createpreorderImpl(List inorder, List postorder, List<Key> keys) {
    
    if ( postorder.isEmpty() ) {
      return;
    } else {
      // root is the last element of postorder
      Object parent = postorder.get(postorder.size()-1);
      
      keys.add((Key) parent);
      //System.out.println(parent);
      // index of parent in inorder
      int inorderParentIndex = inorder.indexOf(parent);
      
      // solve left and right separately
      // left subtree
      List<Key> leftSubtreeInorder = inorder.subList(0, inorderParentIndex);
      List<Key> leftSubtreePostorder = postorder.subList(0, inorderParentIndex);
      
      //right subtree
      List<Key> rightSubtreeInorder = inorder.subList(inorderParentIndex+1, inorder.size());
      List<Key> rightSubtreePostorder = postorder.subList(inorderParentIndex, postorder.size()-1);
      
      createpreorderImpl(leftSubtreeInorder, leftSubtreePostorder, keys);
      createpreorderImpl(rightSubtreeInorder, rightSubtreePostorder, keys);
      
    }
  }
  
  
  
  @Override
  public List createpostorder(List inorder, List preorder) {
    List<Key> keys = new ArrayList<Key>();
    createpostorderImpl(inorder, preorder, keys);
    return keys;
  }
  private void createpostorderImpl(List inorder, List preorder, List<Key> keys) {
    
    if ( preorder.isEmpty() ) {
      return;
    } else {
      // root is the last element of postorder
      Object parent = preorder.get(0);
      
      //System.out.println(parent);
      // index of parent in inorder
      int inorderParentIndex = inorder.indexOf(parent);
      
      // solve left and right separately
      int leftSize = inorderParentIndex;
      int rightSize = inorder.size() - (inorderParentIndex+1);
      
      // left subtree
      List<Key> leftSubtreeInorder = new ArrayList<Key>();
      List<Key> rightSubtreeInorder = new ArrayList<Key>();
      List<Key> leftSubtreePreorder = new ArrayList<Key>();
      List<Key> rightSubtreePreorder = new ArrayList<Key>();
      
      if (inorderParentIndex > 0) {
        leftSubtreeInorder = inorder.subList(0, inorderParentIndex);
        leftSubtreePreorder = preorder.subList(1, inorderParentIndex+1);
      }
      if (inorderParentIndex < inorder.size()-1) {
        rightSubtreeInorder = inorder.subList(inorderParentIndex+1, inorder.size());
        rightSubtreePreorder = preorder.subList(inorderParentIndex+1, preorder.size());
      }
      
      
      createpostorderImpl(leftSubtreeInorder, leftSubtreePreorder, keys);
      createpostorderImpl(rightSubtreeInorder, rightSubtreePreorder, keys);
      keys.add((Key) parent);
      
    }
  }
  
  
  
  
}
