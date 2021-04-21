class Solution {
 int[][] cache;
    int m;
    int n;
    int[][] map;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;
        map = obstacleGrid;
        cache = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(cache[i],-1);
        return recursive(0, 0);


    }

    public int recursive(int x, int y) {
        
        if(x < 0 || x >= m || y < 0 || y >= n) return 0;
        if(map[x][y] == 1) return 0;
        if(x == m-1 && y == n-1) return 1;
        if(cache[x][y] != -1) return cache[x][y];

        int ans = 0;
        ans += recursive(x+1,y);
        ans += recursive(x, y + 1);
        return cache[x][y] = ans;
    }
}