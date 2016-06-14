// This is a follow up of Shortest Word Distance. The only difference is now you are given the
// list of words and your method will be called repeatedly many times with different parameters.
// How would you optimize it?
//
// Design a class which receives a list of words in the constructor, and implements a method
// that takes two words word1 and word2 and return the shortest distance between these two words in the list.
//
// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
// Given word1 = "coding��? word2 = "practice��? return 3.
// Given word1 = "makes", word2 = "coding", return 1.
//
// Note:
// You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
public class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
      map = new HashMap();
      for (String s : words){
        map.put(s, map.get(s) == null ? 1 : map.get(s) + 1);
      }
    }

    public int shortest(String word1, String word2) {
      List<Integer> list1 = map.get(word1);
      List<Integer> list2 = map.get(word2);
      int res = Integer.MAX_VALUE;
      int i = 0; int j = 0;
      while(i < list1.size() || j < list2.size()){
        if (i < list1.size() && j < list2.size()){
          res = Math.min(res, Math.abs(list1.get(i)-list2.get(j)));
          if (list1.get(i) < list2.get(j)) i++;
          else j++;
        }
        else if (i < list1.size()){
          res = Math.min(res, Math.abs(list1.get(i++) - list2.get(list2.size() - 1)));
        }
        else
          res = Math.min(res, Math.abs(list2.get(j++) - list1.get(list1.size() - 1)));
      }
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
