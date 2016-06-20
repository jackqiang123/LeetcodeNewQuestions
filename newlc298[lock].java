    // Given a binary tree, find the length of the longest consecutive sequence path.
    //
    // The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
    //
    // For example,
    //
    //    1
    //     \
    //      3
    //     / \
    //    2   4
    //         \
    //          5
    //
    // Longest consecutive sequence path is 3-4-5, so return 3.
    //
    //    2
    //     \
    //      3
    //     /
    //    2
    //   /
    //  1
    //
    // Longest consecutive sequence path is 2-3,not3-2-1, so return 2.

    public class Solution {
        int res = 0;
        public int longestConsecutive(TreeNode root) {
          longestConsecutiveGivenRoot(root);
          return res;
        }
        public int longestConsecutiveGivenRoot(TreeNode root) {
          if (root == null) return 0;
          int left = longestConsecutiveGivenRoot(root.left);
          int right = longestConsecutiveGivenRoot(root.right);
          int thisRes = 1;
          if (left != 0 && root.left.val == root.val + 1){
            thisRes = 1 + left;
          }
          if (right != 0 && root.right.val == root.val + 1){
            thisRes = Math.max(thisRes, 1 + right);
          }
          res = Math.max(res, thisRes);
          return thisRes;
        }
    }
