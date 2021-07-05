class RandomizedSet {
    ArrayList<Integer> nums;//stores the val
    HashMap<Integer, Integer> val_map;//key is the val and value is the index of val
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        val_map = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean flag = val_map.containsKey(val);
        if (flag) return false;
        val_map.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean flag = val_map.containsKey(val);
        if (!flag) return false;
        int index = val_map.get(val);
        if (index == nums.size() - 1) {
            val_map.remove(val);
            nums.remove(nums.size() - 1);
        } else {
            int lastnum = nums.get(nums.size() - 1);
            nums.set(index, lastnum);
            val_map.put(lastnum, index);
            val_map.remove(val);
            nums.remove(nums.size() - 1);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */