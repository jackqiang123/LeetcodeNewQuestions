// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
// Write a function to determine if a number is strobogrammatic. The number is represented as a string.
public class Solution{
  public boolean isStrobogrammatic(String n){
      if (n.length() == 0) return true;
      Map<Character, Character> map = new HashMap();
      map.put('1', '1');map.put('0', '0');map.put('8', '8');map.put('6', '9');map.put('9', '6');
      int i = 0;
      int j = n.length() - 1;
      while(i < j){
        if (map.get(n.charAt(i)) != n.charAt(j)) return false;
        i++; j--;
      }
      if (i == j){
        return n.charAt(i) == '0' || n.charAt(i) == '1' || n.charAt(i) == '8';
      }
   }
}
