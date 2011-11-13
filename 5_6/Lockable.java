interface Lockable {
    int X = 82048;
    public boolean setKey(int key);
    public boolean setKey(int oldKey, int newKey);
    public boolean lock(int key);
    public boolean unlock(int key);
    public boolean locked();
}