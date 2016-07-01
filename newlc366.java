// Given a binary tree, find all leaves and then remove those leaves. Then repeat the previous steps until the tree is empty.
//
// Example:
// Given binary tree
//           1
//          / \
//         2   3
//        / \
//       4   5
// Returns [4, 5, 3], [2], [1].
//
// Explanation:
// 1. Remove the leaves [4, 5, 3] from the tree
//
//           1
//          /
//         2
// 2. Remove the leaf [2] from the tree
//
//           1
// 3. Remove the leaf [1] from the tree
//
//           []
// Returns [4, 5, 3], [2], [1].
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 public class Solution {
     Map<Integer, List<Integer>> map;
     public List<List<Integer>> findLeaves(TreeNode root) {
       map = new HashMap<>();
       List<List<Integer>> res = new ArrayList<>();
       if (root == null) return 0;
       dfs(root);
       int i = 1;
       while(map.get(i)!=null){
         res.add(0,map.get(i++));
       }
       return res;
     }
     private int dfs(TreeNode root){
       if (root == null) return 0;
       int level = 1 + Math.max(dfs(root.left), dfs(root.right));
       if (map.get(level) == null) map.put(level, new ArrayList<Integer>());
       map.get(level).add(root.val);
       return level;
     }
 }
