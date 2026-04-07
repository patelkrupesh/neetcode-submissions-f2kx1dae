class Solution {
    public int[] productExceptSelf(int[] nums) {
        double n = 1;
        int countZero = 0;
        for(int num : nums){
            n*=num;
            if(num == 0 ) countZero++;
        }
        System.out.println(n);
        int [] answer = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                answer[i] = (int)(n/nums[i]);
            }else if(countZero > 1){
                answer[i] = 0;
            }else{
                double cal = 1;
                for(int j=0;j<nums.length;j++){
                    if( j == i ) continue;
                    cal *= nums[j];
                }
                answer[i] = (int)cal;
            }
        }
        return answer;
    }
}  
