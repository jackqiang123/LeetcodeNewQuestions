
    // Write a function to generate the generalized abbreviations of a word.
    //
    // Example:
    // Given word = "word", return the following list (order does not matter):
    //
    // ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
    //
public class Solution {
        List<String> res;
        public List<String> generateAbbreviations(String word) {
          res = new ArrayList<String>();
          dfs(word, 0, 0, new StringBuilder());
          return res;
        }
        private void dfs(String word, int start, int lastlen, StringBuilder cur){
          if (start == word.length()){
            if (lastlen != 0){
              res.add(cur.toString() + lastlen);
            }
            else {
              res.add(cur.toString());
            }
          }
          else{
            dfs(word, start + 1, lastlen + 1, cur);
            int len = cur.length();
            if (lastlen != 0)
              cur.append(lastlen);
            cur.append(word.charAt(start));
            dfs(word, start + 1, 0, cur);
            cur.setLength(len);
          }
        }
    }
