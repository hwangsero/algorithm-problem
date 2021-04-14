class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < nums.length-2; i++) {

            int left = i+1;
            int right = nums.length-1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int val = Math.abs(sum - target);
                if(min > val) {
                    ans = sum;
                    min = val;

                }
                if(sum >= target) right--;
                if(sum < target) left++;
            }
        }
        return ans;
    }
}