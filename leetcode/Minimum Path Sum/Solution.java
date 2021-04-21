class Solution {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] d = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(i == 0 && j == 0) d[i][j] = grid[0][0];
                else d[i][j] = Math.min(getDist(d,i - 1, j), getDist(d,i, j - 1)) + grid[i][j];
            }
        }
        return d[row - 1][col - 1];
    }
    
    public int getDist(int[][] d, int r, int c) {
        if(r < 0 || c < 0) return Integer.MAX_VALUE;
        return d[r][c];
    }
}