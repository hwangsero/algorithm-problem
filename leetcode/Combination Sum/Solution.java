class Solution {
     int[] candidates;
    int target;
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    this.candidates = candidates;
    this.target = target;
        combination(0,target,new ArrayList<>());
        return ans;
    }

    public void combination(int index, int now, List<Integer> list) {
        if(now == 0) {
            List<Integer> temp = new ArrayList<>();
            for (int a : list) {
                temp.add(a);
            }
            ans.add(temp);
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            if(candidates[i] <= now) {
                list.add(candidates[i]);
                combination(i, now - candidates[i], list);
                list.remove(list.size() - 1);
            }
        }
    }
}