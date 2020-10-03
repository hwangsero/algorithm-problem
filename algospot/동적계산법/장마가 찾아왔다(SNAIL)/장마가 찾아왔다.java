import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int max = 1000;
	static double[][] cache;
	static int n;
	static int m;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while(k-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			cache = new double[max+1][2*(max+1)];
			for(int i = 0; i < cache.length; i++)
				Arrays.fill(cache[i], -1);
			System.out.println(climb(0, 0));
		}
	}
	
	static double climb(int days, int climbed) {
		if(days == m) return climbed >= n ? 1 : 0;
		if(cache[days][climbed] != -1)
			return cache[days][climbed];
		return cache[days][climbed] = 0.25 * climb(days+1,climbed+1) + 0.75 * climb(days+1, climbed+2);
	}
}
