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
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inmp=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            inmp.put(inorder[i],i);
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inmp);
        }
    public TreeNode build(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend,HashMap <Integer,Integer> inmp){
        if(prestart>preend||instart>inend) return null;
        int val=preorder[prestart];
        TreeNode root=new TreeNode(val);
        int x=inmp.get(val);
        int numsLeft=x-instart;
        root.left=build(preorder,prestart+1,prestart+numsLeft,inorder,instart,x-1,inmp);
        root.right=build(preorder,prestart+numsLeft+1,preend,inorder,x+1,inend,inmp);
        return root;
    }
}