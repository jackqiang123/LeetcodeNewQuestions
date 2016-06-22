// Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
//
// Range Sum Query 2D
// The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
//
// Example:
// Given matrix = [
//       [3, 0, 1, 4, 2],
//       [5, 6, 3, 2, 1],
//       [1, 2, 0, 1, 5],
//       [4, 1, 0, 1, 7],
//       [1, 0, 3, 0, 5]
//     ]
//
// sumRegion(2, 1, 4, 3) -> 8
// update(3, 2, 2)
// sumRegion(2, 1, 4, 3) -> 10
// Note:
//     The matrix is only modifiable by the update function.
//     You may assume the number of calls to update and sumRegion function is distributed evenly.
//     You may assume that row1 ��?row2 and col1 ��?col2.
//
// Hide Tags Segment Tree Binary Indexed Tree
// Hide Similar Problems (M) Range Sum Query 2D - Immutable (M) Range Sum Query - Mutable

public class NumMatrix {
    int [][]nums;
    int [][]tree; // the tree i,j is the rect sum from i - lowbit(i), j - lowbit(j) to i, j
    int h;
    int w;
    public NumMatrix(int[][] matrix) {
      h = matrix.length;
      if (h == 0){ w = 0; return;}
      w = matrix[0].length;
      tree = new int[h+1][w+1];
      nums = new int[h][w];
      for (int i = 0; i < h; i++){
        for (int j = 0; j < w; j++)
          update(i,j,matrix[i][j]);
      }
    }
    private int lowbit(int x){
      return x & (-x);
    }
    public void update(int row, int col, int val) {
      int diff = -nums[row][col] + val;
      nums[row][col] = val;
      row++; col++;//one based
      for (int i = row; i <= h; i += lowbit(i))
        for (int j = col; j <= w; j += lowbit(j))
            tree[i][j] += diff;
    }
    private int sum(int row, int col){
      if (row < 0 || col < 0) return 0;
      int res = 0;
      row++; col++;
      for (int i = row; i > 0; i -= lowbit(i))
        for (int j = col; j > 0; j -= lowbit(j))
          res += tree[i][j];
      return res;
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
      return sum(row2, col2) + sum(row1-1, col1 - 1) - sum(row1 - 1, col2) - sum(row2, col1 - 1);
    }
}



// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);
