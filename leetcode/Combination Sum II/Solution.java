class Solution {
  int[] candidates;
    int target;
    List<List<Integer>> ans = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
    this.candidates = candidates;
    this.target = target;
        combination(0,target,new ArrayList<>());
        for (List<Integer> list : set) {
            ans.add(list);
        }
        
        return ans;
    }

    public void combination(int index, int now, List<Integer> list) {
        if(now == 0) {
            set.add(new ArrayList<Integer>(list));
            return;
        }
        if(now < 0) return;
        
        for(int i = index; i < candidates.length; i++) {
                list.add(candidates[i]);
                combination(i+1, now - candidates[i], list);
                list.remove(list.size() - 1);
        }
    }
}