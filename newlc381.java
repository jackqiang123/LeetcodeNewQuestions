// Design a data structure that supports all following operations in average O(1) time.
// Note: Duplicate elements are allowed.
//
//     insert(val): Inserts an item val to the collection.
//     remove(val): Removes an item val from the collection if present.
//     getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
//
// Example:
//
// // Init an empty collection.
// RandomizedCollection collection = new RandomizedCollection();
//
// // Inserts 1 to the collection. Returns true as the collection did not contain 1.
// collection.insert(1);
//
// // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
// collection.insert(1);
//
// // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
// collection.insert(2);
//
// // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
// collection.getRandom();
//
// // Removes 1 from the collection, returns true. Collection now contains [1,2].
// collection.remove(1);
//
// // getRandom should return 1 and 2 both equally likely.
// collection.getRandom();

public class RandomizedCollection {
        /** Initialize your data structure here. */
        ArrayList<Integer> nums;
        Map<Integer, Set<Integer>> index;
        java.util.Random rand = new java.util.Random();
        public RandomizedCollection() {
          nums = new ArrayList<>();
          index = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
          nums.add(val);
          if (index.get(val) == null) index.put(val, new HashSet<Integer>());
          index.get(val).add(nums.size()-1);
          return index.get(val).size() == 1;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
          if (index.get(val) == null || index.get(val).size() == 0) return false;
          int i = index.get(val).iterator().next(); // to remove index
          int tail = nums.size() - 1;
          if (i != tail && nums.get(i) != nums.get(tail)){
            int t = nums.get(i);
            nums.set(i, nums.get(tail));
            nums.set(tail, t);
            index.get(nums.get(i)).remove(tail);
            index.get(nums.get(i)).add(i);
          }
          else if (nums.get(i) == nums.get(tail)){
              i = tail;
          }
          index.get(val).remove(i);
          nums.remove(tail);
          return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get( rand.nextInt(nums.size()) );
        }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
