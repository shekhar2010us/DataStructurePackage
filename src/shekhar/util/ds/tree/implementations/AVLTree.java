package shekhar.util.ds.tree.implementations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author shekhar2010us
 */

public class AVLTree<Key extends Comparable<Key> > {
  
  private Comparator< ? super Key> comparator;
  
  final int compare(Object k1, Object k2) {
    
    if ( comparator==null ) {
      return ((Comparable<? super Key>) k1).compareTo((Key)k2);
    } else {
      return comparator.compare((Key) k1, (Key) k2);
    }
    
  }
  
  private Node root;
  
  private enum RotationType {
    singleLeft, singleRight, doubleLeft, doubleRight;
  }
  
  public AVLTree() {
    root = null;
  }
  
  public void insert(Comparable k) {
    
    // insert element
    boolean added = insertElem(k);
    
    if (added) {
      System.out.println("Inserted: " + k);
      
      // check first ancestor where unbalance occurred
      Node ancestor = firstAncestorWhereUnBalance(k);
      
      // if ancestor is null, there is no unbalance...
      if ( ancestor != null ) {
        // ancestor not null, check rotation type
        RotationType type = findRotationType(k, ancestor);
        System.out.println("\tfirst ancestor where unbalance is : " + ancestor.element + "\tRotation: " + type.name());
        
        // perform rotation at ancestor of type 'type'
        rotate(ancestor, type);
      }
      
    } else {
      System.out.println("Already present: " + k);
    }
    
  }
  
  private boolean insertElem(Comparable k) {
    
    boolean added = true;
    
    Node tmp = new Node(k);
    
    if (root == null)
      root = tmp;
    else {
      Node current = root;
      Node parent;
      while (current != null) {
        int compared = compare(k, current.element);
        if ( compared < 0 ) {
          parent = current;
          current = current.leftChild;
          if (current == null)
            parent.leftChild = tmp;
        } else if ( compared > 0 ) {
          parent = current;
          current = current.rightChild;
          if (current == null)
            parent.rightChild = tmp;
        } else {
          // same key, break
          return false;
        }
      }
    }
    return added;
    
  }
  
  private RotationType findRotationType(Comparable k, Node ancestor) {
    
    if ( compare(k, ancestor.element) < 0 ) {
      Node middle = ancestor.leftChild;
      if ( compare(k, middle.element) < 0 )
        return RotationType.singleLeft;
      else
        return RotationType.doubleLeft;
    }
    else {
      Node middle = ancestor.rightChild;
      if ( compare(k, middle.element) > 0 )
        return RotationType.singleRight;
      else
        return RotationType.doubleRight;
    }
    
  }
  
  private void rotate(Node ancestor, RotationType type) {
    
    if (type.equals(RotationType.singleLeft))
      rotateSingleLeft(ancestor);
    
    else if (type.equals(RotationType.singleRight))
      rotateSingleRight(ancestor);
    
    else if (type.equals(RotationType.doubleLeft))
      rotateDoubleLeft(ancestor);
    
    else
      rotateDoubleRight(ancestor);
    
  }
  
  private Node findParent(Node node) {
    Node parent = root;
    
    Node current = root;
    while ( current != null ) {
      int compared = compare(node.element, current.element);
      if (compared < 0) {
        parent = current;
        current = current.leftChild;
      } else if (compared > 0) {
        parent = current;
        current = current.rightChild;
      } else {
        return parent;
      }
    }
    
    return null;
  }
  
  private void rotateSingleLeft(Node ancestor) {
    
    Node parent = ancestor.leftChild;
    
    if ( ancestor != root ) {
      Node ancestorParent = findParent(ancestor);
      if ( compare(ancestor.element, ancestorParent.element) < 0 ) {
        // ancestor is the left child of its parent
        ancestorParent.leftChild = parent;
      } else
        ancestorParent.rightChild = parent;
    } else {
      root = parent;
    }
    
    ancestor.leftChild = parent.rightChild;
    parent.rightChild = ancestor;
    
  }
  
  private void rotateSingleRight(Node ancestor) {
    Node parent = ancestor.rightChild;
    
    if ( ancestor != root ) {
      Node ancestorParent = findParent(ancestor);
      if ( compare(ancestor.element, ancestorParent.element) < 0 ) {
        // ancestor is the left child of its parent
        ancestorParent.leftChild = parent;
      } else
        ancestorParent.rightChild = parent;
    } else {
      root = parent;
    }
    
    ancestor.rightChild = parent.leftChild;
    parent.leftChild = ancestor;
    
  }
  
  private void rotateDoubleLeft(Node ancestor) {
    
    Node parent = ancestor.leftChild;
    Node child = parent.rightChild;
    
    // step 1: swap parent and child
    ancestor.leftChild = child;
    parent.rightChild = child.leftChild;
    child.leftChild = parent;
    
    // Step 2: swap child and ancestor.. same as singleleft rotation
    rotateSingleLeft(ancestor);
    
  }
  
  private void rotateDoubleRight(Node ancestor) {
    
    Node parent = ancestor.rightChild;
    Node child = parent.leftChild;
    
    // step 1: swap parent and child
    ancestor.rightChild = child;
    parent.leftChild = child.rightChild;
    child.rightChild = parent;
    
    // Step 2: swap child and ancestor.. same as singleleft rotation
    rotateSingleRight(ancestor);
    
  }
  
  
  public int height(Comparable k) {
    
    int height = 0;
    Node current = root;
    
    while ( current != null ) {
      int compared = compare(k, current.element);
      if ( compared < 0 ) {
        current = current.leftChild;
      } else if ( compared > 0 ) {
        current = current.rightChild;
      } else {
        // element found in the tree = current
        // run the height code here !!
        return height(current);
      }
    }
    
    return height;
  }
  
  private int height(Node node) {
    
    int height = 0;
    Node current = node;
    
    Queue q1 = new LinkedList();
    Queue q2 = new LinkedList();
    q1.add(current);
    
    while (true) {
      
      while( !(q1.isEmpty()) ) {
        Node front = (Node) q1.remove();
        //System.out.print(front.element + " , ");
        
        if ( front.leftChild != null ) {
          q2.add(front.leftChild);
        }
        
        if ( front.rightChild != null ) {
          q2.add(front.rightChild);
        }
        
      }
      //System.out.print("\n");
      height++;
      // put q2 into q1
      if (q2.size() != 0) {
        q1 = q2;
        q2 = new LinkedList();
      } else {
        break;
      }
      
    }
    
    
    return height;
  }
  
  public boolean isKeyHeightBalanced(Comparable k) {
    boolean result = false;
    
    Node current = root;
    
    while ( current != null ) {
      int compared = compare(k, current.element);
      if ( compared < 0 ) {
        current = current.leftChild;
      } else if ( compared > 0 ) {
        current = current.rightChild;
      } else {
        // element found in the tree = current
        // run the height code here !!
        return isNodeHeightBalanaced(current);
      }
    }
    
    return result;
  }
  
  private boolean isNodeHeightBalanaced(Node node) {
    boolean result = false;
    
    int heightL = (node.leftChild == null) ? 0 : height(node.leftChild);
    int heightR = (node.rightChild == null) ? 0 : height(node.rightChild);
    
    if ( Math.abs(heightL - heightR) <= 1 )
      return true;
    
    return result;
  }
  
  public boolean isAVLTree() {
    boolean result = true;
    
    List<Key> keys = inorder();
    boolean bal = true;
    for (Key i : keys) {
      bal = isKeyHeightBalanced(i);
      if (bal == false)
        return false;
    }
    
    
    return result;
  }
  
  /**
   * This is the first ancestor where unbalance occurred while inserting the Key k
   * @return
   */
  public Node firstAncestorWhereUnBalance(Comparable k) {
    
    Node ancestor = null;
    Node current = root;
    
    while (current != null) {
      
      if ( !(isNodeHeightBalanaced(current)) ) {
        ancestor = current;
      }
      
      int compared = compare(k, current.element);
      if (compared < 0)
        current = current.leftChild;
      else if (compared > 0)
        current = current.rightChild;
      else
        break;
      
    }
    
    
    return ancestor;
    
  }
  
  /**
   * This is the first ancestor where unbalance occurred while inserting the Node node
   * @return
   */
  private Node firstAncestorWhereUnBalance(Node node) {
    
    Node ancestor = null;
    Node current = root;
    Key k = (Key) node.element;
    
    while (current != null) {
      
      if ( !(isNodeHeightBalanaced(current)) ) {
        ancestor = current;
      }
      
      int compared = compare(k, current.element);
      if (compared < 0)
        current = current.leftChild;
      else if (compared > 0)
        current = current.rightChild;
      else
        break;
      
    }
    
    return ancestor;
  }
  
  
  public List<Key> inorder() {
    List<Key> keys = new ArrayList<Key>();
    inorder(root, keys);
    return keys;
  }
  
  private void inorder(Node node, List<Key> keys) {
    
    if (node == null) {
      return;
    } else {
      inorder(node.leftChild, keys);
      //      System.out.print(node.element + " , ");
      keys.add((Key) node.element);
      inorder(node.rightChild, keys);
    }
    
  }
  
  
  
  /**
   * Delete the key k from the tree.
   * @param k 
   */
  public void delete(Comparable k) {
    
  }
  
}
