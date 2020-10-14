import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int M = 1000000000+100;
	static int[][] biNums;
	static int[][] cache;
	static int skip;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		while(c-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			skip = k-1;
			biNums = new int[201][201];
			cache = new int[101][101];
			for(int i = 0; i < 101; i++) {
				Arrays.fill(cache[i], -1);
			}
			setBiNums();
			recursive(n, m, "");
		}
	}
	
	static void recursive(int n, int m, String s) {
		if(skip < 0) return;
		if(n== 0 && m == 0) {
			if(skip == 0) System.out.println(s);
			skip--;
			return;
		}
		
		if(skip >= biNums[n+m][n]) {
			skip -= biNums[n+m][n];
			return;
		}
		if(n > 0) recursive(n-1, m, s + "-");
		if(m > 0) recursive(n, m-1, s + "o");
	}
	
	static void setBiNums() {
		for(int i = 0; i <= 200; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0 || j == i) {
					biNums[i][j] = 1;
					continue;
				}
				biNums[i][j] = Math.min(M, biNums[i-1][j-1] + biNums[i-1][j]);
			}
		}
	}
}