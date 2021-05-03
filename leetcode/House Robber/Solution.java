class Solution {
    static int[] nums;
    static int[] cache;
    public static int rob(int[] nums) {
        Solution.nums = nums;
        cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return recursive(0);
    }

    public static int recursive(int index) {
        if(index >= nums.length) return 0;
        if(cache[index] != -1) return cache[index];

        int ans = 0;
        ans = Math.max(ans, recursive(index + 1));
        ans = Math.max(ans, recursive(index + 2) + nums[index]);
        return cache[index] = ans;
    }
}