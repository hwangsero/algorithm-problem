
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[][] cache;
	static int n;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while(k-- > 0) {
			n = sc.nextInt();
			map = new int[n][n];
			cache = new int[n][n];
			for(int i = 0; i < n; i++) {
				Arrays.fill(cache[i], -1);
				for(int j = 0; j <= i; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			 System.out.println(goUp(0, 0));
		}
	}
	
	static int goUp(int x, int y) {
		if(x == n-1) return map[x][y];
		if(cache[x][y] != -1) return cache[x][y];
		return cache[x][y] = map[x][y] + Math.max(goUp(x+1, y), goUp(x+1, y+1));
	}
}
