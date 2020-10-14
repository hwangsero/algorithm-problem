import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int n = 3;
	static int[] cache;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while(k-- > 0) {
			char[][] map = new char[n][n];
			cache = new int[19683];
			Arrays.fill(cache, -2);
			int x = 0;
			int o = 0;
			for(int i = 0; i < n; i++) {
				String str = sc.next();
				for(int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == 'x') x++;
					if(map[i][j] == 'o') o++;
				}
			}
			char turn = 'x';
			if(x > o) turn = 'o';
			int r = canWin(map, turn);
			if(r == 0) System.out.println("TIE");
			if(r == -1) System.out.println((char)('o' + 'x' - turn));
			if(r == 1) System.out.println(turn);
			
		}
	}
	
	public static int canWin(char[][] map, char turn) {
		if(isFinish(map, (char)('o' + 'x' - turn))) return -1;
		int c = bijection(map);
		if(cache[c] != -2) return cache[c];
		int minValue = 2;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == '.') {
					map[i][j] = turn;
					minValue = Math.min(minValue, canWin(map, (char)('o' + 'x' - turn)));
					map[i][j] = '.';
				}
			}
		}
		if(minValue == 2 || minValue == 0) minValue = 0;
		return cache[c] = -minValue;
	}
	
	public static boolean isFinish(char[][] map, char turn) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] != turn) break;
				if(j == 2) return true;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[j][i] != turn) break;
				if(j == 2) return true;
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(map[i][i] != turn) break;
			if(i == 2) return true;
		}
		
		for(int i = 0; i < n; i++) {
			if(map[i][2-i] != turn) break;
			if(i == 2) return true;
		}
		return false;
	}
	
	public static int bijection(char[][] map) {
		int ans = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				ans *= 3;
				if(map[i][j] == 'o') ans += 1;
				if(map[i][j] == 'x') ans += 2;
			}
		}
		return ans;
	}
}