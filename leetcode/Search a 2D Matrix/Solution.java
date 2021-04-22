class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row * col - 1;

        while(left <= right) {
            int mid = right - (right - left) / 2;
            int r = mid/col;
            int c = mid%col;
            int number = matrix[r][c];
            if(number == target) return true;
            if(number < target) left = mid+1;
            if(number > target) right = mid-1;
        }
        return false;
    }
}