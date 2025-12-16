//Leetcode Problem Link: https://leetcode.com/problems/maximum-width-of-binary-tree/
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
    public int widthOfBinaryTree(TreeNode root) {

        Deque<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        int x = 1, y = 0;
        int max = 0;

        while (!q.isEmpty()) {

            int first = q.peekFirst().getValue();
            int last = q.peekLast().getValue();
            int width = last - first + 1;
            if (width > max)
                max = width;

            while (x > 0) {
                Pair<TreeNode, Integer> a = q.pollFirst();
                TreeNode b = a.getKey();
                int c = a.getValue();
                x--;

                if (b.left != null) {
                    int idx = c * 2 + 1;
                    q.addLast(new Pair<>(b.left, idx));
                    y++;
                }

                if (b.right != null) {
                    int idx = c * 2 + 2;
                    q.addLast(new Pair<>(b.right, idx));
                    y++;
                }
            }

            x = y;
            y = 0;
        }

        return max;
    }
}
