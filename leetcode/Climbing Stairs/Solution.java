class Solution {
    int[] cache;
    public int climbStairs(int n) {
    cache = new int[n];
            Arrays.fill(cache,-1);

        return go(0, n);
    }

    public int go(int index,  int now) {
        if(now == 0) return 1;
        if(now < 0) return 0;
        if(cache[index] != -1) return cache[index];

        cache[index] = go(index + 1, now - 1) + go(index + 2, now - 2);
        return cache[index];


    }

}