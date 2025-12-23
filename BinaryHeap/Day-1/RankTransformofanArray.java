package BinaryHeap;



public class RankTransformofanArray {
    class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<int[]> p=new PriorityQueue<>((a,b)-> a[0]-b[0]);
        for(int i=0;i<arr.length;i++)
            p.add(new int[]{arr[i],i});
        int lastValue=Integer.MAX_VALUE;
        int rank=0;
        while(!p.isEmpty()){
            int top[]=p.poll();
            int currValue=top[0];
            int ind=top[1];
            if(lastValue==Integer.MAX_VALUE||lastValue!=currValue)
                rank++;
            arr[ind]=rank;
            lastValue=currValue;
        }
        return arr;
    }
}
}
