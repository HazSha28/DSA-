/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));        
    }
}

//Leetcode Problem Link: https://leetcode.com/problems/balanced-binary-tree/
//Balanced tree or not
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
           return height(root)!=-1;
    }
    public int height(TreeNode root){
        if(root==null)
            return 0;
        //checking if any imbalance in left subtree
        int left_height=height(root.left);
        if(left_height==-1)
            return -1;
        //checking if any imbalance in right subtree
        int right_height=height(root.right);
        if(right_height==-1)
            return -1;
        //checking if root is balance or not
        if(Math.abs(left_height-right_height)>1)
            return -1;
        //checking height of root node
        return Math.max(left_height,right_height)+1;
    }
}
