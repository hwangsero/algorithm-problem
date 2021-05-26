import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    static int n;
    static int[][] map;
    static char[] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(go(0, 0, 0));
    }

    public static int go(int index, int count, int cost) {
        if(count == 3) return cost;
        if(index == n * n) return Integer.MAX_VALUE;

        int x = index / n;
        int y = index % n;
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, go(index + 1, count, cost));
        if (x - 1 >= 0 && x + 1 < n && y - 1 >= 0 && y + 1 < n) {
            if(!visited[x][y] && !visited[x-1][y] && !visited[x+1][y] && !visited[x][y-1] && !visited[x][y+1]) {
                int sum = map[x][y] + map[x - 1][y] + map[x + 1][y] + map[x][y - 1] + map[x][y + 1];
                visited[x][y] = visited[x-1][y] = visited[x+1][y] = visited[x][y-1] = visited[x][y+1] = true;
                ans = Math.min(ans, go(index + 1, count + 1, cost + sum));
                visited[x][y] = visited[x-1][y] = visited[x+1][y] = visited[x][y-1] = visited[x][y+1] = false;
            }
        }
        return ans;
    }
}