// Given a non-empty array of integers, return the k most frequent elements.
//
// For example,
// Given [1,1,1,2,2,3] and k = 2, return [1,2].
//
// Note:
// You may assume k is always valid, 1 ��?k ��?number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int n : nums){
        if (map.get(n) == null) map.put(n,1);
        else map.put(n, map.get(n) + 1);
      }
      int []freq = new int[nums.length + 1];
      Map<Integer, List<Integer>> freqToNum = new HashMap<>();
      for (int num : map.keySet())
      {
        freq[map.get(num)]++;
        if (freqToNum.get(map.get(num)) == null) freqToNum.put(map.get(num), new ArrayList<Integer>);
        freqToNum.get(map.get(num)).add(num);
      }
      List<Integer> res = new ArrayList<>();
      for (int i = freq.length - 1; i >= 0; i--){
        if (freq[i] != 0){
          List<Integer> numList = freqToNum.get(i);
          for (int j : numList){
            res.add(j);
            k--;
            if (k == 0) return res;
          }
        }
      }
    }
}
