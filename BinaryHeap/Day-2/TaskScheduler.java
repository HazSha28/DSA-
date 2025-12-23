//leetcode Problem Link: https://leetcode.com/problems/task-scheduler/description/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (char t : tasks) 
            mp.put(t, mp.getOrDefault(t, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(mp.values());

        int time = 0;
        while (!pq.isEmpty()) {
            ArrayList<Integer> arr = new ArrayList<>();
            int cycle = n + 1;
            while (cycle > 0 && !pq.isEmpty()) {
                int curr = pq.poll();
                if (curr - 1 > 0) arr.add(curr - 1);
                cycle--;
                time++;
            }

            for (int x : arr) 
                pq.add(x);

            if (pq.isEmpty()) 
                break; 
            time += cycle; 
        }

        return time;
    }
}


   
