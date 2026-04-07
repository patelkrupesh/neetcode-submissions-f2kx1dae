class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        System.out.println();
        int max_size = 0;        
        for(int i=0;i<nums.length;i++){
            int curr_size = 1;
            while(i+1<nums.length && nums[i] + 1 == nums[i+1]){
                curr_size++;
                i++;
                while(i+1<nums.length && nums[i] == nums[i+1]) {
                    i++;
                }
            }
            if(curr_size > max_size){
                max_size = curr_size;
            }                       
        }
        return max_size;
    }
}
