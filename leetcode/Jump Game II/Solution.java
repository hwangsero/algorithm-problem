class Solution {
   int[][] cache;
    int n;
    int[] nums;
    public int jump(int[] nums) {
        n = nums.length;
        cache = new int[n][1001];
        this.nums = nums;
        for(int i = 0; i < n; i++)
            Arrays.fill(cache[i],-1);
        return jump(0, 0);
    }

    public int jump(int now, int count) {
        if(now == n-1) return count;
        if(now >= n) return 1000;

        if(cache[now][count] != -1) return cache[now][count];
        int ans = 1000;
        int jumpSize = nums[now];
        for(int i = 1; i <= jumpSize; i++) {
            ans = Math.min(jump(now+i,count+1),ans);
        }
        return cache[now][count] = ans;
    }
}