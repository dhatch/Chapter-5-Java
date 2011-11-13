/**
 * @author David Hatch, Brian Eyring
 * 
 * Assignment 5.6
 */

//********************************************************************
//  Coin.java       Author: Lewis/Loftus/Cocking
//
//  Represents a coin with two sides that can be flipped.
//********************************************************************
public class Coin extends LockableBase implements Lockable
{
   private final int HEADS = 0;
   private final int TAILS = 1;
   private int face;
   
   // Lockable Fields
   private boolean locked;
   private Integer lockKey;
   //
   
   //-----------------------------------------------------------------
   //  Sets up the coin by flipping it initially.
   //-----------------------------------------------------------------
   public Coin ()
   {
      flip();
   }
   //-----------------------------------------------------------------
   //  Flips the coin by randomly choosing a face value.
   //-----------------------------------------------------------------
   public void flip ()
   {
      assertUnlocked();
      face = (int) (Math.random() * 2);
   }
   //-----------------------------------------------------------------
   //  Returns true if the current face of the coin is heads.
   //-----------------------------------------------------------------
   public boolean isHeads ()
   {
      assertUnlocked();
      return (face == HEADS);
   }
   //-----------------------------------------------------------------
   //  Returns the current face of the coin as a string.
   //-----------------------------------------------------------------
   public String toString()
   {
      assertUnlocked();
      String faceName;
      if (face == HEADS)
         faceName = "Heads";
      else
         faceName = "Tails";
      return faceName;
   }
   
   // Lockable Methods
   public boolean setKey(int key) {
      assertUnlocked();
      if (lockKey == null) {
         lockKey = key;
         return true;
      } else {
         throw new RuntimeException("Cannot set key to new value without knowledge of old value.\n\tCall setKey(int oldKey, int newKey) to set a new key.");
      }
   }
   
   public boolean setKey(int oldKey, int newKey) {
      assertUnlocked();
      if (lockKey != null) {
         if (oldKey == lockKey) {
            lockKey = newKey;
            return true;
         }
      }
      return false;
   }
   
   public boolean lock(int key) {
      if (key == lockKey) {
         locked = true;
      }
      return locked;
   }
   
   public boolean unlock(int key) {
      if (key == lockKey) {
         locked = false;
      }
      return locked;
   }
   
   public boolean locked() {
      return locked;
   }
   
   protected void assertUnlocked() {
      if (locked) {
         throw new ObjectLockedException("Can't call method. Object is locked. Call unlock(int key) prior to method call.");
      }
   }
   
}

