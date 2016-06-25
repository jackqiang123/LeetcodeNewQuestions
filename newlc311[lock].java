// Given two sparse matrices A and B, return the result of AB.
//
// You may assume that A's column number is equal to B's row number.
//
// Example:
//
// A = [
//   [ 1, 0, 0],
//   [-1, 0, 3]
// ]
//
// B = [
//   [ 7, 0, 0 ],
//   [ 0, 0, 0 ],
//   [ 0, 0, 1 ]
// ]
//
//
//      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
// AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
//                   | 0 0 1 |
public class Solution{
 public int[][] multiply(int [][]A, int [][] B) {
   int h1 = A.length;
   int w1 = A[0].length;
   int w2 = B[0].length;
   int [][]res = new int[h1][w2];
   for (int i = 0; i < h1; i++){
     for (int j = 0; j < w1; j++){
       if (A[i][j]!=0){
         for (int k = 0; k < w2; k++){
           res[i][k] += A[i][j]*B[j][k];
         }
       }
     }
   }
   return res;
 }
}
