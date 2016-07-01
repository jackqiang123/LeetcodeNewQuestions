// Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.
//
// Example:
// Given matrix = [
//   [1,  0, 1],
//   [0, -2, 3]
// ]
// k = 2
// The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).
//
// Note:
// The rectangle inside the matrix must have an area > 0.
// What if the number of rows is much larger than the number of columns?
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
      int h = matrix.length;
      int w = matrix[0].length;
      for (int i = 0; i < h; i++){
        for (int j = 1; j < w; j++)
          matrix[i][j] += matrix[i][j-1];
      }
      int max = Integer.MIN_VALUE;
      for (int left = 0; left < w; left++){
        for (int right = left; right < w; right++){
          int[]temp = getArray(matrix, left, right);
          max = Math.max(max, dpToFind(temp, k));
        }
      }
      return max;
    }
    private int[] getArray(int [][]matrix, int lo, int hi){
      int [] res = new int[matrix.length];
      for (int i = 0; i < res.length; i++){
        res[i] = matrix[i][hi] - (lo-1>=0?matrix[i][lo-1]:0);
      }
      return res;
    }
    // find the subarray of res such that it is max given smaller than upperBound
    private int dpToFind(int []res, int upperBound){
      int best = Integer.MIN_VALUE;
      for (int i = 1; i < res.length; i++)
	   res[i] += res[i-1];
      TreeSet<Integer> set = new TreeSet<Integer>();
      for (int i = 0; i < res.length; i++){
        if (res[i] <= upperBound) best = Math.max(best, res[i]);
        Integer ceil = set.ceiling(res[i]-upperBound);
        if (ceil != null) best = Math.max(best, res[i] - ceil);
        set.add(res[i]);
      }
      return best;
    }
}
