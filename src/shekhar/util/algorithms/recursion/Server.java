/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.util.algorithms.recursion;

/**
 *
 * @author shekhar2010us
 */
public class Server {
  
  public static void main (String [] args) {
    change((float) 28.98);
  }
  
  public static void change(float money2) {
    
    int quarters = 0;
    int dimes = 0;
    int nickles = 0;
    int pennies = 0;
    
    
    int money = (int)(money2*100);
    quarters = money/25;
    money = money%25;       // money = 8                              money = 23
    
    dimes = money/10;
    money = money%10;       // money = 8                           money = 3
    
    nickles = money/5;
    money = money%5;       // money = 3                                 money = 3
    
    pennies = money;
    
    
    System.out.println("Dollars: " + money2 + "  --> quarters, nickles,pennies: " + quarters + " , " + dimes + " ," + nickles + ", " + pennies);
    
  }
  
  
}



