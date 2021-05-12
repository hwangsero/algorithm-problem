import java.util.*;

class Solution {
    int row;
    int col;
    int[][] matrix;
    boolean[][] visited;
    public void rotate(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        this.matrix = matrix;
        visited = new boolean[row][col];
        for(int i =0 ; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(!visited[i][j])
                    go(i, j, matrix[i][j]);
            }
        }

    }

    public void go(int x, int y, int val) {

        int nx = y;
        int ny = col - 1 - x;
        if(visited[nx][ny]) return;
        visited[nx][ny] = true;
        int nextVal = matrix[nx][ny];
        matrix[nx][ny] = val;
        go(nx, ny, nextVal);
        
    }
}