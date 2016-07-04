// An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
//
// a) it                      --> it    (no abbreviation)
//
//      1
// b) d|o|g                   --> d1g
//
//               1    1  1
//      1---5----0----5--8
// c) i|nternationalizatio|n  --> i18n
//
//               1
//      1---5----0
// d) l|ocalizatio|n          --> l10n
// Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
//
// Example:
// Given dictionary = [ "deer", "door", "cake", "card" ]
//
// isUnique("dear") -> false
// isUnique("cart") -> true
// isUnique("cane") -> false
// isUnique("make") -> true
public class ValidWordAbbr {
    Set<String> wordList;
    Map<String, Boolean> abbList;
    public ValidWordAbbr(String[] dictionary) {
      wordList = new HashSet<>();
      abbList = new HashMap<>();
      for (String w : dictionary){
        if (wordList.contains(w)) continue;
        wordList.add(w);
        String abWord = getAbb(w);
        if (abbList.get(abWord) == null) abbList.put(abWord, false);
        else abbList.put(abWord, true);
      }
    }

    private String getAbb(String s){
      if (s.length() <= 2) return s;
      StringBuilder res = new StringBuilder();
      res.append(s.charAt(0));
      res.append(s.length()-2);
      res.append(s.charAt(s.length()-1));
      return res.toString();
    }

    public boolean isUnique(String word) {
      String abb = getAbb(word);
      if (wordList.contains(word)){
          return !abbList.get(abb);
      }
      else{
          return abbList.get(abb) == null;
      }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
