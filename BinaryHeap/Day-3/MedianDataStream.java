//LeetCode Problem Link: https://leetcode.com/problems/find-median-from-data-stream/description/

class MedianFinder {
    PriorityQueue<Integer> min=new PriorityQueue<>();
    PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
    public MedianFinder() {   
    }
    
    public void addNum(int num) {
       max.add(num);
       min.add(max.poll());
       if(min.size()>max.size())
        max.add(min.poll());
    }
    
    public double findMedian() {
        if(max.size()>min.size()) return max.peek();
        return(min.peek()+max.peek())/2.0d;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */