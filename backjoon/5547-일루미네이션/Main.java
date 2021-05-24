import java.io.*;
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

    static int row,col;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        set.add(1);
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int index = 2;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(map[i][j] == 0)
                    check(i,j, index++);
            }
        }

        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(map[i][j] == 1) {
                    ans += go(i, j);
                }
            }
        }
        System.out.println(ans);
    }

    static int[] dx1 = {-1, 1, 0, 0, -1, 1};
    static int[] dy1 = {0, 0, -1, 1, 1, 1};
    static int[] dx2 = {-1, 1, 0, 0, -1, 1};
    static int[] dy2 = {0, 0, -1, 1, -1, -1};
    static Set<Integer> set = new HashSet<>();
    public static void check(int x, int y, int number) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        map[x][y] = number;

        boolean isOk = true;
        while(!queue.isEmpty()) {
            int r = queue.poll();
            int c = queue.poll();
            map[r][c] = number;
            if(r % 2 == 0) {
                for(int i = 0; i < 6; i++) {
                    int nx = r + dx1[i];
                    int ny = c + dy1[i];
                    if(!isValid(nx,ny)) {
                        isOk = false;
                        continue;
                    }
                    if(map[nx][ny] == 0 ) {
                        map[nx][ny] = number;
                        queue.add(nx);
                        queue.add(ny);
                    }
                }
            } else {
                for(int i = 0; i < 6; i++) {
                    int nx = r + dx2[i];
                    int ny = c + dy2[i];
                    if(!isValid(nx,ny)) {
                        isOk = false;
                        continue;
                    }
                    if(map[nx][ny] == 0) {
                        map[nx][ny] = number;
                        queue.add(nx);
                        queue.add(ny);
                    }
                }
            }
        }
        if(isOk) set.add(number);

    }

    public static boolean isValid(int x, int y) {
        if(x >= 0 && x< row && y >= 0 && y < col) return true;
        return false;
    }

    public static int go(int x, int y) {
        int count = 0;
        // 상, 하, 좌, 우
        if(x == 0 || !set.contains(map[x-1][y])) count++;
        if(x == row-1 || !set.contains(map[x+1][y])) count++;
        if(y == 0 || !set.contains(map[x][y-1])) count++;
        if(y == col-1 || !set.contains(map[x][y+1])) count++;

        if(x % 2 == 0) {
            if(x == 0 || y == col-1 || !set.contains(map[x-1][y+1])) count++;
            if(x == row-1 || y == col-1 || !set.contains(map[x+1][y+1])) count++;
        } else {
            if(x == 0 || y == 0 || !set.contains(map[x-1][y-1] )) count++;
            if(x == row-1 || y == 0 || !set.contains(map[x+1][y-1])) count++;
        }
        return count;
    }
}