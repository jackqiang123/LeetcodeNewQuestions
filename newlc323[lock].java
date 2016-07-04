// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
//
// Example 1:
//      0          3
//      |          |
//      1 --- 2    4
// Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
//
// Example 2:
//      0           4
//      |           |
//      1 --- 2 --- 3
// Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
//
// Note:
// You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

public class Solution {
    public int countComponents(int n, int[][] edges) {
      int []root = new int[n];
      for (int i = 0; i < n; i++) root[i] = i;
      for (int[]edge:edges){
        int s = edge[0];
        int v = edge[1];
        if (connect(s, v, root)) n--;
      }
      return n;
    }
    private boolean connect(int s, int v, int[]root){
      int sRoot = findRoot(s, root);
      int vRoot = findRoot(v, root);
      if (sRoot == vRoot) return false;//not connect
      root[sRoot] = vRoot;
      return true;

    }
    private int findRoot(int s, int []root){
      while(s != root[s])
        s = root[s];
      return s;
    }
}
