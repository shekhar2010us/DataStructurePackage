/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.ds.map.implementations;

import java.util.ArrayList;
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
public class DHashMap implements Map {
  /*
   * 
   * The array index is the key of the map, and the array element is the value of the map
   */
  
  private int N = 607;      // default size to start with
  private MapObject array[];     // array holds the values of the map
  private int size;         // number of elements inserted to the map
  private HashFunction h;
  private CommonUtils commonutils;
  
  private String tombstone = "\u2764\u0191\u01DC\u0108\u0137\u2764";
  private double fullFactor = 0.6;          // rehash if array is full by fullfactor
  private double tombstoneFactor = 0.25;    // rehash if array has this many tombstone
  private int collisions;
  private int tombstoneCount;
  
  public DHashMap() {
    Initializer();
  }
  
  public DHashMap(int capacity) {
    N = capacity*3;
    Initializer();
  }
  
  private void Initializer() {
    array = new MapObject[N];
    size = 0;
    h = new HashFunction();
    commonutils = new CommonUtils();
  }
  
  public class MapObject {
    String key;
    String element;
    
    MapObject() {}
    
    MapObject(String k, String e) {
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
  public void printTomb() {
    System.out.println("Tombstone: " + tombstone);
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
    MapObject obj = array[index];
    while ( obj != null ) {
      if ( obj.getKey().equals(key) ) {
        return obj.getElement();
      }
      int double_hash = ( h.double_hash_function(key, N) ) ;
      index = (index + double_hash) % N;      // this is probing.... Instead of ++, implement the second hashing function
      obj = array[index];
    }
    return null;
  }
  
  @Override
  public void put(String key, String element) {
    int index = h.hash_function(key, N);
    MapObject obj = array[index];
    while ( obj != null ) {
      if ( obj.getKey().equals(key) ) {
        collisions++;
        // replace the element of the existing key
        insert(key, element, index);
        break;
      }
      int double_hash = ( h.double_hash_function(key, N) ) ;
      index = (index + double_hash) % N;      // this is probing.... Instead of ++, implement the second hashing function
      obj = array[index];
    }
    
    // insert new key at this index
    insert(key, element, index);
  }
  
  private void insert(String key, String element, int index) {
    // check if fullfactor is up
    MapObject newObj = new MapObject(key, element);
    array[index] = newObj;
    size++;
    
    if ( calcFullFactor() >= fullFactor || calcTombstoneFactor() >= tombstoneFactor ) {
      rehash();
    }
    
  }
  
  @Override
  public Set<String> keySet() {
    Set<String> keys = new HashSet<String>();
    for ( int i = 0 ; i < array.length; ++i ) {
      MapObject obj = array[i];
      if ( obj != null ) {
        keys.add(obj.getKey());
      }
    }
    keys.remove(tombstone);
    return keys;
  }
  
  @Override
  public void remove(String key) {
    int index = h.hash_function(key, N);
    MapObject obj = array[index];
    while ( obj != null ) {
      if ( obj.getKey().equals(key) ) {
        tombstoneCount++;
        size--;
        MapObject newObj = new MapObject(tombstone, null);
        array[index] = newObj;
        break;
      }
      int double_hash = ( h.double_hash_function(key, N) ) ;
      index = (index + double_hash) % N;      // this is probing.... Instead of ++, implement the second hashing function
      obj = array[index];
    }
  }
  
  @Override
  public void devUtils() {
    System.out.println("\n###############################");
    System.out.println("Array Length: " + array.length);
    System.out.println("Map Size: " + size());
    System.out.println("Tomb stone count: " + tombstoneCount);
    System.out.println("Collisions: " + collisions);
    System.out.println("Full Factor: " + calcFullFactor() );
    System.out.println("TombStone full Factor: " + calcTombstoneFactor() );
    System.out.println("###############################\n");
  }
  
  @Override
  public int getHashCode(String key) {
    return h.hash_function(key, N);
  }
  
  private double calcFullFactor() {
    return ( (double)size/(double)N );
  }
  
  private double calcTombstoneFactor() {
    return ( (double)tombstoneCount/(double)N );
  }
  
  public void rehash() {
    devUtils();
    System.out.println("Rehash!!!");
    MapObject oldArray[] = array;
    int oldN = N;
    List<String> keys = new ArrayList<String>( keySet() );
    List<String> elems = new ArrayList<String>();
    for ( String key : keys ) {
      elems.add( get(key) );
    }
    //System.out.println("Rehash!!!");
    N = commonutils.calcPrimeNearTo( N*2 );
    Initializer();
    for ( int i = 0 ; i < keys.size(); ++i ) {
      //System.out.println(i + "  added in rehash");
      put( keys.get(i), elems.get(i));
    }
    //System.out.println("Rehash!!!");
    
  }
  
}
