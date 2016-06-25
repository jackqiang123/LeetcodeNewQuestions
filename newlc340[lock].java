// Given a string, find the length of the longest substring T that contains at most k distinct characters.
//
// For example, Given s = “eceba��?and k = 2,
//
// T is "ece" which its length is 3.
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
      if (k == 0) return 0;
      Map<Character, Integer> map = new HashMap<>();
      int lp = 0; int rp = 0;
      int max = 0;
      while(rp < s.length()){
        while(rp < s.length()) {
          char c = s.charAt(rp);
          if (map.get(c) != null) {map.put(c, map.get(c) + 1); rp++;}
          else {
            if (map.size() < k) {map.put(c, 1); rp++;}
            else break;
          }
        }
        max = Math.max(max, rp - lp);
        while(map.size() >= k){
          char c = s.charAt(lp++);
          if (map.get(c) == 1) map.remove(c);
          else map.put(c, map.get(c)-1);
        }
      }
      return max;
    }
}
