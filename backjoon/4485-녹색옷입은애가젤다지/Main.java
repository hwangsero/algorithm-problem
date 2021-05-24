import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int[][] map;
    static char[] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int[][] cache;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index= 0;
        while(true) {
            index++;
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            map = new int[n][n];
            visited = new boolean[n][n];
            cache = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(cache[i],Integer.MAX_VALUE);
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(0, 0));
            cache[0][0] = map[0][0];
            while(!queue.isEmpty()) {
                Point now = queue.poll();
                int x = now.x;
                int y = now.y;

                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(isValid(nx,ny) && cache[x][y] + map[nx][ny] < cache[nx][ny]) {
                        queue.add(new Point(nx, ny));
                        cache[nx][ny] = cache[x][y] + map[nx][ny];

                    }
                }
            }
            System.out.println("Problem " + index + ": " + cache[n-1][n-1]);
        }
    }


    public static boolean isValid(int x, int y) {
        if(x >= 0 && x < n && y >= 0 && y < n) return true;
        return false;
    }
}