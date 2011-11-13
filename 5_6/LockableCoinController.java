/**
 * @author David Hatch, Brian Eyring
 * Assignment 5.6
 */


class LockableCoinController {
   public static void main(String[] args) {
      Coin coin = new Coin();
      coin.setKey(22);
      coin.lock(22);
      System.out.println("LOCKED? "+coin.locked());
      coin.unlock(22);
      coin.setKey(22, 23);
      coin.lock(23);
      System.out.println("LOCKED?: "+coin.locked());
      boolean success = coin.unlock(22);
      System.out.println("unlock success? "+success);
      coin.flip();
   }
}