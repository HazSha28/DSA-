//Geeksforgeeks Problem Link: https://practice.geeksforgeeks.org/problems/check-if-array-represents-a-binary-heap/1
class Solution {

    public boolean countSub(long arr[], long n) {
        // Your code goes here
        for(int i=0;i<=(n-1)/2;i++){
            int l=2*i+1,r=2*i+2;
            if(l<n && arr[i]<arr[l] || r<n && arr[i]<arr[r])
                return false;
        }
        return true;
    }
}