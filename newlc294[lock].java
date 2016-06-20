// Problem Description:
//
// You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
//
// Write a function to determine if the starting player can guarantee a win.
//
// For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".
//
// Follow up:
// Derive your algorithm's runtime complexity.

public class Solution {
 public boolean canWin(String s) {
   List<String> next = generatePossibleNextMoves(s);
   if (next.size() == 0) return false;
   for (String snext : next){
     if (!canWin(snext)) return true;
   }
  return false;
 }
 private List<String> generatePossibleNextMoves(String s) {
   List<String> res = new ArrayList<>();
   for (int i = 0; i < s.length() - 1; i++){
     if (s.substring(i,i+2).equals("++")){
       char[]array = s.toCharArray();
       array[i] = '-';
       array[i+1] = '-';
       res.add(new String(array));
     }
   }
   return res;
 }
}
