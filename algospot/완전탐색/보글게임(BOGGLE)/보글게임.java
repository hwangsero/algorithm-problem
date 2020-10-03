import java.util.Scanner;

public class Main {
	
	static class Point {
		int x;
		int y;
		int idx;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n = 5;
	static char[][] map;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while(k-- > 0) {
			StringBuffer sb = new StringBuffer();
			map = new char[n][n];
			for(int i = 0; i < n; i++) {
				String str = sc.next();
				map[i] = str.toCharArray();
			}
			int c = sc.nextInt();
			while(c-- > 0) {
				String word = sc.next();
				boolean result = solve(word);
				String ans = "";
				if(result) ans = "YES";
				else ans = "NO";
				sb.append(word).append(" " + ans + "\n");
			}
			System.out.println(sb);
		}
	}
	
	public static boolean solve(String word) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(dfs(new Point(i,j),word)){
					return true;
				}
			}
		}
		return false;
	}
	
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,-1,-1,-1,0,1,1,1};
	public static boolean dfs(Point now, String word) {
		if(map[now.x][now.y] != word.charAt(0)) return false;
		if(word.length() == 1) return true;
		
		for(int i = 0; i < 8; i++) {
			int rx = now.x + dx[i];
			int ry = now.y + dy[i];
			
			if(rx >= 0 && rx < n && ry >= 0 && ry < n) {
					if(dfs(new Point(rx,ry), word.substring(1)))
						return true;;
			}
		}
		return false;
	}
}