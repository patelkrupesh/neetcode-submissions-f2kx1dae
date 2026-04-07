class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length -1;
        int res = 0;
        int mid;
        while (l<=r){
            if(r-l <1){
                // System.out.println("found : l : "+ l + ", r :" + r);
                res = r;
                break;
            }   
            if(r-l ==1){
                // System.out.println("equal : l : "+ l + ", r :" + r);
                if(nums[l]<nums[r])
                    res = l;    
                else
                    res = r;
                break;
            }          
            mid = (int)((l+r)/2);            
            if(nums[l] > nums[mid]){
                // System.out.println("l : "+ l + ", mid :" + mid);
                r = mid;
            }else if(nums[mid] > nums[r]){
                // System.out.println("mid :" + mid + "r : "+ r);
                l = mid + 1;
            }else{
                res = l;
                break;
            }
        }
        return nums[res];
    }
}
