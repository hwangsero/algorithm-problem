class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length-3; i++) {
            for(int j = i+1; j < nums.length-2; j++) {
                int left = j+1;
                int right = nums.length-1;

                while(left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target) {
                        set.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                    }
                    if(sum >= target) right--;
                    else left++;
                }
            }
        }
        for(List<Integer> l : set)
            answer.add(l);
        return answer;
    }
}