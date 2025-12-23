//Leetcode Problem Link: https://leetcode.com/problems/hand-of-straights/description/

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int h : hand)
            freq.put(h, freq.getOrDefault(h, 0) + 1);

        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int x : freq.keySet())
            p.add(x);

        while (!p.isEmpty()) {
            int f = p.peek();

            if (freq.get(f) == 0) {
                p.poll();
            } else {
               
                freq.put(f, freq.get(f) - 1);

                for (int i = 1; i < groupSize; i++) {
                    f++;
                    if (!freq.containsKey(f) || freq.get(f) == 0)
                        return false;

                    freq.put(f, freq.get(f) - 1);
                }
            }
        }
        return true;
    }
}
