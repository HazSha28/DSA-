//GeeksForGeeks Problem Link : https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1

public class KthSmallestElement {
class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        PriorityQueue<Integer> p=new PriorityQueue<>();
        for(int i:arr){
             p.add(i);
            if(p.size() > k)
                p.poll();
        }
            return p.peek();
 }
}
}
