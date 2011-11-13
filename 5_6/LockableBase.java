/**
 * @author David Hatch, Brian Eyring
 * Assignment 5.6
 */

/**
 * Abstract class with a standard implementation of the interface described in 
 * {@link Lockable}.  When extending this class, call {@link #assertUnlocked()} in each method
 * which must have unlock checking.
 */
public abstract class LockableBase {
    
    // Lockable Fields
    private boolean locked;
    // this field is an Integer so we can store null value when the object has 
    // no key
    private Integer lockKey;
    
    
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

    /**
     * Checks to ensure object is unlocked.  Call this in methods which
     * object should be unlocked when called.
     * @throws ObjectLockedException If the object is locked
     */
    protected void assertUnlocked() {
       if (locked) {
          throw new ObjectLockedException("Can't call method. Object is locked. Call unlock(int key) prior to method call.");
       }
    }
}