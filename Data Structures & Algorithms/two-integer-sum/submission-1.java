class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            numberMap.put(nums[i], i);
        }
        for(int i=0;i<nums.length;i++){
            if(numberMap.containsKey(target-nums[i])){
                if(i == numberMap.get(target-nums[i]))
                    continue;
                return new int[]{i, numberMap.get(target-nums[i])};
            }
        }
        return new int[]{};
    }
}
