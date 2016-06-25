// Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list,
// so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
//
// Example 1:
// Givewn words = ["bat", "tab", "cat"]
// Return [[0, 1], [1, 0]]
// The palindromes are ["battab", "tabbat"]
// Example 2:
// Given words = ["abcd", "dcba", "lls", "s", "sssll"]
// Return [[0, 1], [1, 0], [3, 2], [2, 4]]
// The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
      Map<String, List<Integer>> map = new HashMap<>();
      for (int i = 0; i < words.length; i++)
        map.put(words[i], i);
      List<List<Integer>> res = new ArrayList<>();
      for (int j = 0; j < words.length; j++){
        String s = words[j];
        //add on left.
        for (int i = s.length() - 1; i >= 0; i--){
          String addPart = new StringBuilder(s.substring(i)).reverse();
          if (map.get(addPart) == null || addPart.equals(s)) continue;
          String tryWord = addPart + s;
          if (validPan(tryWord)){
            List<Integer> r = new ArrayList<>();
            r.add(j);r.add(i);
            res.add(r);
          }
        }

        //add on right
        for (int i = 1; i < s.length(); i++){
          String addPart = new StringBuilder(s.substring(0,i)).reverse();
          if (map.get(addPart) == null || addPart.equals(s)) continue;
          String tryWord = s +addPart;
          if (validPan(tryWord)){
            List<Integer> r = new ArrayList<>();
            r.add(i);r.add(j);
            res.add(r);
          }
        }
      }
        return res;
    }
}
