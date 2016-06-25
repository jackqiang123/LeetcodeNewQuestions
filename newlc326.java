// Given an integer, write a function to determine if it is a power of three.
//
// Follow up:
// Could you do it without using any loop / recursion?
public class Solution {
  public boolean isPowerOfThree(int n) {
    if (n <= 0) return false;
    if (n == 1) return true;
    if (n == 2) return false;
    while(n >= 3){
      if (n%3 != 0) return false;
      n /= 3;
    }
    return n == 1;
  }
}
