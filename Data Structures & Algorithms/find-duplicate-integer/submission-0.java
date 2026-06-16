class Solution {
    public int findDuplicate(int[] nums) {
        Map<Number, Boolean> maps = new HashMap<>();
        for(int n : nums){
            if(maps.containsKey(n)){
                return n;
            }else{
                maps.put(n, true);
            }
        }
        return -1;
    }
}
