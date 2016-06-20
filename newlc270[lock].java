// Given a non-empty binary search tree and a target value,
// find the value in the BST that is closest to the target.
//
// Note:
//
// Given target value is a floating point.
// You are guaranteed to have only one unique value in the BST that is closest to the target.
public class Solution{
  public int closestValue(TreeNode root, double target) {
    TreeNode cur = root;
    while(root != null){
      if (Math.abs(root.val - target) < Math.abs(cur.val - target))
        cur = root;
      if (root.val < target)
        root = root.right;
      else root = root.left;

    }
    return cur.val;
   }
}
