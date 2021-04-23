class Solution {
    int[] nums;
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        combination(0,new ArrayList<>());
        return ans;
    }

    public void combination(int index, List<Integer> list) {
        if(index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        combination(index+1,list);
        list.remove(list.size() - 1);
        combination(index+1,list);
    }
}