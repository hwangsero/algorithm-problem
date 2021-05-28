import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    static int n;
    static int[][] map;
    static int[] dx = {1,0};
    static int[] dy = {0,1};
    static int[][] cache;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        cache = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                cache[i][j] = -1;
            }
        }
        System.out.println(go(0,0));
    }

    public static int go(int x, int y) {
        if(x == n-1 && y == n-1) return 0;

        if(cache[x][y] != -1) return cache[x][y];
        int ans = 223*2222;
        for(int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if(map[x][y] > map[nx][ny])
                    ans = Math.min(ans,go(nx,ny));
                else
                    ans = Math.min(ans,go(nx,ny) + map[nx][ny] - map[x][y] + 1);
            }
        }
        return cache[x][y] = ans;
    }
}