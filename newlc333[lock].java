// Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
// where largest means subtree with largest number of nodes in it.
//
// Note:
// A subtree must include all of its descendants.
// Here's an example:
//
//     10
//     / \
//    5  15
//   / \   \
//  1   8   7
// The Largest BST Subtree in this case is the highlighted one.
// The return value is the subtree's size, which is 3.
//
//
//
// Hint:
//
// You can recursively use algorithm similar to 98.
// Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
// Follow up:
// Can you figure out ways to solve it with O(n) time complexity?
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
     class Result{
       boolean validBst;
       int size;
       int lowerBound;
       int upperBound;
       public Result(boolean validBST, int size, int lowerBound, int upperBound){
         this.validBst = validBST;
         this.size = size;
         this.lowerBound = lowerBound;
         this.upperBound = upperBound;
       }
     }
     int max;
     public int largestBSTSubtree(TreeNode root) {
       if (root == null) return 0;
       max = 0;
       helper(root);
       return max;
     }
     private Result helper(TreeNode root){
       if (root == null) return new Result(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
       Result left = helper(root.left);
       Result right = helper(root.right);
       if (!left.validBst || !right.validBst) return new Result(false, 0, 0, 0);
       if (left.upperBound > root.val || right.lowerBound < root.val) return new Result(false, 0, 0, 0);
       max = Math.max(max, 1 + left.size + right.size);
       return new Result(true, 1 + left.size + right.size, Math.min(left.lowerBound, root.val), Math.max(right.upperBound, root.val));
     }
 }
