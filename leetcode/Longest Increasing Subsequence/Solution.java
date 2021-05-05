class Solution {

     static int[] cache;
    static int[] nums;
    static int n;
     public static int lengthOfLIS(int[] nums) {
        n = nums.length;
        Solution.nums = nums;
         Solution.cache = new int[n];
         Arrays.fill(cache, -1);
        int max =0 ;

        for(int i = 0; i < n; i++) {
            max = Math.max(max,go(i));
        }
         return max;
     }

    public static int go(int index) {
        if(index == n-1) return 1;
        if(cache[index] != -1) return cache[index];

        int ans = 1;
        if (nums[index] < nums[index+1])
            ans = Math.max(ans, go(index+1) + 1);

        return cache[index] = ans;
    }
}