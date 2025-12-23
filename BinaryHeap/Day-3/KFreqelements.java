//Leetcode Problem Link: https://leetcode.com/problems/top-k-frequent-elements/description/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq=new HashMap<>();
          for(int i:nums)
            freq.put(i,freq.getOrDefault(i,0)+1);
        
        PriorityQueue<int[]> p=new PriorityQueue<>((a,b)->a[1]-b[1]);

        for(Map.Entry<Integer,Integer> f:freq.entrySet()){
            p.add(new int[]{f.getKey(),f.getValue()});
            if(p.size()>k) 
                p.poll();
        }
        int ans[]= new int[k];
        int i=0;
        while(!p.isEmpty()) 
        ans[i++]=p.poll()[0];
        return ans;
    }
}
   