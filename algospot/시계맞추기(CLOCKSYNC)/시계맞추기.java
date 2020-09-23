
import java.util.Scanner;

public class Main {
	
	final static int CLOCK_CNT = 16;
	final static int SWITCH_CNT = 10;
	final static char[][] LINKED = {
			{'x','x','x','.','.','.','.','.','.','.','.','.','.','.','.','.'},
			{'.','.','.','x','.','.','.','x','.','x','.','x','.','.','.','.'},
			{'.','.','.','.','x','.','.','.','.','.','x','.','.','.','x','x'},
			{'x','.','.','.','x','x','x','x','.','.','.','.','.','.','.','.'},
			{'.','.','.','.','.','.','x','x','x','.','x','.','x','.','.','.'},
			{'x','.','x','.','.','.','.','.','.','.','.','.','.','.','x','x'},
			{'.','.','.','x','.','.','.','.','.','.','.','.','.','.','x','x'},
			{'.','.','.','.','x','x','.','x','.','.','.','.','.','.','x','x'},
			{'.','x','x','x','x','x','.','.','.','.','.','.','.','.','.','.'},
			{'.','.','.','x','x','x','.','.','.','x','.','.','.','x','.','.'},
	};
	final static int INF = 9999;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while(k-- > 0) {
			int[] clocks = new int[CLOCK_CNT];
			for(int i = 0; i < CLOCK_CNT; i++) {
				clocks[i] = sc.nextInt();
			}
			int result = solve(clocks, 0);
			if(result >= INF) System.out.println(-1);
			else System.out.println(result);
		}
	}
	
	public static void push(int[] clocks, int swtch) {
		for(int i = 0; i < CLOCK_CNT; i++) {
			if(LINKED[swtch][i] == '.') continue;
			clocks[i] += 3;
			if(clocks[i] == 15) clocks[i] = 3;
		}
	}
	
	public static int solve(int[] clocks, int swtch) {
		if(SWITCH_CNT == swtch) {
			boolean ok = true;
			for(int i = 0; i < CLOCK_CNT; i++) {
				if(clocks[i] != 12) {
					ok = false;
					break;
				}
			}
			return ok ? 0 : INF;
			
		}
		
		int ans = INF;
		for(int cnt = 0; cnt < 4; cnt++) {
			ans = Math.min(ans, cnt + solve(clocks, swtch+1));
			push(clocks, swtch);
		}
		return ans;
	}
}