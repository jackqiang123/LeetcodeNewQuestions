// Given a pattern and a string str, find if str follows the same pattern.
//
// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
//
// Examples:

//
//     pattern = "abba", str = "dog cat cat dog" should return true.
//     pattern = "abba", str = "dog cat cat fish" should return false.
//     pattern = "aaaa", str = "dog cat cat dog" should return false.
//     pattern = "abba", str = "dog dog dog dog" should return false.
//

// Notes:
// You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
public class Solution {
    public boolean wordPattern(String pattern, String str) {
      Map<Character, String> map1 = new HashMap();
      Map<String, Character> map2 = new HashMap();
      String[]words = str.split(" ");
      if (pattern.length() != words.length) return false;
      for (int i = 0; i < pattern.length(); i++){
        char c = pattern.charAt(i);
        String s = words[i];
        if (map1.get(c) != null && map1.get(c).equals(s)) continue;
        else if (map1.get(c) != null && !map1.get(c).equals(s)) return false;
        else if (map2.get(s) != null) return false;
        else {
          map1.put(c,s); map2.put(s,c);
        }
      }
      return true;
   }
}
