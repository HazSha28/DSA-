//GeeksForgeeks Problem Link: https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int maxCol=0,minCol=0;
    public void preorder(Node root,int row,int col,HashMap<Integer,int[]> mp){
        if(root!=null){
            if(!mp.containsKey(col)||row>=mp.get(col)[1])
                mp.put(col,new int[]{root.data,row});
            if(col>maxCol)
                maxCol=col;
            if(col<minCol)
                minCol=col;
            preorder(root.left,row+1,col-1,mp);
            preorder(root.right,row+1,col+1,mp);
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        HashMap<Integer,int[]> mp=new HashMap<>();
        preorder(root,0,0,mp);
        ArrayList<Integer> res= new ArrayList<>();
        for(int i=minCol;i<=maxCol;i++){
            res.add(mp.get(i)[0]);
        }
        return res;
    }
}