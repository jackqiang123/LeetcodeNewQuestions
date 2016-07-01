// Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.
//
// All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
//
// Example 1:
// str = "aabbcc", k = 3
//
// Result: "abcabc"
//
// The same letters are at least distance 3 from each other.
// Example 2:
// str = "aaabc", k = 3
//
// Answer: ""
//
// It is not possible to rearrange the string.
// Example 3:
// str = "aaadbbcc", k = 2
//
// Answer: "abacabcd"
//
// Another possible answer is: "abcabcda"
//
// The same letters are at least distance 2 from each other.
// Credits:

public class Solution {
    public String rearrangeString(String str, int k) {
      if (k <= 1) return str;
      int []count = new int[26];
      char[]array1 = str.toCharArray();
      Character[]array = new Character[array1.length];
      for (int i = 0; i < array.length; i++)
        array[i] = array1[i];
      for (char c : array) count[c-'a']++;
      Arrays.sort(array, new Comparator<Character>(){
        public int compare(Character c1, Character c2){
	        	if (count[c2 - 'a'] - count[c1 - 'a'] != 0)
	        		return count[c2 - 'a'] - count[c1 - 'a'];
	        	return c1 - c2;
        }
      });
      char[] res = new char[array.length];
      int startPos = 1;
      int pres = 0;
      int index = 0;
      int []initialLocation = new int[26];
      Arrays.fill(initialLocation,-1);
      for (char c : array){
        res[pres] = c;
        if (initialLocation[c-'a'] == -1) initialLocation[c-'a'] = pres;
        else if (Math.abs(initialLocation[c-'a'] - pres) < k) return "";
        pres += k;
        if (pres >= array.length) {
          pres = startPos++;
        }
      }
      return new String(res);
    }
}
