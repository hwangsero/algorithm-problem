import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public boolean equals(Object a) {
			Point obj = (Point) a;
			return (obj.x == this.x && obj.y == this.y);
		}
		
		public int hashCode() {
			return x + y;
		}
	}
	
	static final int ARCHER_CNT = 3;
	static int row;
	static int col;
	static int[] dx = {0, -1, 0};
	static int[] dy = {-1, 0, 1};
	static int[][] map;
	static int[][] d;
	static boolean[][] visitied;
	static int range;
	static Set<Point> animy;
	static int max = 0;
	static int Tcnt = 0;
	
	public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        range = sc.nextInt();
        map = new int[row][col];
        d = new int[row][col];
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		map[i][j] = sc.nextInt();
        		d[i][j] = map[i][j];
        	}
        }
        archerDraw(new int[3], 0, 0);
        System.out.println(max);
        
	}
	// 게임은 행만큼만 수행될거임
	public static void game(int[] a, int r, int c) {
		if(r == 0) {
			max = Math.max(Tcnt, max);
			return;
		}
		animy = new HashSet<Main.Point>();
		for(int ac : a) {
			visitied = new boolean[row][col];
			attack(new Point(r,ac), animy, r, c);
		}
		for(Point p : animy) {
			map[p.x][p.y] = 0;
			Tcnt++;
		}
		game(a, r-1, c);
	}
	
	public static void attack(Point archer, Set<Point> animy, int r, int c) {
		Queue<Point> queue = new LinkedList<Main.Point>();
		queue.offer(archer);
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int i = 0; i < 3; i++) {
				int rx = p.x + dx[i];
				int ry = p.y + dy[i];
				if(rx < 0 || rx >= r || ry < 0 || ry >= c)
					continue;
				if((int)Math.abs(rx - archer.x) + (int)Math.abs(ry - archer.y) > range)
					continue;
				if(visitied[rx][ry]) continue;
				visitied[rx][ry] = true;
				if(map[rx][ry] == 1) {
					animy.add(new Point(rx,ry));
					return;
				}
				queue.offer(new Point(rx,ry));
			}
		}
	}
	
	
	public static void archerDraw(int[] a, int cnt, int idx) {
		if(cnt == ARCHER_CNT) {
			Tcnt = 0;
			for(int i = 0; i < row; i++) {
				for(int j =0;j < col; j++) {
					map[i][j] = d[i][j];
				}
			}
			game(a, row, col);
			return;
		}
		if(idx == col) return;
		archerDraw(a, cnt, idx+1);
		a[cnt] = idx;
		archerDraw(a, cnt+1, idx+1);
		
	}
}