import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    static int row,col;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        visited = new boolean[row][col];
        for(int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    go(i,j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void go(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(x);
        queue.add(y);
        while(!queue.isEmpty()) {
            int a = queue.poll();
            int b = queue.poll();
            for(int i = 0; i < 8; i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];
                if(nx >= 0 && nx < row && ny >= 0 && ny < col
                && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(nx);
                    queue.add(ny);
                }
            }
        }
    }
}