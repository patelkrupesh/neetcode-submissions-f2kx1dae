class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int len = nums.length;
        int rotation = findRotation(nums, 0, len - 1);
        System.out.println(rotation);
        if(nums[rotation] == target){
            return rotation;
        }else if(rotation + 1 < len && nums[rotation+1] == target){
            return rotation + 1;
        }else if(nums[0] <= target && target < nums[rotation]){
            return binarySearch(nums, 0, rotation, target);
        }else if((rotation + 1 < len) && (nums[rotation + 1] < target && target <= nums[len - 1])){
            return binarySearch(nums, rotation+1, len-1, target);
        }
        return -1;
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        if(l>r) return -1;
        int p = (l + r) / 2;
        if(nums[p] == target){
            return p;
        }else if(target < nums[p] ){
            return binarySearch(nums, l, p-1, target);
        }else if(nums[p] < target){
            return binarySearch(nums, p+1, r, target);
        }
        return -1;
    }

    public int findRotation(int[] nums, int l, int r) {
        int p = (l + r) / 2;
        if (p + 1 < nums.length && nums[p] > nums[p + 1]) {
            return p;
        }
        if(l == r){return r;}
        if(nums[l] == nums[r]){return r;}
        if(p == l && nums[p] <= nums[r]){return r;}

        if (nums[l] < nums[p]) {
            return findRotation(nums, p+1, r);
        } else if (nums[p] < nums[r]) {
            return findRotation(nums, l, p-1);
        } else {
            return r;
        }
    }
}
