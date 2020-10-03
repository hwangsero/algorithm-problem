
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[][] cache;
	static int[][] countCache;
	static int n;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while(k-- > 0) {
			n = sc.nextInt();
			cache = new int[n][n];
			countCache = new int[n][n];
			map = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j <= i; j++) {
					map[i][j] = sc.nextInt();
					cache[i][j] = -1;
					countCache[i][j] = -1;
				}
			}
			go(0, 0);
			System.out.println(go2(0,0));
		}
	}
	
	public static int go(int x, int y) {
		if(x == n-1) return cache[x][y] = map[x][y];
		if(cache[x][y] != -1) return cache[x][y];
		return cache[x][y] = Math.max(go(x+1, y), go(x+1, y+1)) + map[x][y];
	}
	
	public static int go2(int x, int y) {
		if(x== n-1) return 1;
		int max = Math.max(cache[x+1][y], cache[x+1][y+1]);
		if(countCache[x][y] != -1) return countCache[x][y];
		countCache[x][y] = 0;
		if(cache[x+1][y] == max)
			countCache[x][y] += go2(x+1, y);
		if(cache[x+1][y+1] == max)
			countCache[x][y] += go2(x+1, y+1);
		return countCache[x][y];
	}
}