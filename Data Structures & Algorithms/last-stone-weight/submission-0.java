class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> q = new PriorityQueue<>((a, b)-> b-a);
        for(int n : stones){
            q.offer(n);
        }        
        int diff = -1;
        while(q.size() > 1){            
            int first = q.poll();
            int second = q.poll();
            diff = first - second;
            if(diff > 0){
                q.offer(diff);
            }    
        }
        if(q.size() == 1){
            diff = q.poll();
        }
        return diff;
    }
}
