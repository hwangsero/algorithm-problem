import java.io.*;
import java.lang.reflect.InaccessibleObjectException;
import java.net.InterfaceAddress;
import java.util.*;
import java.util.List;

public class Main {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int a,b,end;
    static int[] cache;
    static final int MAX = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        cache = new int[MAX+1];
        Arrays.fill(cache, MAX);

        cache[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(now+1 <= MAX && cache[now+1] > cache[now] + 1) {
                cache[now+1] = cache[now] + 1;
                queue.add(now + 1);
            }
            if(now-1 >= 0 && cache[now-1] > cache[now] + 1) {
                cache[now-1] = cache[now] + 1;
                queue.add(now - 1);
            }
            if(now+a <= MAX && cache[now+a] > cache[now] + 1) {
                cache[now+a] = cache[now] + 1;
                queue.add(now + a);
            }
            if(now+b <= MAX && cache[now+b] > cache[now] + 1) {
                cache[now+b] = cache[now] + 1;
                queue.add(now + b);
            }
            if(now-a >= 0 && cache[now-a] > cache[now] + 1) {
                cache[now-a] = cache[now] + 1;
                queue.add(now - a);
            }
            if(now-b >= 0 && cache[now-b] > cache[now] + 1) {
                cache[now-b] = cache[now] + 1;
                queue.add(now - b);
            }
            if(now*a <= MAX && cache[now*a] > cache[now] + 1) {
                cache[now*a] = cache[now] + 1;
                queue.add(now *a);
            }
            if(now*b <= MAX && cache[now*b] > cache[now] + 1) {
                cache[now*b] = cache[now] + 1;
                queue.add(now *b);
            }
        }

        System.out.println(cache[end]);
    }
}