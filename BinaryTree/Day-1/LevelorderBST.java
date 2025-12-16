//Leetcode Problem Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Deque<Deque<TreeNode>> q=new ArrayDeque<>();
        Deque<TreeNode> n=new ArrayDeque<>();
        if(root==null) return res;
        n.addLast(root);
        q.add(n);
        while(true){
            n=q.removeFirst();
            List<Integer> level_values=new ArrayList<>();
            Deque<TreeNode> newQ=new ArrayDeque<>();
            while(!n.isEmpty()){
                TreeNode node=n.removeFirst();
                level_values.add(node.val);
                if(node.left!=null)
                    newQ.addLast(node.left);
                if(node.right!=null)
                    newQ.addLast(node.right);
            }
            res.add(level_values);
            if(newQ.isEmpty())
                break;
            q.addLast(newQ);
        }
        return res;
    }
}



public void levelOrder(TreeNode t, int row, List<List<Integer>> r) {
        if (t == null) return;
        if (row == r.size())  r.add(new ArrayList<>());
        r.get(row).add(t.val);    
        levelOrder(t.left, row + 1, r);
        levelOrder(t.right, row + 1, r);
    }