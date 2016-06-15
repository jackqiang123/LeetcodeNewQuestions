// Given a string s, return all the palindromic permutations (without duplicates) of it.
// Return an empty list if no palindromic permutation could be form.
//
// For example:
//
// Given s = "aabb", return ["abba", "baab"].
//
// Given s = "abc", return [].
//
// Hint:
//
// If a palindromic permutation exists, we just need to generate the first half of the string.
// To generate all distinct permutations of a (half of) string, use a similar approach from:
// Permutations II or Next Permutation.
public class Solution {
    List<String> res;
    public List<String> generatePalindromes(String s) {
      int []count = new int[26]; // assume there are only lowercase elements
      for (int i = 0; i < s.length(); i++){
        count[s.charAt(i) - 'a']++;
      }
      int diff = 0;
      for (int c : count){
        if (c%2==1) diff++;
      }
      if (s.length()%2 == 0 ? diff == 0 : diff == 1) return new ArrayList<String>();
      String mid = "";
      for (int i = 0; i < 26; i++){
        if (count[i] %2 == 1) mid = String.valueOf((char)('a'+i));
        count[i] /= 2;
      }
      res = new ArrayList<>();
      dfs(count, mid, new StringBuidler(), s.length()/2);
      return res;
    }
    private void dfs(int []count, String mid, StringBuilder cur, int len){
      if (len == cur.length()){
        res.add(cur.toString() + mid + cur.reverse());
      }
      else{
        for (int i = 0; i < count.length; i++){
          if (count[i] != 0){
            count[i]--;
            cur.append('a'+i);
            dfs(count, mid, cur, len);
            count[i]++;
            cur.remove(cur.length()-1);
          }
        }
      }
    }
}
