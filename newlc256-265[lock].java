// There are a row of n houses, each house can be painted with one of the three colors:
// red, blue or green.
// The cost of painting each house with a certain color is different.
// You have to paint all the houses such that no two
// adjacent houses have the same color.
// The cost of painting each house with a certain color is represented by
// a n x 3 cost matrix.
// For example, costs[0][0] is the cost of painting house 0 with color red;
// costs[1][2] is the cost of painting house
// 1 with color green, and so on... Find the minimum cost to paint all houses.
// Note: All costs are positive integers.
public class Solution {
    public int minCost(int[][] costs) {
      int hlen = costs.length;
      if (hlen == 0) return 0;
      int clen = costs[0].length;
      int [][]dp = new int[hlen][clen];
      int lowestIndex = 0;
      int secondIndex = 0;
      for (int i = 0; i < hlen; i++){
        for (int j = 0; j < clen; j++){
          if (i == 0) {
            dp[i][j] = costs[i][j];
          }
          else {
            if (lowestIndex != j)
              dp[i][j] = costs[i][j] + dp[i-1][lowestIndex];
            else dp[i][j] = costs[i][j] + dp[i-1][secondIndex];
            }
          }
          lowestIndex = 0;
          secondIndex = 0;
        for (int j = 0; j < clen; j++){
          if (dp[i][lowestIndex] > dp[i][j]){
            secondIndex = lowestIndex; lowestIndex = j;
          }
          else if (lowestIndex == secondIndex || dp[i][secondIndex] > dp[i][j]){
            secondIndex = j;
          }
        }
        }
        int res = dp[hlen-1][0];
        for (int i = 1; i < clen; i++){
          res = Math.min(res, dp[hlen-1][i]);
        }
        return res;
      }
  }
