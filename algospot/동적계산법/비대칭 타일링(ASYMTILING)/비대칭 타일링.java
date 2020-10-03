import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] map;
	static int[] cache;
	static int n;
	static int mod = 1000000007;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while(k-- > 0) {
			int n = sc.nextInt();
			cache = new int[n+1];
			Arrays.fill(cache, -1);
			tiling(n);
			System.out.println(asymmetric(n));
		}
	}
	
	public static int tiling(int width) {
		if(width <= 1) return 1;
		
		if(cache[width] != -1) return cache[width];
		return cache[width] = (tiling(width-1) + tiling(width-2)) % mod;
	}
	
	public static int asymmetric(int width) {
		if(width % 2 == 1)
			return (tiling(width) - tiling(width/2) + mod) % mod;
		cache[width] = (cache[width] - tiling(width/2) + mod) % mod;
		cache[width] = (cache[width] - tiling(width/2-1) + mod) % mod;
		return cache[width];
	}
}