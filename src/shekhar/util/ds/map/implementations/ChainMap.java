package shekhar.util.ds.map.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import shekhar.util.ds.map.interfaces.Map;
import shekhar.util.ds.map.utilities.CommonUtils;
import shekhar.util.ds.map.utilities.HashFunction;

/**
 *
 * @author shekhar2010us
 */
public class ChainMap implements Map {
  
  private int N = 607;      // default size to start with
  private int rehashNum = 100;    // after every 100 insertions, check for rehashing
  private int maxListSizePerm = 2;
  private Node array[];     // array holds the elements of the map
  private int size;         // number of elements inserted to the map
  private HashFunction h;
  private int collisions;
  private CommonUtils commonutils;
  
  public ChainMap() {
    Initializer();
  }
  
  public ChainMap(int capacity) {
    N = capacity*3;
    Initializer();
  }
  
  private void Initializer() {
    array = new Node[N];
    size = 0;
    h = new HashFunction();
    commonutils = new CommonUtils();
  }
  
  @Override
  public void printTomb() {}
  
  @Override
  public int getHashCode(String key) {
    return h.hash_function(key, N);
  }
  
  public class Node {
    String key;
    String element;
    Node next;
    
    Node() {
      next = null;
    }
    
    Node(String k, String e) {
      this();
      key = k;
      element = e;
    }
    
    public String getKey() {
      return key;
    }
    public String getElement() {
      return element;
    }
    public void setElement(String e) {
      element = e;
    }
    
  }
  
  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return (size == 0) ? true : false;
  }
  
  @Override
  public String get(String key) {
    int index = h.hash_function(key, N);
    Node node = array[index];
    if (node == null) {    // no element in this index, i.e. key not present
      return null;
    } else {
      while (node.next != null) {
        node = node.next;
        if ( node.getKey().equals(key) ) {
          return node.getElement();
        }
      }
    }
    return null;
  }
  
  @Override
  public void put(String key, String element) {
    // calc index, navigate the list in that index, check if the key is already present,
      // if present replace with the new, if absent, add new
    
    int index = h.hash_function(key, N);
    Node node = array[index];
    if (node == null) {    // no element in this index
      Node node1 = new Node();
      Node node2 = new Node(key, element);
      node1.next = node2;
      array[index] = node1;
      size++;
      rehash();
    } else {
      collisions++;
      while (node.next != null) {
        node = node.next;
        if (node.getKey().equals(key)) {     // Check of the key is present in the list
         node.setElement(element);
         break;
        }
        if (node.next == null) {    // add at the end of the list
          Node node2 = new Node(key, element);
          node.next = node2;
          size++;
          rehash();
          break;
        }
      }
    }
  }
  
  @Override
  public Set<String> keySet() {
    Set<String> keys = new HashSet<String>();
    for ( int i = 0 ; i < array.length; ++i ) {
      Node node = array[i];
      if ( node != null ) {
        while (node.next != null) {
          node = node.next;
          keys.add(node.getKey());
        }
      }
    }
    
    return keys;
  }
  
  @Override
  public void remove(String key) {
   
    
  }
  
  @Override
  public void devUtils() {
    System.out.println("\n###############################");
    System.out.println("Array Length: " + array.length);
    System.out.println("Map Size: " + size());
    System.out.println("Collisions: " + collisions);
    System.out.println("###############################\n");
  }
  
  public void rehash() {
    
    if ( size % rehashNum == 0) {
        // check the top 10% list average size, if it is > 5
        // create a new array with double size (nearest prime number)
        // take out everything from old array and put into the new array
      
      int top100PercentAvg = gettop10PercentAvg();
      if ( top100PercentAvg >= maxListSizePerm) {
        System.out.println("Rehash!!!");
        Node oldArray[] = array;
        int oldN = N;
        List<String> keys = new ArrayList<String>( keySet() );
        List<String> elems = new ArrayList<String>();
        for ( String key : keys ) {
          elems.add( get(key) );
        }
        
        N = commonutils.calcPrimeNearTo( N*2 );
        Initializer();
        for ( int i = 0 ; i < keys.size(); ++i ) {
          put( keys.get(i), elems.get(i) , "rehash");
        }
        System.out.println("put all..");
      }
      
    }
    
  }
  
  private int gettop10PercentAvg() {
    
    List<Integer> sizes = new ArrayList<Integer>();
    
    for ( int i = 0 ; i < array.length; ++i ) {
      int len = 0;
      Node node = array[i];
      if ( node != null ) {
        while (node.next != null) {
          node = node.next;
          len++;
        }
      }
      sizes.add(len);
    }
    
    Collections.sort(sizes);
    List<Integer> tmp = sizes.subList( (int) ( N - 0.1 * N), N );
    //List<Integer> tmp = sizes.subList( (int) ( sizes.size() - 0.1 * sizes.size()), sizes.size() );
    
    double average = 0.0;
    for (Integer num : tmp) {
      average += num;
    }
    
    return (int) ( (average / tmp.size()) );
    
  }
  
  public void put(String key, String element, String comment) {
    // calc index, navigate the list in that index, check if the key is already present,
      // if present replace with the new, if absent, add new
    
    int index = h.hash_function(key, N);
    Node node = array[index];
    if (node == null) {    // no element in this index
      Node node1 = new Node();
      Node node2 = new Node(key, element);
      node1.next = node2;
      array[index] = node1;
      size++;
    } else {
      collisions++;
      while (node.next != null) {
        node = node.next;
        if (node.getKey().equals(key)) {     // Check of the key is present in the list
         node.setElement(element);
         break;
        }
        if (node.next == null) {    // add at the end of the list
          Node node2 = new Node(key, element);
          node.next = node2;
          size++;
          break;
        }
      }
    }
  }
  
}
