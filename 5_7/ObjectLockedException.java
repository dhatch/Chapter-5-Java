/**
 * @author David Hatch, Brian Eyring
 * Assignment 5.6
 */

/**
 * Exception thrown when method calls are made on locked objects
 */
public class ObjectLockedException extends RuntimeException {
   
    /**
     * Only constructor
     * @param message the message to display for the exception 
     */   
    public ObjectLockedException(String message) {
        super(message);
    }
}
