import java.util.*;

class Solution {

    public int[][] generateMatrix(int n) {
        int[][] map = new int[n][n];
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int x = 0;
        int y = 0;
        int dir = 0;
        int value = 1;
        while(value <= n*n) {
            map[x][y] = value++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
        }
        return map;
    }
}