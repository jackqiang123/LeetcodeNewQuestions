// Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
//
// Example:
// (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
// (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
//
// Note:
// You may assume all input has valid answer.
//
// Follow Up:
// Can you do it in O(n) time and/or in-place with O(1) extra space?

public class Solution {
    public void wiggleSort(int[] nums) {
      int len = nums.length;
      if (len <= 1) return;
      Arrays.sort(nums);
      int p1 = (0+len-1)/2;
      int p2 = len-1;
      int temp[] = new int[len];
      int index = 0;
      while(index < len){
        temp[index++] = nums[p1--];
        if (index < len)
          temp[index++] = nums[p2--];
      }
      for (int i = 0; i < len; i++) nums[i] = temp[i];
    }
}
