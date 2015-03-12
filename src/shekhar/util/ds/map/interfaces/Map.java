/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.ds.map.interfaces;

import java.util.Set;

/**
 *
 * @author shekhar2010us
 */

public interface Map {
  
  // access methods
  public int size();
  public boolean isEmpty();
  public String get(String key);
  
  // update methods
  public void put(String key, String element);
  public void remove(String key);
  
  public Set<String> keySet();
  
  public int getHashCode(String key);
  
  public void devUtils();

  public void printTomb();
  
}
