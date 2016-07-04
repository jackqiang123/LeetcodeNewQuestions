// Given two arrays, write a function to compute their intersection.
//
// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
//
// Note:
// Each element in the result must be unique.
// The result can be in any order.
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      List<Integer> res = new LinkedList<>();
      Set<Integer> set = new HashSet<>();
      for (int i : nums1) set.add(i);
      for (int i : nums2) {if (set.contains(i)){
        res.add(i); set.remove(i);
      }}
      int [] list = new int[res.size()];
      int pos = 0;
      for (int i : res)
        list[pos++] = i;
      return list;
    }
}
