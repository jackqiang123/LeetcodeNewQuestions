// Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
// Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ��?j), inclusive.
//
// Note:
// A naive algorithm of O(n2) is trivial. You MUST do better than that.
//
// Example:
// Given nums = [-2, 5, -1], lower = -2, upper = 2,
// Return 3.
// The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
public class Solution {
  int res;
  int lower;
  int upper;
  public int countRangeSum(int[] num, int lower, int upper) {
    res = 0;
    this.lower = lower;
    this.upper = upper;
    long[] nums = new long[num.length];
    for (int i = 0; i < nums.length; i++)
    {
      if (i != 0)
        nums[i] = nums[i-1] + num[i];
      else nums[i] = num[i];
      if (nums[i] <= upper && nums[i] >= lower) res++;
    }
    helper(nums, 0, nums.length - 1);
    return res;
  }
  private void helper(long[]nums, int lo, int hi){
    if (lo >= hi) return;
    long[]temp = new long[hi-lo+1];
    int mid = (lo+hi)/2;
    helper(nums, lo, mid);
    helper(nums, mid + 1, hi);
    int lp = lo;
    int rp = mid + 1;
    int index = 0;
    int lowerIndex = mid + 1;
    int higherIndex = mid + 1;
    while(lp <= mid || rp <= hi){
      if (lp <= mid && rp <= hi){
        if (nums[lp] < nums[rp]){
          temp[index++] = nums[lp];
          lowerIndex = increaseLow(nums, lowerIndex, nums[lp], hi);
          higherIndex = increaseHigh(nums, higherIndex, nums[lp], hi);
          res += (higherIndex - lowerIndex);
          lp++;
        }
        else {
          temp[index++] = nums[rp++];
        }
      }
      else if (lp <= mid){
        temp[index++] = nums[lp];
        lowerIndex = increaseLow(nums, lowerIndex, nums[lp], hi);
        higherIndex = increaseHigh(nums, higherIndex, nums[lp], hi);
        res += (higherIndex - lowerIndex);
        lp++;
      }
      else {
          temp[index++] = nums[rp++];
      }
    }
    for (int i = lo; i <= hi; i++)
      nums[i] = temp[i-lo];
  }
  private int increaseLow(long []nums, int lowerIndex, long base, int bound){
    while(lowerIndex <= bound && nums[lowerIndex] - base < lower)  {
      lowerIndex++;
    }
    return lowerIndex;
  }
  private int increaseHigh(long []nums, int higherIndex, long base, int bound){
    while(higherIndex <= bound && nums[higherIndex] -base <= upper){
      higherIndex++;
    }
    return higherIndex;
  }
}
