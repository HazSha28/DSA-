//GeeksForGeeks Problem Link: https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
/*
Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root, path, res);
        return res;
    }

    public static void dfs(Node root, ArrayList<Integer> path,
             ArrayList<ArrayList<Integer>> res) {

        if (root == null) return;

        path.add(root.data);

        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        } else {
            dfs(root.left, path, res);   // left first
            dfs(root.right, path, res);  // then right
        }

        path.remove(path.size() - 1); // backtrack
    }
}
