// Given an integer array nums, find the sum of the elements between indices i and j (i ��?j), inclusive.
// The update(i, val) function modifies nums by updating the element at index i to val.
//
// Example:
//
// Given nums = [1, 3, 5]
//
// sumRange(0, 2) -> 9
// update(1, 2)
// sumRange(0, 2) -> 8
//
// Note:
//
//     The array is only modifiable by the update function.
//     You may assume the number of calls to update and sumRange function is distributed evenly.
public class NumArray {
    int []nums;
    BIT bitree;
    public NumArray(int[] nums) {
      bitree = new BIT(nums);
      this.nums = nums;
    }

    void update(int i, int val) {
      bitree.update(i + 1, val - nums[i]);
      nums[i] = val;
    }

    public int sumRange(int i, int j) {
      return bitree.sum(j) - bitree.sum(i-1);
    }
}

class BIT{
  int[]data;
  private int lowbit(int x){
    return x&(-x);
  }
  public BIT(int[]nums){
    data = new int[nums.length+1];
    for (int i = 1; i <= nums.length; i++){
      update(i, nums[i-1]);
    }
  }

  public void update(int i, int x){
    while(i < data.length){
      data[i] += x;
      i += lowbit(i);
    }
  }

  public int sum(int i){
    i++;
    int res = 0;
    while(i > 0){
      res += data[i];
      i -= lowbit(i);
    }
    return res;
  }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
