class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
          int len1 = nums1.length, len2 = nums2.length;
          int total = len1 + len2;
          if (total == 0) return 0.0;
          
          int k1 = (total + 1) / 2;
          int k2 = (total + 2) / 2;
          
          return (findKth(nums1, 0, nums2, 0, k1) + findKth(nums1, 0, nums2, 0, k2)) / 2.0;
      }
      
      private int findKth(int[] a, int i, int[] b, int j, int k) {
          if (i >= a.length) return b[j + k - 1];
          if (j >= b.length) return a[i + k - 1];
          if (k == 1) return Math.min(a[i], b[j]);
          
          int midA = (i + k/2 - 1 < a.length) ? a[i + k/2 - 1] : Integer.MAX_VALUE;
          int midB = (j + k/2 - 1 < b.length) ? b[j + k/2 - 1] : Integer.MAX_VALUE;
          
          if (midA < midB) {
              return findKth(a, i + k/2, b, j, k - k/2);
          } else {
              return findKth(a, i, b, j + k/2, k - k/2);
          }
      }
}
