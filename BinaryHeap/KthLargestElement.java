package BinaryHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(k<=nums.length){
            PriorityQueue<Integer> p=new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0;i<nums.length;i++){
                p.add(nums[i]);
            }
            for(int i=1;i<=k-1;i++)
                p.poll();
            return p.peek();
        }
        else{
            PriorityQueue<Integer> p=new PriorityQueue<>();
            for(int i=0;i<nums.length;i++){
                p.add(nums[i]);
            }
            for(int i=1;i<=k-1;i++)
                p.poll();
            return p.peek();
        }
      
    }
}

// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> p=new PriorityQueue<>(Collections.reverseOrder());
//         for(int i=0;i<nums.length;i++){
//             p.add(nums[i]);
//         }
//         for(int i=1;i<=k-1;i++)
//             p.poll();
//         return p.peek();
//     }
// }
}
