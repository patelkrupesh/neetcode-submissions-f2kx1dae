class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if(nums.length < k || k == 0){
            return new int[]{};
        }
        //heapify
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(int i = 0 ; i < k ; i++){
            pq.add(nums[i]);
        }
        result.add(pq.peek());

        //slide the window

        int l = 0;
        int r = k-1;
        while(r < nums.length-1){
            pq.remove(nums[l]);
            l++;
            r++;
            pq.add(nums[r]);            
            result.add(pq.peek());            
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
