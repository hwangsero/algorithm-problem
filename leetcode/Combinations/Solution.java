import java.util.*;

class Solution {

    int n;
    int k;
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        combination(1, 0, new ArrayList<>());
        return answer;
    }

    public void combination(int index, int count, List<Integer> list) {
        if(count == k) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i <= n; i++) {
            if(list.size() + n-i+1 < k) break;
            list.add(i);
            combination(i + 1, count + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
