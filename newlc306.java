// Additive number is a string whose digits can form additive sequence.
//
// A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
//
// For example:
// "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
//
// 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
//
// "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
//
// 1 + 99 = 100, 99 + 100 = 199
//
// Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
//
// Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
//
// Follow up:
// How would you handle overflow for very large input integers?
public class Solution {
   public boolean isAdditiveNumber(String num) {
     if (num.length() < 2) return false;
     int len = num.length();
     for (int i = 0; i < len/2; i++){
      for (int j = i + 1; j <= len/2; j++){
        long n1 = Long.parseInt(num.substring(0,i+1));
        if (num.charAt(i+1) == '0') continue;
        long n2 = Long.parseInt(num.substring(i+1,j+1));
        if (isValid(num, n1, n2, j + 1)) return true;
      }
     }
     return false;
   }
   private boolean isValid(String num, long i, long j, int start){
     if (start == num.length()) return true;
     String target = String.valueOf(i + j);
     if (target.length() + start > num.length()) return false;
     String check = num.substring(start, start + target.length());
     if (!target.equals(check)) return false;
     return isValid(num, j, i + j, target.length() + start);
   }
}
