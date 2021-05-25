import java.io.*;
import java.util.*;

public class Main {

    static int n,k;
    static int[][] table;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        table = new int[map.size()][2];
        int index = 0;
        for (int key : map.keySet()) {
            table[index][0] = key;
            table[index][1] = map.get(key);
            index++;
        }
        go(new ArrayList<>());
    }

    public static void go(List<Integer> list) {
        if(list.size() == k) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < table.length; i++) {
            int key = table[i][0];
            int val = table[i][1];
            if(val == 0) continue;
            table[i][1] = val - 1;
            list.add(key);
            go(list);
            list.remove(list.size()-1);
            table[i][1] = val;
        }
    }
}