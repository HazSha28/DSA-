//GeeksForGeeks Problem Link : https://practice.geeksforgeeks.org/problems/connect-n-ropes-with-minimum-cost-1587115620/1

class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> p=new PriorityQueue<>();
        for(int i:arr){
            p.add(i);
        }
        int c=0;
        while(p.size()>1){
            int a=p.poll();
            int b=p.poll();
            int sum=a+b;
            c+=sum;
            p.add(sum);
        }
        return c;
    }
}