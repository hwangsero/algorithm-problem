import java.io.*;
import java.util.*;

public class Main {

    static class Point implements Comparable<Point>{
        int from,to,cost;

        public Point(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point that) {
            return this.cost - that.cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        while(k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            PriorityQueue<Point> pq = new PriorityQueue<>();
            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < col - 1; j++) {
                    int number = i * col + j;
                    int value = Integer.parseInt(st.nextToken());
                    pq.add(new Point(number, number + 1, value));
                }
            }

            for (int i = 0; i < row - 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < col; j++) {
                    int number = i * col + j;
                    int value = Integer.parseInt(st.nextToken());
                    pq.add(new Point(number, number + col, value));
                }
            }

            int n = row * col;
            root = new int[n];
            for(int i = 0; i < n; i++) {
                root[i] = i;
            }

            int sum = 0;
            while(!pq.isEmpty()) {
                Point now = pq.poll();
                if(find(now.to) == find(now.from)) continue;
                union(now.to, now.from);
                sum += now.cost;
            }
            System.out.println(sum);
        }
    }

    static int[] root;
    public static int find(int a) {
        if(root[a] == a) return a;
        return root[a] = find(root[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) return;
        root[a] = b;
    }
}