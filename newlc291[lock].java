// Problem Description:
//
// Given a pattern and a string str, find if str follows the same pattern.
//
// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
//
// Examples:
//
//         pattern = "abab", str = "redblueredblue" should return true.
//         pattern = "aaaa", str = "asdasdasdasd" should return true.
//         pattern = "aabb", str = "xyzabcxzyabc" should return false.
//
// Notes:
// You may assume both pattern and str contains only lowercase letters.
public class Solution {
	    Map<String, Character> map2 = new HashMap();
	    Map<Character, String> map1 = new HashMap();
	    public boolean wordPatternMatch(String pattern, String str) {
	      if (pattern.length() > str.length() || pattern.length() == 0 && str.length() != 0) return false;
	      return dfs(pattern, 0, str, 0);
	    }
	    private boolean dfs(String pattern, int pstart, String str, int start){
	      if (pstart == pattern.length()) return str.length() == start;
	      else {
	        char p = pattern.charAt(pstart);
	        if (map1.get(p) != null){
	          String value = map1.get(p);
	          if (start + value.length() > str.length() || !str.substring(start, start + value.length()).equals(value)) return false;
	          if (map2.get(value) == null || map2.get(value) != p) return false;
	          return dfs(pattern, pstart + 1, str, start + value.length());
	        }
	        else {
	          for (int i = 1; i + start <= str.length(); i++){
	            if (map2.get(str.substring(start, i + start)) == null){
	              map2.put(str.substring(start, i + start), p);
	              map1.put(p, str.substring(start, i + start));
	              if (dfs(pattern, pstart + 1, str, start + i)) {
	                return true;
	              }
	              map2.remove(str.substring(start, i + start));
	              map1.remove(p);
	            }
	          }
	          return false;
	        }
	      }
	    }
	}
