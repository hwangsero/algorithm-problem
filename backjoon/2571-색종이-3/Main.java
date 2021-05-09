import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.Pipe;
import java.text.ParseException;
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

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int row, col;
    static int[][] map;
    static int[][] val;
    static int totalTarget, endTarget;
    static Point point;
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        row = 100;
        col = 100;
        map = new int[100][100];
        val = new int[100][100];
        while(k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int i = 0; i < 10; i++) {
                for(int j = 0; j < 10; j++) {
                    map[x+i][y+j] = 1;
                }
            }
        }

        for(int i =0 ; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int x = i;
                int y = j;
                int count = 0;
                while(isValid(x,y) && map[x][y] == 1) {
                    y -= 1;
                    count++;
                }
                val[i][j] = count;
            }
        }

        int max =0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(val[i][j] == 0) continue;
                int high = 1;
                int width = val[i][j];
                int x = i;
                int y = j;
                while(isValid(x,y) && val[x][y] != 0) {
                    width = Math.min(width, val[x][y]);
                    max = Math.max(high * width,max);
                    x -= 1;
                    high++;
                }
            }
        }
        System.out.println(max);
    }



    public static boolean isValid(int x, int y) {
        if(x >= 0 && x < row && y >= 0 && y < col) return true;
        return false;
    }

}
