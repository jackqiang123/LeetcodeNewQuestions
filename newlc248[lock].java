// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
// Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
public class Solution{
      public int strobogrammaticInRange(String low, String high){
        int lowbit = low.length();
        int highbit = high.length();
        int res = 0;
        for (int l = lowbit; l <= highbit; l++){
          List<String> cur = findStrobogrammatic(l);
          if (l == lowbit){
            for (String s : cur){
              if (String.compare(lowbit, s) <= 0) res++;
            }
          }
          else if (l == highbit){
            for (String s : cur){
              if (String.compare(highbit, s) >= 0) res++;
            }
          }
          else res += cur.size();
        }
        return res;
      }
      static Map<Character, Character> map;
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
          List<String> cur = findStrobogrammatic(n-2);
          for (String curString : cur){
            for (String key : map.keySet()){
              res.add(key + curString + map.get(key));
            }
          }
        }
        return res;
      }
   }
}
