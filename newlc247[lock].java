// A strobogrammatic number is a number that looks the same when rotated 180
// degrees (looked at upside down).
//
// Find all strobogrammatic numbers that are of length = n.
//
// For example,
// Given n = 2, return ["11","69","88","96"].
//
// Hint:
//
// Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
public class Solution {
    static Map<String, String> map;
    {
      map = new HashMap();
      map.put("1", "1");map.put("0", "0");map.put("8", "8");map.put("6", "9");map.put("9", "6");
    }
    public List<String> findStrobogrammatic(int n) {
      List<String> res = helper(n);
      if (n < 2) return res;
      List<String> withoutZeroRes = new ArrayList();
      for (String s : res){
        if (s.charAt(0) != '0')
          withoutZeroRes.add(s);
      }
      return withoutZeroRes;
    }
    public List<String> helper(int n) {
      List<String> res = new ArrayList();
      if (n == 1){
        res.add("1");res.add("0");res.add("8");
        return res;
      }
      else if (n == 2){
        for (String s : map.keySet()){
          res.add(s + map.get(s));
        }
      }
      else {
        List<String> cur = helper(n-2);
        for (String curString : cur){
          for (String key : map.keySet()){
            res.add(key + curString + map.get(key));
          }
        }
      }
      return res;
    }
}
