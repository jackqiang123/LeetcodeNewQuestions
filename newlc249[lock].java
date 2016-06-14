// Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd".
// We can keep "shifting" which forms the sequence:
//
// "abc" -> "bcd" -> ... -> "xyz"
// Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
//
// For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
// Return:
//
// [
//   ["abc","bcd","xyz"],
//   ["az","ba"],
//   ["acef"],
//   ["a","z"]
// ]
// Note: For the return value, each inner list's elements must follow the lexicographic order.

public class Solution{
    public List<List<String>> groupStrings(String[] strings) {
      Map<String, List<String>> map = new HashMap();
      for (String s : strings){
        String encode = getCode(s);
        if (map.get(encode) == null) map.put(encode, new ArrayList<String>());
        map.get(encode).add(s);
      }
      List<List<String>> res = new ArrayList<>();
      for (List<String> cur : res.values()){
        Collections.sort(cur);
        res.add(cur);
      }
      return res;
   }
}
