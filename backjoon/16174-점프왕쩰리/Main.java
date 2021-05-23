import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    static int n;
    static int[][] map;
    static int[] dx = {1,0};
    static int[] dy = {0,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String result = "Hing";
        if(go()) result = "HaruHaru";
        System.out.println(result);
    }

    public static boolean go() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(0);
        visited[0][0] = true;
        while(!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            int val = map[x][y];
            if(x == n-1 && y == n-1) return true;

            for(int i = 0; i < 2; i++) {
                int nx = x + dx[i] * val;
                int ny = y + dy[i] * val;

                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(nx);
                    queue.add(ny);
                }
            }
        }
        return false;
    }
}