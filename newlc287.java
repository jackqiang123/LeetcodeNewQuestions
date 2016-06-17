// lGiven an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
// prove that at least one duplicate number must exist.
// Assume that there is only one duplicate number, find the duplicate one.
//
// Note:
// You must not modify the array (assume the array is read only).
// You must use only constant, O(1) extra space.
// Your runtime complexity should be less than O(n2).
// There is only one duplicate number in the array, but it could be repeated more than once.
public class Solution {
    public int findDuplicate(int[] nums) {
      int p1 = 0;
      int p2 = 0;
      while(true){
        p1 = nums[p1];
        p2 = nums[nums[p2]];
        if (p1 == p2) break;
      }
      p2 = 0;
      while(p1 != p2){
        p1 = nums[p1];
        p2 = nums[p2];
      }
      return p1;
   }
}
