// You are given an integer array nums and you have to return a new counts array.
// The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
//
// Example:
//
// Given nums = [5, 2, 6, 1]
//
// To the right of 5 there are 2 smaller elements (2 and 1).
// To the right of 2 there is only 1 smaller element (1).
// To the right of 6 there is 1 smaller element (1).
// To the right of 1 there is 0 smaller element.
//
// Return the array [2, 1, 1, 0].
public class Solution {
    int []res;
    class MyNum{
      int n;
      int i;
      public MyNum(int n, int i){
        this.n = n; this.i = i;
      }
    }
    public List<Integer> countSmaller(int[] num) {
      res = new int[num.length];
      MyNum[] nums = new MyNum[num.length];
      for (int i = 0; i < num.length; i++){
        nums[i] = new MyNum(num[i], i);
      }
      helper(nums, 0, nums.length - 1);
      List<Integer> r = new ArrayList<>();
      for (int i : res)
        r.add(i);
      return r;
    }
    private void helper(MyNum []nums, int lo, int hi){
      if (lo >= hi) return;
      int mid = (lo+hi)/2;
      helper(nums, lo, mid);
      helper(nums, mid+1, hi);
      MyNum[]temp = new MyNum[hi-lo+1];
      int lp = lo;
      int rp = mid + 1;
      int index = 0;
      while(lp <= mid || rp <= hi){
        if (lp <= mid && rp <= hi){
          if (nums[lp].n <= nums[rp].n) {
            temp[index++] = nums[lp];
            res[nums[lp++].i] += rp-mid-1;
          }
          else{// num[lo] > num[rp]
            temp[index++] = nums[rp++];
          }
        }
        else if (lp <= mid){
          temp[index++] = nums[lp];
          res[nums[lp++].i] += rp-mid-1;
        }
        else{
          temp[index++] = nums[rp++];
        }
      }
      for (int i = lo; i <=hi; i++)
        nums[i] = temp[i-lo];
    }
}
