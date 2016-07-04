// Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this
// subset satisfies: Si % Sj = 0 or Sj % Si = 0.
//
// If there are multiple solutions, return any subset is fine.
//
// Example 1:
//
// nums: [1,2,3]
//
// Result: [1,2] (of course, [1,3] will also be ok)
// Example 2:
//
// nums: [1,2,4,8]
//
// Result: [1,2,4,8]
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
      Arrays.sort(nums);
      HashMap<Integer, List<Integer>> map = new HashMap<>();
      int []dp = new int[nums.length];
      for (int i = 0; i < nums.length; i++){
        int max = 1;
        List<Integer> cur = new ArrayList<>();
        if (i == 0) {dp[0] = 1;cur.add(nums[0]);map.put(nums[i], cur);}
        else {
          for (int j = i - 1; j >= 0; j--){
            if (nums[i]%nums[j] == 0 && max < 1 + map.get(nums[j]).size()){
              cur = map.get(nums[j]);
              max = 1 + cur.size();
            }
          }
          cur = new ArrayList<Integer>(cur);
          cur.add(nums[i]);
          map.put(nums[i], cur);
        }
      }
      List<Integer> best = new ArrayList<>();
      for (List<Integer> ls : map.values()){
        if (ls.size() > best.size()) best = ls;
      }
      return best;
    }
}
