// There is a new alien language which uses the latin alphabet.
// However, the order among letters are unknown to you. You receive a list of words
// from the dictionary, wherewords are sorted lexicographically by the rules of this new language.
// Derive the order of letters in this language.
//
// For example,
// Given the following words in dictionary,
//
// [
//   "wrt",
//   "wrf",
//   "er",
//   "ett",
//   "rftt"
// ]
// The correct order is: "wertf".
//
// Note:
//
// You may assume all letters are in lowercase.
// If the order is invalid, return an empty string.
// There may be multiple valid order of letters, return any one of them is fine.
public class Solution{
 public String alienOrder(String[] words) {
   HashMap<Character, Set<Character>>map = new HashMap<>();
   HashMap<Character, Integer>preCount = new HashMap<>();
   for (int i = 1; i < words.length; i++){
     String cur = words[i];
     String last = words[i-1];
     for (int j = 0; j < Math.min(cur.length(),last.length()); j++)
     {
    	 if (cur.charAt(j) == last.charAt(j)) continue;
         if (map.get(last.charAt(j)) == null) map.put(last.charAt(j),new HashSet());
         map.get(last.charAt(j)).add(cur.charAt(j));
         break;
     }
   }
   for (char key : map.keySet()){
	   for (char next : map.get(key)){
		   if (preCount.get(next) == null) preCount.put(next,1);
		   else preCount.put(next, preCount.get(next) + 1);
	   }
   }

   Set<Character> hasInList = new HashSet<>();
   for (String s : words){
     for (int i = 0; i < s.length(); i++)
      hasInList.add(s.charAt(i));
   }
   Queue<Character> queue = new LinkedList<>();
   for (char c = 'a'; c <= 'z'; c++){
     if (preCount.get(c) == null && hasInList.contains(c))  queue.add(c);
   }
   StringBuilder res = new StringBuilder();
   while(!queue.isEmpty()){
     char cur = queue.remove();
     res.append(cur);
     Set<Character> nb = map.get(cur);
     if (nb != null){
       for (char nbchar : nb){
         preCount.put(nbchar, preCount.get(nbchar) - 1);
         if (preCount.get(nbchar) == 0){
           queue.add(nbchar);
         }
       }
     }
   }
   return (res.length() == hasInList.size()) ? res.toString() : "";
 }
}
