// Write a program to find the n-th ugly number.
//
// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
// For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
//
// Note that 1 is typically treated as an ugly number.
//
// Hint:
//
// The naive approach is to call isUgly for every number until you reach the nth one.
// Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
// An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
// The key is how to maintain the order of the ugly numbers. Try a similar approach of merging
// from three sorted lists: L1, L2, and L3.
// Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).

public class Solution {
    public int nthUglyNumber(int n) {
      Queue<Integer> q2 = new LinkedList();
      Queue<Integer> q3 = new LinkedList();
      Queue<Integer> q5 = new LinkedList();
      int num = 1;
      while(n > 1){
        q2.add(num*2);
        q3.add(num*3);
        q5.add(num*5);
        num = Math.min(q2.peek(), Math.min(q3.peek(), q5.peek()));
        if (q2.peek() == num){
          q2.remove();
        }
        else if (q3.peek() == num){
          q3.remove();
        }
        else {
          q5.remove();
        }
        q2.add(2*num);q3.add(3*num);q5.add(5*num);
        n--;
      }
      return num;
   }
}
