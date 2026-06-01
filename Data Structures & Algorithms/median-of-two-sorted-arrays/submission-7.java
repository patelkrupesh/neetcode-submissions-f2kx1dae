class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
          if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
          }        
          int len1 = nums1.length;
          int len2 = nums2.length;
          int medianpos = (len1+len2+1) / 2;
          int lo = 0 ;
          int hi = len1;
          int left1=Integer.MIN_VALUE, right1=Integer.MAX_VALUE, left2=Integer.MIN_VALUE, right2=Integer.MAX_VALUE, mid=0;
          while(lo<=hi){
            int i = (lo + hi)/2;
            int j = medianpos - i;
            System.out.println(medianpos);
            System.out.println(i);
            System.out.println(j);

            left1 = i>0 ? nums1[i-1] : Integer.MIN_VALUE;
            right1 = i<len1? nums1[i] : Integer.MAX_VALUE;
            left2 = j>0 ? nums2[j-1] : Integer.MIN_VALUE;;
            right2 = j<len2? nums2[j]: Integer.MAX_VALUE;

            if(left1 <= right2 && left2 <= right1){
              //perfect cut
              //return ans
              break;
            }else if(left1 > right2){
              //go left
              hi = i - 1; 
            }else{
               //go right
               lo = i + 1;
            }
          }
          if ((len1 + len2)% 2 == 1){
            return Math.max(left1, left2);
          }
          return ( (Math.max(left1, left2)) + (Math.min(right1, right2)) )/ 2.0;
    }
}
