//Leetcode Problem Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
    public TreeNode buildTree(int[] inorder,int[] postorder) {
        HashMap<Integer,Integer> inmp=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            inmp.put(inorder[i],i);
        return build(postorder,0,postorder.length-1,inorder,0,inorder.length-1,inmp);
        }
public TreeNode build(int[] postorder,int poststart,int postend,int[] inorder,int instart,int inend,HashMap <Integer,Integer> inmp){
        if(poststart>postend||instart>inend) return null;
        int val=postorder[postend];
        TreeNode root=new TreeNode(val);
        int x=inmp.get(val);
        int numsLeft=x-instart;
        root.left=build(postorder,poststart,poststart+numsLeft-1,inorder,instart,x-1,inmp);
        root.right=build(postorder,poststart+numsLeft,postend-1,inorder,x+1,inend,inmp);
        return root;
    }
}