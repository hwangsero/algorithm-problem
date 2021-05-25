import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    static int n;
    static int[][] map;
    static int[][][] cache;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        cache = new int[n][n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(cache[i][j], -1);
            }
        }
        System.out.println(go(0, 0, 0));

    }

    public static int go(int x, int y, int milk) {
        if (x == n - 1 && y == n - 1) {
            return map[x][y] == milk ? 1 : 0;
        }

        if(cache[x][y][milk] != -1) return cache[x][y][milk];

        int ans = 0;
        if (y + 1 < n) {
            if(map[x][y] == milk)
                ans = Math.max(ans, go(x, y + 1, (milk + 1) % 3) + 1);
            else
                ans = Math.max(ans, go(x, y + 1, milk));
        }
        if(x+1 < n) {
            if(map[x][y] == milk)
                ans = Math.max(ans, go(x + 1, y, (milk + 1) % 3) + 1);
            else
                ans = Math.max(ans, go(x + 1, y, milk));
        }
        return cache[x][y][milk] = ans;
    }
}