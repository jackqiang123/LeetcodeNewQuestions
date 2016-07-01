// Given a positive integer num, write a function which returns True if num is a perfect square else False.
//
// Note: Do not use any built-in library function such as sqrt.
//
// Example 1:
//
// Input: 16
// Returns: True
// Example 2:
//
// Input: 14
// Returns: False
public class Solution {
    public boolean isPerfectSquare(int num) {
      if (num < 0) return false;
      if (num <= 1) return true;
      int lo = 2; int hi = num/2;
      while(lo < hi){
        int mid = (lo + hi)/2;
        if (num/mid > mid) lo = mid+1;
        else hi = mid;
      }
      return lo*lo == num || (lo+1)*(lo+1) == num;
    }
}
