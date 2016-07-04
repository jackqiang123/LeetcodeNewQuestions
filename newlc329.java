// Given an integer matrix, find the length of the longest increasing path.
//
// From each cell, you can either move to four directions: left, right, up or down.
// You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
//
// Example 1:
//
// nums = [
//   [9,9,4],
//   [6,6,8],
//   [2,1,1]
// ]
// Return 4
// The longest increasing path is [1, 2, 6, 9].
//
// Example 2:
//
// nums = [
//   [3,4,5],
//   [3,2,6],
//   [2,2,1]
// ]
// Return 4
// The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
      int h = matrix.length;
      if (h == 0) return 0;
      int w = matrix[0].length;
      int [][]dp = new int[h][w];
      int res = 0;
      for (int i = 0; i < h; i++){
        for (int j = 0; j < w; j++){
          dfs(i,j,matrix,dp);
          res = Math.max(res, dp[i][j]);
        }
      }
      return res;
    }
    private int dfs(int i, int j, int[][]matrix, int[][]dp){
      if (dp[i][j] != 0) return dp[i][j];
      int cur = matrix[i][j];
      dp[i][j] = 1;
      int longestPath = 0;
      if (i-1>=0 && cur < matrix[i-1][j])
        longestPath = Math.max(longestPath, dfs(i-1,j,matrix,dp));
      if (i+1<matrix.length && cur < matrix[i+1][j])
          longestPath = Math.max(longestPath, dfs(i+1,j,matrix,dp));
      if (j-1>=0 && cur < matrix[i][j-1])
          longestPath = Math.max(longestPath, dfs(i,j-1,matrix,dp));
      if (j+1<matrix[0].length && cur < matrix[i][j+1])
          longestPath = Math.max(longestPath, dfs(i,j+1,matrix,dp));
      dp[i][j] += longestPath;
      return dp[i][j];
    }
}
