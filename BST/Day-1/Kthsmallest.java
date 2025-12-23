class Solution {
    public int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();

        for (int x : nums)
            p.add(x);

        for (int i = 1; i < k; i++)
            p.poll();

        return p.peek();
    }
}