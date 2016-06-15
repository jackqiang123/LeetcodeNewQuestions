// Given a string, determine if a permutation of the string could form a palindrome.
//
// For example, "code" -> False, "aab" -> True, "carerac" -> True.
//
// Hint:
//
// Consider the palindromes of odd vs even length. What difference do you notice?
// Count the frequency of each character. If each character occurs even number of times,
//then it must be a palindrome. How about character which occurs odd number of times?
public class Solution {
    public boolean canPermutePalindrome(String s) {
      int []count = new int[256];
      for (int i = 0; i < s.length(); i++){
        count[s.charAt(i)]++;
      }
      int diff = 0;
      for (int c : count){
        if (c%2==1) diff++;
      }
      return s.length()%2 == 0 ? diff == 0 : diff == 1;
   }
}
