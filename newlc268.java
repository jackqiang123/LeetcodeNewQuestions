// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
// find the one that is missing from the array.
//
// For example,
// Given nums = [0, 1, 3] return 2.
//
public class Solution {
    // int x = x ^ a ^ a
    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int x : nums)
            xor ^= x;
        for (int i = 0; i <= nums.length; i++)
            xor ^= i;
        return xor;
    }
}
