public abstract class LockableBase {
    
    // Lockable Fields
    private boolean locked;
    private Integer lockKey;
    //
    
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