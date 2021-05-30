import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {


    static int n, k;
    static boolean[] isPrime;
    static List<Integer> primes;
    static int[] cache;
    static final int MOD = 123456789;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        while(k-- > 0) {
            min = Integer.MAX_VALUE;
            int[][] map = new int[3][3];
            for(int i = 0; i < 3; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 3; j++) {
                    if(st.nextToken().equals("H"))
                        map[i][j] = 1;
                    else
                        map[i][j] = 0;
                }
            }
            go(0, 0, map);
            if(min == Integer.MAX_VALUE) min = -1;
            System.out.println(min);
        }
    }

    static int min;
    public static void go(int index, int count,int[][] map) {
        if(checkEnd(map)) {
            min = Math.min(min, count);
            return;
        }
        if(index == 8) return;

        go(index+1,count,map);
        if(index < 3) {
            for(int i = 0; i < 3; i++) {
                map[index][i] = 1 - map[index][i];
            }
            go(index + 1, count + 1, map);
            for(int i = 0; i < 3; i++) {
                map[index][i] = 1 - map[index][i];
            }
        }
        else if(index < 6) {
            int col = index-3;
            for(int i = 0; i < 3; i++) {
                map[i][col] = 1 - map[i][col];
            }
            go(index + 1, count + 1, map);
            for(int i = 0; i < 3; i++) {
                map[i][col] = 1 - map[i][col];
            }
        } else if(index == 6) {
            for(int i = 0; i < 3; i++) {
                map[i][i] = 1 - map[i][i];
            }
            go(index + 1, count + 1, map);
            for(int i = 0; i < 3; i++) {
                map[i][i] = 1 - map[i][i];
            }
        } else if(index == 7) {
            for(int i = 0; i < 3; i++) {
                map[i][2-i] = 1 - map[i][2-i];
            }
            go(index + 1, count + 1, map);
            for(int i = 0; i < 3; i++) {
                map[i][2-i] = 1 - map[i][2-i];
            }
        }

    }

    public static boolean checkEnd(int[][] map) {
        int val = map[0][0];

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(map[i][j] != val) return false;
            }
        }
        return true;
    }
}