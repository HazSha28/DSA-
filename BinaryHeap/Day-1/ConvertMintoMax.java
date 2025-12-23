// User function Template for Java
//Geeksforgeeks Problem Link: https://practice.geeksforgeeks.org/problems/convert-min-heap-to-max-heap/1
class Solution {
    static void convertMinToMaxHeap(int n, int arr[]) {
        // code here
        for(int i=(n-1)/2;i>=0;i--){
            sort(arr,n,i);
        }
    }
    
    static void sort(int[] arr,int n,int i){
       int max=i,l=2*i+1,r=2*i+2;
       
       if(l<n && arr[l]>arr[max]) max=l;
       if(r<n && arr[r]>arr[max]) max=r;
       
       if(max!=i){
           int t=arr[i];
           arr[i]=arr[max];
           arr[max]=t;
           sort(arr,n,max);
       }
    }
}
