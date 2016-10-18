// Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
//
// Note that it is the kth smallest element in the sorted order, not the kth distinct element.
//
// Example:
//
// matrix = [
//    [ 1,  5,  9],
//    [10, 11, 13],
//    [12, 13, 15]
// ],
// k = 8,
//
// return 13.
//
// Note:
// You may assume k is always valid, 1 ≤ k ≤ n2.
class Index{
  int x;
  int y;
  int val;
  public Index(int x, int y, int val){
    this.x = x; this.y = y; this.val = val;
  }
}
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
      PriorityQueue<Index> pq = new PriorityQueue<Index>(k+1, new Comparator<Index>(){
        public int compare(Index i1, Index i2){
          return i1.val - i2.val;
        }
      });// min queue. standard ones
      int h = matrix.length;
      int w = matrix[0].length;
      int lo = matrix[0][0];
      int hi = matrix[h-1][w-1];
      for (int i = 0; i < w; i++) pq.add(new Index(0,i,matrix[0][i]));
      for (int count = 1; count < k; count++){
        Index cur = pq.remove();
        if (cur.x + 1 < h) pq.add(new Index(cur.x + 1, cur.y, matrix[cur.x+1][cur.y]));
      }
      return pq.peek().val;
    }
}
