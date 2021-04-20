class Solution {

     int[] cache;
     int n;
     int[] nums;
     public boolean canJump(int[] nums) {
        n = nums.length;
        cache = new int[n];
         Arrays.fill(cache, -1);
        this.nums = nums;
         return jump(0) > 0 ? true : false;
    }

    public int jump(int index) {
         if(index == n-1) return 1;
         if(index >= n) return 0;
         if(cache[index] != -1) return cache[index];
         int ans = 0;
        int size = nums[index];
        for(int i = 1; i <= size; i++) {
            ans += jump(index + i);
        }
        return cache[index] = ans;
    }
}
