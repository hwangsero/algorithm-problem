import java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> countTable = new HashMap<>();
        for (int num : nums) {
            countTable.put(num, countTable.getOrDefault(num, 0) + 1);
        }

        permutation(countTable, new ArrayList<>(), nums.length);
        return ans;
    }

    public void permutation(Map<Integer, Integer> countTable, List<Integer> list, int len) {
        if(list.size() == len) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int key : countTable.keySet()) {
            int val = countTable.get(key);
            if(val == 0) continue;
            countTable.put(key, val - 1);
            list.add(key);
            permutation(countTable,list, len);
            countTable.put(key, val);
            list.remove(list.size() - 1);

        }

    }
}