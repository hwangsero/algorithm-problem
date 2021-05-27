import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    static int row, col;
    static int[][] map;
    static boolean isEnd = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        row = n * 2;
        col = n * 2;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = row - Integer.parseInt(st.nextToken()) ;
        map = new int[row][col];
        map[x][y] = -1;
        go(0, 1);
        if(!isEnd) System.out.println(-1);

    }

    public static void go(int index, int number) {
        if(isEnd) return;
        if(index == row*col) {

            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        isEnd = true;
            return;
        }

        int x = index / col;
        int y = index % col;
        if(map[x][y] != 0) {
            go(index+1, number);
            return;
        }
        if(y+1 < col && x+1<row && map[x][y+1] == 0 && map[x+1][y+1] == 0) {
            map[x][y] = map[x][y+1] = map[x+1][y+1] = number;
            go(index+1, number+1);
            map[x][y] = map[x][y+1] = map[x+1][y+1] = 0;
        }
        if(x+1 < row && y+1 < col && map[x+1][y] == 0 && map[x+1][y+1] == 0) {
            map[x][y] = map[x+1][y] = map[x+1][y+1] = number;
            go(index+1, number+1);
            map[x][y] = map[x+1][y] = map[x+1][y+1] = 0;
        }
        if(x+1 < row && y+1 < col && map[x+1][y] == 0 && map[x][y+1] == 0) {
            map[x][y] = map[x+1][y] = map[x][y+1] = number;
            go(index+1, number+1);
            map[x][y] = map[x+1][y] = map[x][y+1] = 0;
        }
        if(x+1 < row && y-1 >= 0 && map[x+1][y] == 0 && map[x+1][y-1] == 0) {
            map[x][y] = map[x+1][y] = map[x+1][y-1] = number;
            go(index+1, number+1);
            map[x][y] = map[x+1][y] = map[x+1][y-1] = 0;
        }

    }
}