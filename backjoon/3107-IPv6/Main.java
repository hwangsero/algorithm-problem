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
        String str = br.readLine();
        List<String> list = new LinkedList<>();
        String[] strs = str.split(":");
        int index = -1;
        for(int i = 0; i < strs.length; i++) {
            if(index==-1 && strs[i].equals("")) {
                index = i;
                continue;
            }
            String s = strs[i];
            while(s.length() < 4) {
                s = "0" + s;
            }
            list.add(s);
        }
        while(list.size() < 8) {
            if(index == -1) list.add(list.size(), "0000");
            else list.add(index, "0000");
        }
        String result = String.join(":", list);
        System.out.println(result);

    }

}