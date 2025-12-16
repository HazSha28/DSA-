//Geeksforgeeks Problem Link: https://practice.geeksforgeeks.org/problems/burning-tree/1
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
    public int minTime(Node root, int target) {
     Map<Node,Node> par = new HashMap<>();
      Queue<Node> q = new LinkedList<>();
      par.put(root,null);
      q.add(root);
      Node temp=null;
      while(!q.isEmpty()){
         
            Node curr = q.poll();
            if(curr.data==target){
               temp=curr;
            }
            if(curr.left!=null){ par.put(curr.left,curr); q.add(curr.left); }
            if(curr.right!=null){
                par.put(curr.right,curr);
                q.add(curr.right);
            }
          
      }
      q.clear();
      Set<Node> hs = new HashSet<>();
      q.add(temp);
      hs.add(temp);
      int k=0;
      while(!q.isEmpty()){
        int size = q.size();
        for(int i=0;i<size;i++){
            Node curr = q.poll();
            if(curr.left!=null && !hs.contains(curr.left)){
                q.add(curr.left);
                hs.add(curr.left);
            }
            if(curr.right!=null && !hs.contains(curr.right)){
                q.add(curr.right);
                hs.add(curr.right);
            }
            if(par.get(curr)!=null && !hs.contains(par.get(curr))){
                q.add(par.get(curr));
                hs.add(par.get(curr));
            }
        }
        if(!q.isEmpty())
           k++;
      }
     
      return k;
            
    }
}