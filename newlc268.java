// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
// find the one that is missing from the array.
//
// For example,
// Given nums = [0, 1, 3] return 2.
//
public class Solution {
    public int missingNumber(int[] nums) {
      int i = 0;
      while(i < nums.length){
        if (i == nums.length) i++;
        else if (i == nums[i]) i++;
        else if (nums[i] < nums.length && nums[i] == nums[nums[i]]) i++;
        else swap(nums, i, nums[i]);
      }
      for (int i = 0; i < nums.length; i++){
        if (nums[i] != i) return i;
      }
      return nums.length;
   }
   private void swap(int []num, int i, int j){
     int t = num[i];
     num[i] = num[j];
     num[j] = t;
   }
}
