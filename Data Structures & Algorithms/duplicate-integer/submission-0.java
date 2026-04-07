class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numberSet = new HashSet<>();
        for(int num : nums){
            if(numberSet.contains(num))
                return true;
            else
                numberSet.add(num);
        }
        return false;
    }
}