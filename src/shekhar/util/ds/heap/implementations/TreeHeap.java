/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.ds.heap.implementations;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import shekhar.util.ds.heap.interfaces.Heap;

/**
 *
 * @author shekhar2010us
 */
public class TreeHeap< T extends Comparable<T> > implements Heap {
  
  private Node root;
  private int size;
  
  /**
   * Last node that was filled
   */
  public Node lastInsertedNode;
  
  @Override
  public int size() {
    return size;
  }
  
  private boolean isFirstSmaller(Node left, Node right) {
    if ( compare(left.element , right.element) < 0 ) {
      return true;
    } else {
      return false;
    }
  }
  
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
    
    /**
     * parent of the nodes
     */
    public Node parent;
    
    
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
  
  public TreeHeap () {
    root = null;
    size = 0;
  }
  
  @Override
  public void insert(Comparable element) {
    size++;
    if (root == null) {
      // put into root
      Node n = new Node(element);
      root = n;
      root.parent = null;
      lastInsertedNode = root;
    } else {
      // find nextnode to be inserted, put the new value in that
      Node nextNode = findNextNode();
      nextNode.element = element;
      lastInsertedNode = nextNode;
      
      // swap with parent until the heap property is not satisfied
      upheapify(nextNode);
      
    }
    
  }
  
  @Override
  public void delMin() {
    size--;
    
    // if last inserted node is root, delete it
    if (root == lastInsertedNode) {
      root = null;
      return;
    }
    // a) swap root and the lastInsertedNode
    Object tmp = root.element;
    root.element = lastInsertedNode.element;
    lastInsertedNode.element = tmp;
    
    // b) delete lastInsertedNode and make the new lastInsertedNode
    Node previ = findPreviousNode();   // this is the new last inserted node, after deleting current li
    
    // delete li == make it null and point its parent child to null
    if (isRightChild(lastInsertedNode)) {
      lastInsertedNode.parent.rightChild = null;
    } else {
      lastInsertedNode.parent.leftChild = null;
    }
    
    lastInsertedNode = previ;
    
    // c) heapify at root
    downheapify();
    
  }
  
  private Node findNextNode() {
    
    // calc # of levels in the heap
    Node tmpnode = root;
    int level = 0;
    Node tmp = root;
    if (tmp == null) {
      return root;
    } else {
      while (tmp.leftChild != null) {
        level++;
        tmp = tmp.leftChild;
        tmpnode = tmp;
      }
    }
    
    // check if heap is level full
    tmp = root;
    while (tmp.rightChild != null) {
      level--;
      tmp = tmp.rightChild;
    }
    
    
    if ( level == 0 ) {
      // level full, start with a new level
      Node n = new Node();
      tmpnode.leftChild = n;
      n.parent = tmpnode;
      return tmpnode.leftChild;
    } else {
      // level is not full, continue filling the same level
      
      // start from lastInsertedNode
      // if lastInsertedNode is left, no problem
      // else if lastInsertedNode is right,
      // got to parent until parent becomes left = 'z' node
      // and then move thru the sibling of the z node
      Node li = lastInsertedNode;
      if ( isRightChild( li )  ) {
        while( isRightChild( li ) ) {
          li = li.parent;
        }
        li = li.parent.rightChild;
        while ( li.leftChild != null ) {
          li = li.leftChild;
        }
        Node n = new Node();
        li.leftChild = n;
        n.parent = li;
        return li.leftChild;
      } else {
        Node n = new Node();
        li.parent.rightChild = n;
        n.parent = li.parent;
        return li.parent.rightChild;
      }
    }
    
  }
  
  
  @Override
  public Comparable min() {
    if (root != null)
      return (Comparable) root.element;
    else
      return null;
  }
  
  private Node findPreviousNode() {
    
    // This calc the previous inserted node from a given node "lastInserted" in our case
    // After deleting an element, we need to change the location of the lastInsertedNode
    
    // first check the level change
    // if there is a level change, straight away take the rightmost element
    Node r = root;
    while(r.leftChild != null) {
      r = r.leftChild;
    }
    if ( r.parent.rightChild == null ) {
      // its the last element in the level
        // previ is the rightmost node
      r = root;
      while(r.rightChild != null) {
        r = r.rightChild;
      }
      return r;
    }
    
    else {
      Node li = lastInsertedNode;   // last inserted node
      
      if (li == root) {
        // if last inserted node is root, no node is inserted before that
        return null;
      }
      else {
        if ( isRightChild(li) ) {
          // if last inserted node is a right child, get its left sibling
          return li.parent.leftChild;
        } else {
          // if the last inserted node is a left child
          //    climb up the parent until parent becomes right - let this be 'p'
          //    p.parent.left = 'tmp'
          //    come down right of tmp until right becomes null
          while( isLeftChild( li ) ) {
            li = li.parent;
          }
          
          li = li.parent.leftChild;
          while ( li.rightChild != null ) {
            li = li.rightChild;
          }
          return li;
        }
      }
    }
  }
  
  private boolean isRightChild(Node node) {
    Node parent = node.parent;
    if ( compare(parent.leftChild.element, node.element) == 0) {
      return false;
    } else {
      return true;
    }
  }
  
  private boolean isLeftChild(Node node) {
    Node parent = node.parent;
    if ( compare(parent.leftChild.element, node.element) == 0) {
      return true;
    } else {
      return false;
    }
  }
  
  
  /**
   * Up Heapify from Leaf n
   * @param n
   */
  private void upheapify(Node n) {
    // heapify at leaf n
    
    while ( true ) {
      // parent node
      Node parent = n.parent;
      
      if (parent == null) {   // reached root node
        return;
      }
      // if parent is large than the newly node n, swap
      if ( compare(parent.element , n.element) > 0 ) {
        Object tmp = n.element;
        n.element = parent.element;
        parent.element = tmp;
        n = n.parent;
      } else {
        return;
      }
      
    }
    
  }
  
  /**
   * Heapify at root
   * @param n
   */
  private void downheapify() {
    // heapify at root
    Node n = root;
    downheapify(n);
  }
  
  /**
   * Heapify at Node n
   * @param n
   */
  private void downheapify(Node n) {
    // heapify at node n
    
    while ( true )
    {
      
      if (n.leftChild == null && n.rightChild == null)
      {
        // both child null, means we are at the leaf node, no need of further comparisons
        return;
      }
      
      // if both are not null, that means atleast leftchild is present (if not right)
      Node left = n.leftChild;
      
      // lets check the right child now
      if (n.rightChild == null)
      {
        // rightchild is null, so compare the parent with only left child
        if ( compare(n.element, left.element) > 0 )
        {
          Object tmp = left.element;
          left.element = n.element;
          n.element = tmp;
        }
        // rightchild is null, means after comparison, we have reached leaf, so no need of any further comparisons
        return;
      } else {
        // if right is not null and both are not null, means both child are present
        Node right = n.rightChild;
        
        if ( compare(n.element, left.element) < 0 && compare(n.element, right.element) > 0 )
        {
          // parent is large than right child and smaller than left child, replace right child with parent
          Object tmp = right.element;
          right.element = n.element;
          n.element = tmp;
          n = n.rightChild;
        }
        else if ( compare(n.element, left.element) > 0 && compare(n.element, right.element) < 0 )
        {
          // parent is large than left child and smaller than right child, replace left child with parent
          Object tmp = left.element;
          left.element = n.element;
          n.element = tmp;
          n = n.leftChild;
        }
        else if ( compare(n.element, left.element) > 0 && compare(n.element, right.element) > 0 )
        {
          // parent is larger than both left and right child, replace parent with smaller of the child
          if ( isFirstSmaller(left, right) ) {
            // left is smaller, replace with left
            Object tmp = left.element;
            left.element = n.element;
            n.element = tmp;
            n = n.leftChild;
          } else {
            // right is smaller, replace with right
            Object tmp = right.element;
            right.element = n.element;
            n.element = tmp;
            n = n.rightChild;
          }
          
        }
        else
        {
          // in all other case, just return...
          // two cases possible here:
          // a) parent is smaller than both child (satisfying heap property)
          // b) parent is equal to either of the child (again satisfying heap property)
          return;
        }
        
      }
      
    }
    
  }
  
  @Override
  public void levelOrderPrint() {
    
    if (root == null) {
      System.out.println("empty heap.");
      return;
    }
    Queue<Node> q1 = new LinkedList<Node>();
    q1.add(root);
    
    Node n = null;
    while( !q1.isEmpty() ) {
      // while queue is empty, deqeueue front
      // and enqueue left and right child of the deqeueued element
      n = q1.remove();
      System.out.print(n.element + "\t");
      if (n.leftChild != null)
        q1.add(n.leftChild);
      if (n.rightChild != null)
        q1.add(n.rightChild);
    }
    System.out.println("");
  }
  
  private Comparator< ? super T> comparator;
  
  final int compare(Object k1, Object k2) {
    // - if k1 is less, 0 if equal, + if k1 is more
    if ( comparator==null ) {
      return ((Comparable<? super T>) k1).compareTo((T)k2);
    } else {
      return comparator.compare((T) k1, (T) k2);
    }
    
  }
  
  
}
