// Given a binary tree, return all root-to-leaf paths.
//
// For example, given the following binary tree:
//
//    1
//  /   \
// 2     3
//  \
//   5
// All root-to-leaf paths are:
//
// ["1->2->5", "1->3"]
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
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
      res = new ArrayList();
      if (root == null) return res;
      helper(root, new ArrayList<Integer>());
      return res;
    }
    private void helper(TreeNode root, List<Integer> cur){
      cur.add(root.val);
      if (root.left == null && root.right == null){
        res.add(getResult(cur));
      }
      else {
        if (root.left != null){
          helper(root.left, cur);
        }
        if (root.right != null){
          helper(root.right, cur);
        }
      }
      cur.remove(cur.size()-1);
    }
    private String getResult(List<Integer> cur){
      StringBuilder res = new StringBuilder();
      for (int i = 0; i < cur.size() - 1; i++){
        res.append(cur.get(i)).append("->");
      }
      res.append(cur.get(cur.size() - 1));
      return res.toString();
    }
}
