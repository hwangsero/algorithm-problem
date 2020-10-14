import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int n;
	static int[] board;
	static int[][] cache;
	static final int EMPTY = -100000;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while(k-- > 0) {
			n = sc.nextInt();
			board = new int[n];
			cache = new int[n][n];
			for(int i = 0; i < n; i++) {
				board[i] = sc.nextInt();
				Arrays.fill(cache[i], EMPTY);
			}
			System.out.println(numberGame(0, n-1));
		}
	}
	
	public static int numberGame(int left, int right) {
		if(left > right) return 0;
		if(cache[left][right] != EMPTY) return cache[left][right];
		
		int ans = EMPTY;
		ans = Math.max(board[left] - numberGame(left+1, right), board[right] - numberGame(left, right-1));
		if(right-left+1 >= 2) {
			ans = Math.max(ans, -numberGame(left+2, right));
			ans = Math.max(ans, -numberGame(left, right-2));
		}
		return cache[left][right] = ans;
	}
}