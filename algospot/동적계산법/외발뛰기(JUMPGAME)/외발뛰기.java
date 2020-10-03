import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static int[][] map;
	static int[][] cache;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while(k-- > 0) {
			n = sc.nextInt();
			map = new int[n][n];
			cache = new int[n][n];
			for(int i = 0; i < n; i++) {
				Arrays.fill(cache[i], -1);
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int result = jump(0, 0);
			System.out.println((result != 0 && result != -1) ? "YES" : "NO");
		}
	}
	
	static int jump(int x, int y) {
		if(x >= n || y >= n) return 0;
		if(x == n-1 && y == n-1) return 1;
		if(cache[x][y] != -1) return cache[x][y];
		int jumpSize = map[x][y];
		return cache[x][y] = jump(x + jumpSize, y) + jump(x, y + jumpSize);
	}
}
