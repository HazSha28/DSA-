//GeeksForgeeks Problem Link:https://www.geeksforgeeks.org/problems/nearly-sorted-1587115620/1
class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> p=new PriorityQueue<>();
        for(int i=0;i<=k;i++){
            p.add(arr[i]);
        }
        int j=0;
        for(int i=k+1;i<arr.length;i++){
            arr[j++]=p.poll();
            p.add(arr[i]);
        }
        while(!p.isEmpty()){
            arr[j++]=p.poll();
        }
    }
}
