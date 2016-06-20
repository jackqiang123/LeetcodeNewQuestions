// Design an algorithm to encode a list of strings to a string. The encoded
// string is then sent over the network and is decoded back to the original list
// of strings.
//
// Machine 1 (sender) has the function:
// string encode(vector<string> strs) { // ... your code return encoded_string; }
// Machine 2 (receiver) has the function:
// vector<string> decode(string s) { //... your code return strs; }
//
// So Machine 1 does:
// string encoded_string = encode(strs);
// and Machine 2 does:
// vector<string> strs2 = decode(encoded_string);
// strs2 in Machine 2 should be the same as strs in Machine 1.
//
// Implement the encode and decode methods.
//
// Note: The string may contain any possible characters out of 256 valid ascii characters.
// Your algorithm should be generalized enough to work on any possible characters.
// Do not use class member/global/static variables to store states.
// Your encode and decode algorithms should be stateless. Do not rely on any library method
// such as eval or serialize methods. You should implement your own encode/decode algorithm.

public class Codec {
    public String encode(List<String> strs) {
      StringBuilder res = new StringBuilder();
      for (String s : strs){
        res.append(s.length()).append(":").append(s);
      }
      return res.toString();
    }
    public List<String> decode(String strs) {
      List<String> res = new ArrayList<>();
      if (strs.length() == 0) return res;
      int i = 0;
      while(i < strs.length()){
        int end = strs.indexOf(':', i);
        int count = Integer.parseInt(strs.substring(i,end));
        String cur = strs.substring(end + 1, 1 + end + count);
        res.add(cur);
	    i = cur.length() + end + 1;
      }
      return res;
    }
}
