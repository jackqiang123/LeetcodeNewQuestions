// You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
//
// What is the maximum number of envelopes can you Russian doll? (put one inside other)
//
// Example:
// Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
      if (envelopes.length <= 1) return envelopes.length;
      Arrays.sort(envelopes, new Comparator<int[]>(){
        public int compare(int[]i1, int[]i2){
          if (i1[0] != i2[0]) return i1[0] - i2[0];
          return - i1[1] + i2[1];
        }
      });
      // sort all intervals by w, such that small w appears first;
      // we want to find the largest increasing subseq in the h dim.
      int []hvalue = new int[envelopes.length];
      for (int i = 0; i < hvalue.length; i++)
        hvalue[i] = envelopes[i][1];
      return findLongIncreasingSeq(hvalue);
   }
   private int findLongIncreasingSeq(int []nums){
     int dp[] = new int[nums.length];
     int len = 0;
     for (int i : nums){
       int x = Arrays.binarySearch(dp, 0, len, i);
       if (x < 0) x = -(x+1);
       dp[x] = i;
       if (x >= len) len++;
     }
     return len;
   }
}
