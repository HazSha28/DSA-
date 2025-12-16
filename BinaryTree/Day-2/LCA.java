//Leetcode Problem Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(root==null||root ==p||root==q) return root;
        //recursive case
        TreeNode LCA1=lowestCommonAncestor(root.left,p,q);
        TreeNode LCA2=lowestCommonAncestor(root.right,p,q);
        if(LCA1==null) return LCA2;
        if(LCA2==null) return LCA1;
        return root;
    }
}