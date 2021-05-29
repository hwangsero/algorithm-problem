import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int to,cost;

        public Point(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int n,k;
    static int[][] table;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        while(k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            List<Point>[] list = new ArrayList[n+1];
            for(int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }
            for(int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                list[b].add(new Point(a, cost));
            }
            int[] cache = new int[n+1];
            Arrays.fill(cache, -1);
            cache[c] = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(c);
            while(!queue.isEmpty()) {
                int now = queue.poll();
                for (Point point : list[now]) {
                    if(cache[point.to] == -1 || cache[point.to] > cache[now] + point.cost) {
                        cache[point.to] = cache[now] + point.cost;
                        queue.add(point.to);
                    }
                }
            }
            int count = 0;
            int max = 0;
            for(int i = 1; i <= n; i++) {
                if(cache[i] != -1) {
                    count++;
                    max = Math.max(max, cache[i]);
                }
            }
            System.out.println(count + " " + max);
        }
    }
}