//Leetcode PRoblem Link: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
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
    public void preorder(TreeNode root,int row,int col,ArrayList<int[]> ans){
        if(root!=null){
            ans.add(new int[]{col,row,root.val});
            preorder(root.left,row+1,col-1,ans);
            preorder(root.right,row+1,col+1,ans);
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ArrayList<int[]> ans= new ArrayList<>();
        preorder(root,0,0,ans);
        ans.sort((a,b)->{
            if(a[0]!=b[0])//if orea col goes to row and then sorts row
                return Integer.compare(a[0],b[0]);//col
            if(a[1]!=b[1])
                return Integer.compare(a[1],b[1]);//row
            return Integer.compare(a[2],b[2]);//datas
        });

        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        int prevcol=Integer.MIN_VALUE;
        List<Integer> level=new ArrayList<>();
         for(int[] r:ans){
                if(r[0]!=prevcol){
                    if(prevcol!=Integer.MIN_VALUE)
                        res.add(level);
                    level=new ArrayList<>();
                    prevcol=r[0];
                }
                level.add(r[2]);
         }
         res.add(level);
         return res;
    }
}