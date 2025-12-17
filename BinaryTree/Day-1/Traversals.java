//Problem Link: https://www.codingninjas.com/codestudio/problems/tree-traversals_893069
/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.*;
public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        inorder(root, in);
        preorder(root, pre);
        postorder(root, post);

        ans.add(in);
        ans.add(pre);
        ans.add(post);

        return ans;
    }
    public static void inorder(TreeNode root,List<Integer> ans){
        if(root!=null){
            inorder(root.left,ans);
            ans.add(root.data);
            inorder(root.right,ans);
        }
    }
    public static void preorder(TreeNode root,List<Integer> ans){
        if(root!=null){
            
            ans.add(root.data);
            preorder(root.left,ans);
            preorder(root.right,ans);
        }
    }
    public static void postorder(TreeNode root,List<Integer> ans){
        if(root!=null){
            postorder(root.left,ans);
            postorder(root.right,ans);
            ans.add(root.data);
        }
}
}