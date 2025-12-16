//Leetcode Problem Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
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
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public void preorder(TreeNode root,List<Integer> ans){
        if(root!=null){
            ans.add(root.val);
            preorder(root.left,ans);
            preorder(root.right,ans);
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
     List<Integer> ans =new ArrayList<>();
        preorder(root,ans);
        return ans;
}
}