/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import shekhar.util.ds.map.implementations.ChainMap;
import shekhar.util.ds.map.implementations.DHashMap;
import shekhar.util.ds.map.interfaces.Map;
import shekhar.util.ds.map.utilities.HashFunction;

/**
 *
 * @author shekhar2010us
 */
public class MapTest {
  
  private static int m = 607;
  
  public static void checkCollisions( String file ) {
    HashFunction h = new HashFunction();
    
    int totalWordCount = 0;
    Set<Integer> IndexSet = new HashSet<>();
    Set<String> WordSet = new HashSet<>();
    int IndexCollision = 0;
    int WordCollision = 0;
    
    String text = readFile(file);
    String [] words = text.split(" ");
    for ( int i = 0 ; i < words.length; ++i ) {
      if ( words[i].trim().length() > 0 ) {
        totalWordCount++;
        int index = h.hash_function( words[i].trim() , m);
        System.out.println( index + " - " + words[i] );
        
        if (!(IndexSet.contains(index))) {
          IndexSet.add(index);
        }
        else {
          IndexCollision++;
        }
        
        if (!(WordSet.contains(words[i]))) {
          WordSet.add(words[i]);
        }
        else {
          WordCollision++;
        }
      }
    }
    
    System.out.println("\nTotal Words: " + totalWordCount );
    System.out.println("\nWords Collisions: " + WordCollision );
    System.out.println("\nIndex Collisions: " + IndexCollision );
    
  }
  
  public static void main(String [] args) {
    
    String file = "/Users/shekhar2010us/NetBeansProjects/DataStructurePackage/src/tttt";
    //checkCollisions(file);
    checkChainMap(file);
    
    //checkDHashMap();
    
  }
  
  public static void checkChainMap(String file) {
    Map map = new DHashMap();
    
//    map.put("shekhar", "100");
//    map.put("abhik", "75");
//    map.put("suvid", "50");
//    map.put("puneet", "0");
//    map.put("puneet2", "0");
//    map.put("puneet3", "0");
//    map.put("puneet", "10");
    
    String text = readFile(file);
    String [] words = text.split(" ");
    for ( int i = 0 ; i < words.length; ++i ) {
      map.put(words[i].trim(), "10");
      //System.out.println(i + "  element added..");
    }
    
    Set<String> keys = map.keySet();
    //System.out.println("All Keys: " + keys + "\n");
    
    for (String key : map.keySet()) {
      System.out.println( map.getHashCode(key) + " - " + key + " - " + map.get(key) );
    }
    
    map.devUtils();
    
    map.printTomb();
  }
  
  public static String readFile(String filename) {
    StringBuilder builder = new StringBuilder();
    BufferedReader reader = null;
    try {
      reader = new BufferedReader (new FileReader(filename));
      String line = null;
      while ( (line = reader.readLine()) != null  ) {
        builder.append(line).append(" ");
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(MapTest.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(MapTest.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        reader.close();
      } catch (IOException ex) {
        Logger.getLogger(MapTest.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return builder.toString();
  }

  private static void checkDHashMap() {
    
    Map map = new DHashMap();
    
    map.put("A" , "10");
    map.put("B" , "20");
    map.put("C" , "30");
    map.put("D" , "40");
    map.put("E" , "50");
    map.put("F" , "50");
    map.put("G" , "90");
    map.put("H" , "100");
    
    map.remove("D");
    
    System.out.println(map.keySet() + "\n");
    
    for (String key : map.keySet()) {
      System.out.println(key + " - " + map.get(key));
    }
    
    map.devUtils();
    
  }
  
}
