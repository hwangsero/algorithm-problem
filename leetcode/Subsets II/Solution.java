import java.util.*;

class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<int[]> countTable = new ArrayList<>();
        for (int key : map.keySet()) {
            countTable.add(new int[]{key, map.get(key)});
        }
        go(0, countTable, new ArrayList<>());
        return answer;
    }

    public void go(int index, List<int[]> countTable, List<Integer> list) {
        answer.add(new ArrayList<>(list));

        for(int i = index; i < countTable.size(); i++) {
            int number = countTable.get(i)[0];
            int count = countTable.get(i)[1];
            if(count == 0) continue;
            countTable.get(i)[1] = count - 1;
            list.add(number);
            go(i,countTable, list);
            countTable.get(i)[1] = count;
            list.remove(list.size() - 1);
        }
    }
}