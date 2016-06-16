// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
// write a function to check whether these edges make up a valid tree.
//
// For example:
//
// Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
//
// Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
//
// Hint:
//
// Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return?
// Is this case a valid tree? Show More Hint Note: you can assume that no duplicate edges will appear in edges.
// Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
public class Solution {
  public boolean validTree(int n, int[][] edges) {
    if (n <= 1) return true;
    int [] root = new int[n];
    for (int i = 0; i < n; i++){
      root[i] = i;
    }
    for (int[]link : edges){
      int n1 = link[0];
      int n2 = link[1];
      if (findRoot(root,n1) == findRoot(root,n2)){
        return false;
      }
      root[findRoot(root, n2)] = findRoot(root,n1);
    }
    int rootIndex = findRoot(root, 0);
    for (int i = 1; i < n; i++){
        if (findRoot(root, i) != rootIndex) return false;
    }
    return true;
  }
  private int findRoot(int []root, int n){
    while(root[n] != n)
      n = root[n];
    return n;
  }
}
