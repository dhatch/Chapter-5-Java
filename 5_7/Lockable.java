/**
 * @author David Hatch, Brian Eyring
 * Assignment 5.6
 */

/**
 * Allows locking of object's so their methods will not function unless 
 * unlocked
 *
 * @see LockableBase
 */
public interface Lockable {
    
    /**
     * Sets the lock key.  Only can be used when no key has been set.
     * @param key The new key to store
     * @throws RuntimeException If called when a key has been set previously
     * @return true for sucess, false for failure.  In most implmentations 
     * always true.
     */
    public boolean setKey(int key);
    
    /**
     * Used to set the lock key when a previous key has been set.
     * @param oldKey The previous lock key
     * @param newKey The new lock key to set
     * @return true for sucess, false for failure.  False if oldKey is wrong
     */
    public boolean setKey(int oldKey, int newKey);
    
    /**
     * Locks the object
     * @param key The key for the object
     * @return false if key is wrong, else true.
     */
    public boolean lock(int key);
    
    /**
     * Unlocks the object
     * @param key The lock key
     * @return false if key is wrong. Object will remain locked. Else true
     */
    public boolean unlock(int key);
    
    /**
     * @return True if object is locked.
     */
    public boolean locked();
}
