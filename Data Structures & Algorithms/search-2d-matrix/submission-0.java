class Solution {
    private boolean findNumber(int[][] matrix, int target, int l, int r, int x, int y) {
        int mid = (l + r) / 2;
        int midNum = matrix[mid/y][mid % y];
        if(target == midNum) return true;
        if(l >= r) return false;

        if(target < midNum)
            return findNumber(matrix, target, l, mid-1, x, y);
        else
            return findNumber(matrix, target, mid+1, r, x, y);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int x = matrix.length;
        if(x == 0) return false;

        int y = matrix[0].length;
        int len = x*y;
        return findNumber(matrix, target, l, len-1, x, y);
    }
}
