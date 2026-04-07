class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i+2<nums.length;i++){
            int num = nums[i];
            int min = i + 1;
            int max = nums.length - 1;
            while(min<max){
                if(num+nums[min]+nums[max] == 0){
                    result.add(List.of(num, nums[min], nums[max]));
                    do{
                        min++;
                    }while(min < max && nums[min-1] == nums[min]);
                    do{
                        max--;
                    }while(max > min && nums[max+1] == nums[max]);
                }else if(num+nums[min]+nums[max] > 0){
                    max--;
                    while(max > min && nums[max] == nums[max+1]) max--;
                }else{
                    min++;
                    while(min < max && nums[min] == nums[min-1]) min++;
                }
            }
            while(i+1 < nums.length && nums[i] == nums[i+1]) i++;
        }
        return result;
    }
}