import java.io.*;
import java.lang.reflect.InaccessibleObjectException;
import java.net.InterfaceAddress;
import java.util.*;
import java.util.List;

public class Main {

    static class Point {
        int min,max;

        public Point(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }


    static int n;
    static int[] root;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        Point[] points = new Point[n];
        int left = 0;
        int right = 0;
        int s = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            points[i] = new Point(a, b);
            left = Math.max(left, a);
            right = Math.max(right, b);
            s += a;
        }

        if(s > t) {
            System.out.println(-1);
            System.exit(0);
        }
        int ans = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for(int i = 0; i < n; i++) {
                Point point = points[i];
                sum += Math.min(point.max, mid);
            }
            if(sum >= t) {
                ans = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        System.out.println(ans);

    }

}