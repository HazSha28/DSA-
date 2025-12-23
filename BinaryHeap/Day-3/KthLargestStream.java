//Leetcode Problem Link: https://leetcode.com/problems/kth-largest-element-in-a-stream/description/

class KthLargest {
    int k;
    PriorityQueue<Integer> p=new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
       this.k=k;
       for(int val:nums){
        p.add(val);
        if(p.size()>k)
            p.poll();
       }
    }
    
    public int add(int val) {
        p.add(val);
        if(p.size()>k)
            p.poll();
        return p.peek();
}
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */