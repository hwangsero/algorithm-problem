class Solution {

    List<List<Integer>> triangle;
    int[][] cache;
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1) return triangle.get(0).get(0);
        this.triangle = triangle;
        cache = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int i = 0; i < triangle.size(); i++)
            Arrays.fill(cache[i], -1);

        return go(0, 0);
    }

    public int go(int row, int col) {
        if(row == triangle.size()) return 0;
        if(col == triangle.get(row).size()) return Integer.MAX_VALUE;
        if(cache[row][col] != -1) return cache[row][col];
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, go(row + 1, col) + triangle.get(row).get(col));
        ans = Math.min(ans, go(row + 1, col + 1) + triangle.get(row).get(col));
        return cache[row][col] = ans;

    }
}