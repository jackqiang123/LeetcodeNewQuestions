// Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//
// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
//
// For example, you may serialize the following tree
//
//     1
//    / \
//   2   3
//      / \
//     4   5
//
// as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
//
// Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /**
  * Definition for a binary tree node.
  * public class TreeNode {
  *     int val;
  *     TreeNode left;
  *     TreeNode right;
  *     TreeNode(int x) { val = x; }
  * }
  */
public class Codec {

     // Encodes a tree to a single string.
     public String serialize(TreeNode root) {
       StringBuilder res = new StringBuilder();
       if (root == null) return res.toString();
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       res.append(root.val).append('^');
       while(!queue.isEmpty()){
         root = queue.remove();
         if (root.left != null) {queue.add(root.left); res.append(root.left.val).append('^');}
         else res.append("#^");
         if (root.right != null) {queue.add(root.right); res.append(root.right.val).append('^');}
         else res.append("#^");
       }
       res.setLength(res.length()-1);
       return res.toString();
     }

     // Decodes your encoded data to tree.
     public TreeNode deserialize(String datas) {
       if (datas.length() == 0) return null;
       String[]data = datas.split("\\^");
       Queue<TreeNode> queue = new LinkedList<>();
       TreeNode res = new TreeNode(Integer.parseInt(data[0]));
       queue.add(res);
       int index = 1;
       while(!queue.isEmpty()){
         TreeNode cur = queue.remove();
         if (data[index].equals("#")) index++;
         else {
           cur.left = new TreeNode(Integer.parseInt(data[index++]));
           queue.add(cur.left);
         }
         if (data[index].equals("#")) index++;
         else {
           cur.right = new TreeNode(Integer.parseInt(data[index++]));
           queue.add(cur.right);
         }
       }
       return res;
     }
 }

 // Your Codec object will be instantiated and called as such:
 // Codec codec = new Codec();
 // codec.deserialize(codec.serialize(root));
