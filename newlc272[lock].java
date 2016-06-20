// Problem Description:
//
// Given a non-empty binary search tree and a target value,
// find k values in the BST that are closest to the target.
//
// Note:
//
//     Given target value is a floating point.
//     You may assume k is always valid, that is: k ��?total nodes.
//     You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
// Follow up:
// Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
//
// Hint:
//
//     Consider implement these two helper functions:
//         getPredecessor(N), which returns the next smaller node to N.
//         getSuccessor(N), which returns the next larger node to N.
//     Try to assume that each node has a parent pointer, it makes the problem much easier.
//     Without parent pointer we just need to keep track of the path from the root to the current
//     node using a stack.
//     You would need two stacks to track the path in finding predecessor and successor node separately.
public class Solution{
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
      Stack<TreeNode> left = new Stack<>();
      Stack<TreeNode> right = new Stack<>();
      while(root!=null){
        if (root.val < target){
          left.push(root);
          root = root.right;
        }
        else {
          right.push(root);
          root = root.left;
        }
      }
      List<Integer> res = new ArrayList<>();
      int count = k;
      while(k > 0){
        k--;
        if (left.isEmpty() || (!right.isEmpty() && right.peek().val -target < target - left.peek().val)) {
          TreeNode cur = right.pop();
          res.add(cur.val);
          cur = cur.right;
          while(cur != null){
            right.push(cur);
            cur = cur.left;
          }
        }
        else {
          TreeNode cur = left.pop();
          res.add(cur.val);
          cur = cur.left;
          while(cur != null){
            left.push(cur);
            cur = cur.right;
          }
        }
      }
      return res;
   }
}
