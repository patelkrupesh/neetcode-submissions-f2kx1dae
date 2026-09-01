class KthLargest {
    int k;
    Queue<Integer> list = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        Arrays.sort(nums);
        if(k > nums.length){
            for(int i = 0; i < nums.length; i++){
                list.offer(nums[i]);                                              
            }
        }else{
            for(int i = nums.length-k; i < nums.length; i++){
                list.offer(nums[i]);           
            }
        }
    }
    
    public int add(int val) {
        if(list.size()<k){
            list.offer(val);           
            return list.peek();
        }
        if(val > list.peek()){            
            list.poll();
            list.offer(val);
        }
        return list.peek();
    }
}
