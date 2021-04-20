class Solution {
int[][] cache;
    int m;
    int n;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        cache = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(cache[i],-1);
        return recursive(0, 0);
        
        
    }
    
    public int recursive(int x, int y) {
        if(x == m-1 && y == n-1) return 1;
        if(x < 0 || x >= m || y < 0 || y >= n) return 0;
        if(cache[x][y] != -1) return cache[x][y];
        
        int ans = 0;
        ans += recursive(x+1,y);
        ans += recursive(x, y + 1);
        return cache[x][y] = ans;
    }
}