import java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        permutation(new boolean[nums.length], nums, new ArrayList<>());
        return ans;
    }

    public void permutation(boolean[] visited, int[] nums, List<Integer> list) {
        if(list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            list.add(nums[i]);
            permutation(visited, nums, list);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}