import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    static int row, col;
    static int[][] map;
    static boolean isEnd = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        String[] names = new String[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> list = new ArrayList<>();
        int index = 0;
        while(st.hasMoreTokens()) {
            String s = st.nextToken();
            list.add(s);
        }
        list.sort(null);
        for (String s : list) {
            map.put(s, index);
            names[index] = s;
            index++;
        }
        int k = Integer.parseInt(br.readLine());

        int[] entry = new int[n];
        List<Integer>[] child = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            child[i] = new ArrayList<>();
        }
        while(k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int c = map.get(st.nextToken());
            int p = map.get(st.nextToken());
            entry[c]++;
            child[p].add(c);
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        List<String> temp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(entry[i] == 0) {
                count++;
                temp.add(names[i]);
                queue.add(i);
            }
        }
        sb.append(count + "\n");
        for (String s : temp) {
            sb.append(s + " ");
        }
        sb.append("\n");

        List<String>[] answer = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            answer[i] = new ArrayList<>();
        }
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : child[now]) {
                entry[next]--;
                if(entry[next] == 0) {
                    answer[now].add(names[next]);
                    queue.add(next);
                }
            }
        }
        for(int i = 0; i < n; i++) {
            Collections.sort(answer[i]);
            sb.append(names[i] + " " + answer[i].size() + " ");
            for (String s1 : answer[i]) {
                sb.append(s1 + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    public static List<String> getChild(Map<String,Integer> map, String[] names, List<Integer>[] child, int now, List<String> list) {

        for (int next : child[now]) {
            list.add(names[next]);
            getChild(map, names, child, next, list);
        }
        return list;
    }
}