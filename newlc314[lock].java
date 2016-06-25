// Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
//
// If two nodes are in the same row and column, the order should be from left to right.
//
// Examples:
// Given binary tree [3,9,20,null,null,15,7],
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
//
//
// return its vertical order traversal as:
//
// [
//   [9],
//   [3,15],
//   [20],
//   [7]
// ]
//
//
//
// Given binary tree [3,9,20,4,5,2,7],
//
//     _3_
//    /   \
//   9    20
//  / \   / \
// 4   5 2   7
//
//
//
// return its vertical order traversal as:
//
// [
//   [4],
//   [9],
//   [3,5,2],
//   [20],
//   [7]
// ]
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
     class MyNode{
       TreeNode node;
       int x;
       public MyNode(TreeNode node, int x){
         this.node = node;
         this.x = x;
       }
     }
     Map<Integer, List<Integer>> map;
     public List<List<Integer>> verticalOrder(TreeNode root) {
       List<List<Integer>> res = new ArrayList<>();
       if (root == null) return res;
       map = new HashMap<>();
       Queue<MyNode> queue = new LinkedList<>();
       queue.add(new MyNode(root, 0));
       while(!queue.isEmpty()){
         int size = queue.size();
         for (int i = 0; i < size; i++){
           MyNode cur = queue.remove();
           if (map.get(cur.x) == null) map.put(cur.x, new ArrayList<Integer>());
           map.get(cur.x).add(cur.node.val);
           if (cur.node.left != null) {
              queue.add(new MyNode(cur.node.left, cur.x - 1));
           }
           if (cur.node.right != null) {
              queue.add(new MyNode(cur.node.right, cur.x + 1));
           }
         }
       }
       List<Integer> keySet = new ArrayList<Integer>(map.keySet());
       Collections.sort(keySet);
       for (int i : keySet){
         res.add(map.get(i));
       }
       return res;
     }
 }
