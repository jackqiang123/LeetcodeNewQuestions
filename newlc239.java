// Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
// You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//
// For example,
// Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
//
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Therefore, return the max sliding window as [3,3,5,5,6,7].

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      int len = nums.length;
      k = Math.min(k, len);
      int reslen = len - k + 1;
      int[]res = new int[reslen];
      PriorityQueue<Integer> pq = new PriorityQueue(k, Collections.reverseOrder());
      int i = 0;
      while(i < k){
        pq.add(nums[i]);
      }
      int j = 0;
      while(j < reslen){
        res[j++] = pq.peek();
        pq.remove(nums[i - k]);
        pq.add(i == len - 1? 0 : nums[i++]);
      }
      return res;
    }
}
