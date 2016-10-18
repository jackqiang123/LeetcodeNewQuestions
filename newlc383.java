// Given  an arbitrary  ransom  note  string and another string containing letters from  all the magazines,  write a function that will return true if the ransom  note can be constructed from the magazines ; otherwise, it will return false.  
//
// Each letter  in  the  magazine string can  only be  used once  in  your ransom  note.
//
// Note:
// You may assume that both strings contain only lowercase letters.
//
// canConstruct("a", "b") -> false
// canConstruct("aa", "ab") -> false
// canConstruct("aa", "aab") -> true

// Note:
// You may assume that both strings contain only lowercase letters.
//
// canConstruct("a", "b") -> false
// canConstruct("aa", "ab") -> false
// canConstruct("aa", "aab") -> true
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
      int []mag = new int[26];
      for(int i = 0; i < magazine.length(); i++){
        mag[magazine.charAt(i)-'a']++;
      }
      for (int i = 0; i < ransomNote.length(); i++){
        char c = ransomNote.charAt(i);
        mag[c-'a']--;
        if (mag[c-'a'] < 0) return false;
      }
      return true;
    }
}
