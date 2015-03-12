package shekhar.util.ds.trie;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shekhar2010us
 */
public class Trie {
  
  Node root;
  
  class Node {
    char c;
    Node next;
    List<Node> children;
  }
  
  public Trie() {
    root = new Node();
  }
  
  public Trie(String s) {
    this();
    insert(s);
  }
  
  public Trie(List<String> list) {
    this();
    for (String s : list) {
      insert(s);
    }
  }
  
  public Trie(String[] arr) {
    this();
    for (String s : arr) {
      insert(s);
    }
  }
  
  // unordered insertion // later on will write for ordered
  public final void insert(String s) {
    assert(s != null && s.length() > 0);
    char [] arr = s.toCharArray();
    int len = arr.length;
    
    List<Node> children = root.children;
    
    if (children == null) {   // no element
      children = new ArrayList<Node>();
      Node node = new Node();
      node.c = arr[0];
      children.add(node);
      //children = node.children;
    }
    
    int iter = 0;
    while (iter < len) {
      if (children == null) {
        Node node = new Node();
        node.c = arr[iter];
        children = node.children;
      } else {
        char currChar = arr[iter];
        for (Node n : children) {
          if ( n.c != currChar ) {
            n = n.next;
          } else {    // character found !! find the children and continue with the loop of insering characters
            children = n.children;
            iter++;
            break;
          }
        }
      }
      iter++;
    }
  }
  
}
