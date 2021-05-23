import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    static class Point {
        int a,b,c,d,e;

        public Point(int a, int b, int c, int d, int e) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
    }

    static int n;
    static int[] must;
    static Point[] points;
    static List<Integer> answer = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        must = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            must[i] = Integer.parseInt(st.nextToken());
        }
        points = new Point[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        go(0, new Point(0, 0, 0, 0, 0), new ArrayList<>());
        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
            System.exit(0);
        }
        System.out.println(min);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    public static void go(int index, Point now, List<Integer> list) {
        if(now.a >= must[0] && now.b >= must[1] && now.c >= must[2] && now.d >= must[3]) {
            if(now.e < min) {
                min = now.e;
                answer = new ArrayList<>(list);
            }
            return;
        }

        if(index == n) return;
        list.add(index+1);
        Point next = new Point(now.a + points[index].a, now.b + points[index].b, now.c + points[index].c, now.d + points[index].d, now.e + points[index].e);
        go(index+1,next,list);
        list.remove(list.size() - 1);
        go(index + 1, now, list);

    }

}